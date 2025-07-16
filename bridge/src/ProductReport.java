class ProductReport extends Report {
    public ProductReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public void generate() {
        String title = "Product Inventory";
        String content = "50 products\n10 low in stock";
        System.out.println(formatter.format(title, content));
    }
}