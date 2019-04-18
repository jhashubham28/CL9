import java.rmi.*;
public class PowClient {
public static void main(String args[]) {
try {
String powServerURL = "rmi://" + args[0] + "/PowServer";
PowServerIntf powServerIntf =
(PowServerIntf)Naming.lookup(powServerURL);
System.out.println("The first number is: " + args[1]);
double d1 = Double.valueOf(args[1]).doubleValue();
System.out.println("The second number is: " + args[2]);
double d2 = Double.valueOf(args[2]).doubleValue();
System.out.println("The sum is: " + powServerIntf.pow(d1, d2));
}
catch(Exception e) {
System.out.println("Exception: " + e);
}
}
}
