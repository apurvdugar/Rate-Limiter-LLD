public class Request {

    int req_id;
    String req;

    public Request(int req_id, String req) {
        this.req_id = req_id;
        this.req = req;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}
