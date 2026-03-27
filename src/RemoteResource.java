public class RemoteResource implements IResource {

    public void getResponse(Request request) {
        System.out.println();
        System.out.println("Request id: "+request.getReq_id());
        System.out.println("Generating response.");
        System.out.println("200. Response: "+request.getReq());
    }
}
