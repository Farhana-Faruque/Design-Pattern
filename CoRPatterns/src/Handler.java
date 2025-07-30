interface Handler {
    Handler setNext(Handler handler);
    void handle(Request request);
}