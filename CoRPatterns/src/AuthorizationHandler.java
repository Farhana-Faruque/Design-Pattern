class AuthorizationHandler extends BaseHandler {
    public void handle(Request request) {
        System.out.println("Executing: AuthorizationHandler");
        if ("admin".equalsIgnoreCase(request.usertype)) {
            super.handle(request);
        } else {
            System.out.println("Authorization failed for usertype: " + request.usertype);
        }
    }
}