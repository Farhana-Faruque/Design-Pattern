import java.util.HashMap;
import java.util.Map;

public class TextFormatFactory {
    private static final Map<String, TextFormat> formats = new HashMap<>();

    public static TextFormat getTextFormat(String font, int size, String style) {
        String key = font + size + style;
        if (!formats.containsKey(key)) {
            formats.put(key, new TextFormat(font, size, style));
        }
        return formats.get(key);
    }
}
