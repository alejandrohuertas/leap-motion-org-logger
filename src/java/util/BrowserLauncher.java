package java.util;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class BrowserLauncher {

    private Desktop desktop;
    
    public BrowserLauncher (){
        desktop = Desktop.getDesktop();
    }
    
    public void launchSalesforceLoginPage(){
        
        URI salesforceUri;
        try {
            salesforceUri = new URI("https://login.salesforce.com");
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
    
    
}
