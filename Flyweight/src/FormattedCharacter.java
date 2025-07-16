public class FormattedCharacter {
    private char character;
    private TextFormat textFormat;

    public FormattedCharacter(char character, TextFormat textFormat) {
        this.character = character;
        this.textFormat = textFormat;
    }

    public void print() {
        System.out.println("Char: " + character + " | Format: " + textFormat.getFormatDetails());
    }
}
