package secureguard.validator;

import java.util.regex.*;

public class EmailValidator {

    public static boolean isValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }
}
