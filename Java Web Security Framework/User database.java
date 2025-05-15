import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, String> roles = new HashMap<>();

    static {
        users.put("admin", "admin123");
        roles.put("admin", "ADMIN");

        users.put("user", "user123");
        roles.put("user", "USER");
    }

    public static boolean isValid(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static String getRole(String username) {
        return roles.get(username);
    }
}
