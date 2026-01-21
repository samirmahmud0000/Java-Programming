package secureguard.validator;

public class XSSValidator {

    public static boolean isSafe(String input) {
        return !(input.contains("<script>") ||
                 input.contains("</script>") ||
                 input.contains("javascript:"));
    }
}
