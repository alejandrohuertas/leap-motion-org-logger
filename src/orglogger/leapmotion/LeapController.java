package orglogger.leapmotion;

import java.util.List;

import orglogger.model.Login;
import orglogger.util.BrowserLauncher;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.SwipeGesture;

public class LeapController  extends Listener {
    
    public boolean launched = false;
    
    private List<Login> loginList;
    
    public LeapController(List<Login> loginList){
        this.loginList=loginList;
    }
    
    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }
    
    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();
//        System.out.println("Frame id: " + frame.id()
//                         + ", timestamp: " + frame.timestamp()
//                         + ", hands: " + frame.hands().count()
//                         + ", fingers: " + frame.fingers().count()
//                         + ", tools: " + frame.tools().count()
//                         + ", gestures " + frame.gestures().count());

        GestureList gestures = frame.gestures();
        for (int i = 0; i < gestures.count(); i++) {
            Gesture gesture = gestures.get(i);
            if (gesture.duration()>=10000 && gesture.state().toString().equals("STATE_STOP")){
                System.out.println("Gesture type --> "+gesture.type()+ ", Duration -->" +gesture.duration());
               
                switch (gesture.type()) {
                    
                    case TYPE_SWIPE:
                        SwipeGesture swipe = new SwipeGesture(gesture);
                        if(!swipe.frame().fingers().isEmpty()){
                            if(swipe.frame().fingers().count()<=loginList.size()){
                                Integer pos  = swipe.frame().fingers().count();
                                BrowserLauncher.loginIntoSalesforce(loginList.get(pos-1));
                            }
                        }
                        
                        break;

                    default:
                        System.out.println("Unknown gesture type.");
                        break;
                }
            }
        }

        if (!frame.hands().isEmpty() || !gestures.isEmpty()) {
           // System.out.println();
        }
    }
}