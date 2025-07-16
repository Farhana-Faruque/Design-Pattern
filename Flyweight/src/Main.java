public class Main {
    public static void main(String[] args) {
        TextFormat boldArial = TextFormatFactory.getTextFormat("Arial", 12, "Bold");
        TextFormat italicTimes = TextFormatFactory.getTextFormat("Times", 12, "Italic");

        FormattedCharacter c1 = new FormattedCharacter('H', boldArial);
        FormattedCharacter c2 = new FormattedCharacter('e', boldArial);
        FormattedCharacter c3 = new FormattedCharacter('l', boldArial);
        FormattedCharacter c4 = new FormattedCharacter('l', italicTimes);
        FormattedCharacter c5 = new FormattedCharacter('o', italicTimes);

        c1.print();
        c2.print();
        c3.print();
        c4.print();
        c5.print();
    }
}
