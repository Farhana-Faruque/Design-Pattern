class CSVFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "CSV FORMAT\n==============\n\"" + title + "\",\"" + content + "\"";
    }
}