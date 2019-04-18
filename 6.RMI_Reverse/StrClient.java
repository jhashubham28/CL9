import java.rmi.*;
public class StrClient {
public static void main(String args[]) {
try {
String strServerURL = "rmi://" + args[0] + "/StrServer";
StrServerIntf strServerIntf =
(StrServerIntf)Naming.lookup(strServerURL);
System.out.println("The first string is: " + args[1]);
String d1 = String.valueOf(args[1]);
System.out.println("The second string is: " + args[2]);
String d2 = String.valueOf(args[2]);
System.out.println("The sum is: " + strServerIntf.str_rev(d1, d2));
}
catch(Exception e) {
System.out.println("Exception: " + e);
}
}
}
