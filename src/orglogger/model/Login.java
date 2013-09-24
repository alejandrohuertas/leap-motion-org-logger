package orglogger.model;

public class Login {

    private String username;
    private String password;
    private String url;
    
    public Login (String username, String password, String url){
        this.setPassword(password);
        this.setUsername(username);
        this.setUrl(url);
        
    }
    public Login (){
        this(null, null, null);
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
