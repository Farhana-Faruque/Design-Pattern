class CustomerReport extends Report {
    public CustomerReport(Formatter formatter) {
        super(formatter);
    }

    @Override
    public void generate() {
        String title = "Customer Summary";
        String content = "100 customers\n80 active";
        System.out.println(formatter.format(title, content));
    }
}