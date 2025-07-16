public class TextFormat {
    private String font;
    private int size;
    private String style;

    public TextFormat(String font, int size, String style) {
        this.font = font;
        this.size = size;
        this.style = style;
    }

    public String getFormatDetails() {
        return font + ", " + size + "pt, " + style;
    }
}
