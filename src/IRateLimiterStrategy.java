import java.time.LocalDateTime;

public interface IRateLimiterStrategy {

    boolean checkRateLimitReached(Request request, LocalDateTime t);
}
