package Common.Help;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Validation implements Serializable {
    /**
     * the class of valid characters for username and password
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021
     *
     */
    private static Pattern numberPattern = Pattern.compile("^\\d+$");

    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        return numberPattern.matcher(input).matches();
    }

    /**
     * this method checks that the parameter matches with regex or not
     * @param str
     * @return
     */
    public static boolean isAlphaNumeric(String str) {
        return str != null && str.matches("^[a-zA-Z0-9]+$");
    }

}
