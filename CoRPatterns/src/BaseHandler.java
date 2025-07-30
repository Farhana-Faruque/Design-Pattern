abstract class BaseHandler implements Handler {
    private Handler next;

    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }

    public void handle(Request request) {
        if (next != null) {
            next.handle(request);
        } else {
            System.out.println("No handler could process request: " + request.requestid);
        }
    }
}