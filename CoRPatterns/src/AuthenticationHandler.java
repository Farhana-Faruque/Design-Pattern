class AuthenticationHandler extends BaseHandler {
    public void handle(Request request) {
        System.out.println("Executing: AuthenticationHandler");
        if (request.userid != null && !request.userid.isEmpty()) {
            super.handle(request);
        } else {
            System.out.println("Authentication failed: Missing user ID.");
        }
    }
}