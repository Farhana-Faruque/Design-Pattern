class Request {
    String userid;
    String requestid;
    String usertype;
    String requestType;
    String body;

    public Request(String userid, String requestid, String usertype, String requestType, String body) {
        this.userid = userid;
        this.requestid = requestid;
        this.usertype = usertype;
        this.requestType = requestType;
        this.body = body;
    }

    public void addProduct(String name, double price) {
        ProductStore.products.add(name + " - $" + price);
    }
}