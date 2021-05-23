package Help;

import java.util.regex.Pattern;

public class Validation {
    private static Pattern numberPattern = Pattern.compile("^\\d+$");

    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        return numberPattern.matcher(input).matches();
    }

    public static boolean isAlphaNumeric(String str) {
        return str != null && str.matches("^[a-zA-Z0-9]+$");
    }

}
