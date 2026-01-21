package secureguard.validator;

import java.util.regex.*;

public class PasswordValidator {

    public static boolean isStrong(String password) {
        if (password.length() < 8) return false;

        String regex =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
                "(?=.*[@#$%^&+=!]).{8,}$";

        return Pattern.matches(regex, password);
    }
}
