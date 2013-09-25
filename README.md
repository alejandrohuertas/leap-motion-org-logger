leap-motion-org-logger
======================

Leap Motion integration with java in order to log into an org using gestures

Instructions to run jar file
----------------------------
/project_root>java -Djava.library.path="lib/x86" -jar orgLoggerRunnable.jar


make sure that in the lib folder the x86 exists. In order to run it for 64 bit windows architecture, please copy the x64 folder from the LeapMotion SDK to the lib folder 


how it work
-----------

1. Set up a maximun of 5 logins for salesforce in the file loginInfo.txt

2. Run the application

3. According to the order of the login list, if you do a swipe with one finger, the number one on the list will be logged, in this order, if you use the 5 fingers swipe, the 5th login will be processed
