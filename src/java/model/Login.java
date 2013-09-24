package java.model;

public class Login {

    private String username;
    private String password;
    
    public Login (String username, String password){
        this.setPassword(password);
        this.setUsername(username);
    }
    public Login (){
        this(null, null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
