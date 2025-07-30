public class ChainPatternDemo {
    public static void main(String[] args) {
        Handler auth = new AuthenticationHandler();
        Handler authorize = new AuthorizationHandler();
        Handler validate = new ValidationHandler();
        Handler cache = new CachingHandler();

        auth.setNext(authorize).setNext(validate).setNext(cache);

        Request r1 = new Request("U1", "REQ001", "admin", "addproduct", "Orange, 80");
        Request r2 = new Request("U2", "REQ002", "staff", "addproduct", "Apple, 100");
        Request r3 = new Request("U3", "REQ003", "admin", "getproducts", "");
        Request r4 = new Request("U3", "REQ003", "admin", "getproducts", "Mango, 60");
        Request r5 = new Request("U5", "REQ005", "admin", "addproduct", "InvalidFormat");

        System.out.println("\n--- Request 1 ---");
        auth.handle(r1);

        System.out.println("\n--- Request 2 ---");
        auth.handle(r2);

        System.out.println("\n--- Request 3 ---");
        auth.handle(r3);

        System.out.println("\n--- Request 4 ---");
        auth.handle(r4);

        System.out.println("\n--- Request 5 ---");
        auth.handle(r5);
    }
}