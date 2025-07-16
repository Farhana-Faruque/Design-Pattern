public class CheckoutFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private OrderService orderService;
    private ShippingService shippingService;

    public CheckoutFacade() {
        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        orderService = new OrderService();
        shippingService = new ShippingService();
    }

    public void checkout(String item, double price) {
        inventoryService.checkInventory(item);
        paymentService.processPayment(price);
        orderService.logOrder(item);
        shippingService.scheduleShipping(item);
        System.out.println("Checkout complete.");
    }
}