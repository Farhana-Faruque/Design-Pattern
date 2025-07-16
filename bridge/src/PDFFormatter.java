class PDFFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "PDF FORMAT\n==============\nTitle: " + title + "\nContent: " + content;
    }
}

