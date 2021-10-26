package ua.com.alevel;

public final class StringReverseUtil {
    private StringReverseUtil() { }

    public static String reverse(String text, boolean full) {
        return new StringBuilder(text).reverse().toString();
    }
}
