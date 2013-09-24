package java.util;
import java.io.File;
import java.io.IOException;
import java.model.Login;
import java.util.ArrayList;
import java.util.List;




public class SalesforceLoginsInputParser {

    private List<Login> loginList;
    
    
    public void parseData (String unparsedText){
        loginList= new ArrayList<Login>();
        
        
        String[] lines = unparsedText.split(System.getProperty("line.separator"));
        
        for (int i=1; i<lines.length;i++){
            String loginArray[]=lines[i].split(","); 
            
            Login login = new Login(loginArray[0], loginArray[1]);
            loginList.add(login);
            
        }
    }


    public List<Login> getLoginList() {
        return loginList;
    }


    
    public static void main (String... aArguments) throws IOException {
        File testFile = new File("C:\\Temp\\blah.txt");
//        ReadWriteTextFile reader = new ReadWriteTextFile();
        SalesforceLoginsInputParser parser = new SalesforceLoginsInputParser();
        String unparsedText= ReadWriteTextFile .getContents(testFile);
        System.out.println("Original file contents: " + unparsedText);
        parser.parseData(unparsedText);
        System.out.println("Number of login accesses: " + parser.getLoginList().size());
        
        //setContents(testFile, "The content of this file has been overwritten...");
        
      }
}
