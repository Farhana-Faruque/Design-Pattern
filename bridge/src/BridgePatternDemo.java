public class BridgePatternDemo {
    public static void main(String[] args) {
        Formatter pdf = new PDFFormatter();
        Formatter csv = new CSVFormatter();

        Report sales = new SalesReport(pdf);
        Report customers = new CustomerReport(csv);
        Report products = new ProductReport(pdf);

        System.out.println("--- Sales Report in PDF ---");
        sales.generate();

        System.out.println("\n--- Customer Report in CSV ---");
        customers.generate();

        System.out.println("\n--- Product Report in PDF ---");
        products.generate();
    }
}
