package orglogger.resolver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import orglogger.leapmotion.LeapController;
import orglogger.model.Login;
import orglogger.util.BrowserLauncher;
import orglogger.util.ReadWriteTextFile;
import orglogger.util.SalesforceLoginsInputParser;


import com.leapmotion.leap.Controller;

public class Main {

    public static void main(String[] args){
        
        File testFile = new File("C:\\Temp\\blah.txt");
        // Create a sample listener and controller
        String unparsedLoginsTest = ReadWriteTextFile .getContents(testFile);
        SalesforceLoginsInputParser parser = new SalesforceLoginsInputParser();
        
        parser.parseData(unparsedLoginsTest);
        
//        List<Login> list = parser.getLoginList();
        LeapController leapListener = new LeapController(parser.getLoginList());
        Controller controller = new Controller();
        
        // Have the sample listener receive events from the controller
        controller.addListener(leapListener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(leapListener);
        
    }
    
}
