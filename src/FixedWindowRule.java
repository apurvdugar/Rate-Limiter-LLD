import java.time.LocalDateTime;

public class FixedWindowRule implements IRateLimiterStrategy {

    private final int allowedRequests;
    private final int windowSize;
    private int currCount;
    private LocalDateTime windowStart;

    public FixedWindowRule(int allowedRequests, int windowSize) {
        this.allowedRequests = allowedRequests;
        this.windowSize = windowSize;
        this.currCount = 0;
        this.windowStart = LocalDateTime.now();
    }

    @Override
    public boolean checkRateLimitReached(Request request, LocalDateTime t) {

        if (windowStart.plusSeconds(windowSize).isBefore(t)) {
            windowStart = windowStart.plusSeconds(windowSize);
            currCount = 0;
        }

        if (currCount >= allowedRequests) {
            return true;
        }

        currCount++;
        return false;
    }
}
