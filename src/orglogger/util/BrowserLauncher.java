package orglogger.util;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import orglogger.model.Login;


public class BrowserLauncher {

    private static Desktop desktop= Desktop.getDesktop();
    private final static String URL_TEMPLATE = "{url}/login.jsp?pw={password}&un={username}"; 
    
    public static void  launchSalesforceLoginPage( String url ){
        
        URI salesforceUri;
        try {
            salesforceUri = new URI(url);
            try {
                desktop.browse(salesforceUri);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    
    
    public static void loginIntoSalesforce(Login userLogin){
        
        String urlLogin = URL_TEMPLATE.replaceAll("\\{username\\}", userLogin.getUsername())
                            .replaceAll("\\{password\\}", userLogin.getPassword())
                            .replaceAll("\\{url\\}", userLogin.getUrl());
        launchSalesforceLoginPage(urlLogin); 
    }
    
}
