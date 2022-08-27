package domain;

public class User {
    private String username,password;

    public User(String username, String password){
        this.username=username;
        this.password=username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
