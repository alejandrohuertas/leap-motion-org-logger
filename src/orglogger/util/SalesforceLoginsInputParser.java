package orglogger.util;
import java.util.ArrayList;
import java.util.List;

import orglogger.model.Login;




public class SalesforceLoginsInputParser {

    private List<Login> loginList;

    public void parseData (String unparsedText){
        loginList= new ArrayList<Login>();
        String[] lines = unparsedText.split(System.getProperty("line.separator"));
        
        for (int i=1; i<lines.length;i++){
            String loginArray[]=lines[i].split(","); 
            Login login = new Login(loginArray[1].trim(), loginArray[2].trim(), loginArray[0].trim());
            loginList.add(login);
            
        }
    }

    public List<Login> getLoginList() {
        return loginList;
    }

}
