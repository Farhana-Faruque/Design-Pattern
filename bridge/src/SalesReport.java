class SalesReport extends Report {
    public SalesReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public void generate() {
        String title = "Monthly Sales Report";
        String content = "Sales: $20,000\nProfit: $5,000";
        System.out.println(formatter.format(title, content));
    }
}

