package calculator.utils;

public class StringUtil {
    private static final String numberRegex = "^[0-9]*$";

    public static boolean isNumber(String value) {
        return !value.matches(numberRegex);
    }
}
