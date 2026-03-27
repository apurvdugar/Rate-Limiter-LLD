import java.time.LocalDateTime;

public class RemoteResourceProxy implements IResource {
    IRateLimiterStrategy rl;
    RemoteResource rr;

    public RemoteResourceProxy(IRateLimiterStrategy rl) {
        this.rl = rl;
        this.rr = new RemoteResource();
    }

    @Override
    public void getResponse(Request request) {
        if(rl.checkRateLimitReached(request, LocalDateTime.now())){
            System.out.println();
            System.out.println("Request id: "+request.req_id);
            System.out.println("429. Too many requests sent.");
        } else {
            rr.getResponse(request);
        }
    }
}
