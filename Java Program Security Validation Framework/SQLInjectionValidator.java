package secureguard.validator;

public class SQLInjectionValidator {

    public static boolean isSafe(String input) {
        String lower = input.toLowerCase();
        return !(lower.contains(" or ") ||
                 lower.contains("--") ||
                 lower.contains(";") ||
                 lower.contains("drop") ||
                 lower.contains("union"));
    }
}
