package accident.model;

public class User {

    private String password;
    private String username;

    private boolean enabled;

    public User(String password, String username, boolean enabled) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
    }

    public User() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
