
package backend;


public abstract class Account {
    private String email;
    private String username;
    private String userId;

    public Account(String email, String username, String userId) {
        this.email = email;
        this.username = username;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }

    public String getUserId() {
        return userId;
    }
}
