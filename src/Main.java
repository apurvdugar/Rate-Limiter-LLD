public class Main {
    public static void main(String[] args) throws InterruptedException {

        RemoteResourceProxy rrp = new RemoteResourceProxy(new SlidingWindowRule(2,4));
        
        for(int i=0;i<10;i++){
            Request r = new Request(i+1, "Hi");

            rrp.getResponse(r);

            Thread.sleep(1000);
        }
    }
}