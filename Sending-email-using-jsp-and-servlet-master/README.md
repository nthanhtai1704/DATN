# Sending-email-using-jsp-and-servlet

Sending Email in Java through Gmail Server
-> For sending the email using JavaMail API, you need to load the two jar files in your WEB-INF/lib and to your java build path external jar folder:
->mail.jar
->activation.jar 

The project uses java api to create a forgot password mail where the user is sent the details of its password and redirected to enter the
new password page.(the project is still not complete)

Technologies used:
1. Eclipse Photon
2. Tomcat Server v8.5

P.S - The ports used here is for gmail server. Remember to go to web.xml file and rewrite your email id and password of the gmail account to 
send the email to the recipient

//Emailform.jsp is not usable in this case rightnow but you can change accordingly
