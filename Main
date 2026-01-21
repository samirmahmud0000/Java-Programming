package secureguard;

import secureguard.validator.*;
import secureguard.utils.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SecureGuard Security Validation Framework ===");

        String password = "P@ssw0rd123!";
        String email = "user@example.com";
        String input = "<script>alert('hack')</script>";
        String sqlInput = "SELECT * FROM users WHERE id=1 OR 1=1";

        System.out.println("Password Valid: " + PasswordValidator.isStrong(password));
        System.out.println("Email Valid: " + EmailValidator.isValid(email));
        System.out.println("XSS Safe: " + XSSValidator.isSafe(input));
        System.out.println("SQL Injection Safe: " + SQLInjectionValidator.isSafe(sqlInput));

        String token = TokenValidator.generateToken();
        System.out.println("Token Valid: " + TokenValidator.isValid(token));
    }
}
