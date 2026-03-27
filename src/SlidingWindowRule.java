import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRule implements IRateLimiterStrategy {

    private final int allowedRequests;
    private final int windowSize; // seconds

    private final Queue<LocalDateTime> requestQueue;

    public SlidingWindowRule(int allowedRequests, int windowSize) {
        this.allowedRequests = allowedRequests;
        this.windowSize = windowSize;
        this.requestQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public synchronized boolean checkRateLimitReached(Request request, LocalDateTime now) {

        LocalDateTime windowStart = now.minusSeconds(windowSize);
        while (!requestQueue.isEmpty() && requestQueue.peek().isBefore(windowStart)) {
            requestQueue.poll();
        }

        if (requestQueue.size() >= allowedRequests) {
            return true;
        }

        requestQueue.offer(now);
        return false;
    }
}