package framework.model;

public class User {
    private final String login;
    private final String password;

    private User(UserBuilder builder) {
        this.login = builder.login;
        this.password = builder.password;
    }

    public static class UserBuilder {
        private final String login;
        private final String password;

        public UserBuilder(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
