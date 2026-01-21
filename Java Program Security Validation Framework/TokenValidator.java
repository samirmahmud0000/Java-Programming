package secureguard.utils;

import java.util.UUID;

public class TokenValidator {

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValid(String token) {
        return token != null && token.length() > 20;
    }
}
