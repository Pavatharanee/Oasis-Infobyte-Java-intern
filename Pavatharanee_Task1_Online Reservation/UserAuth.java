import java.util.HashMap;
import java.util.Map;

public class UserAuth {
    private Map<String, String> users;

    public UserAuth() {
        users = new HashMap<>();
        // Default login credentials (Username, Password)
        users.put("admin", "admin123");
        users.put("pava", "java2026");
    }

    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}