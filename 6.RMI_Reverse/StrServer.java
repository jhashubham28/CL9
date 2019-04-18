import java.net.*;
import java.rmi.*;
public class StrServer {
public static void main(String args[]) {
try {
StrServerImpl strServerImpl = new StrServerImpl();
Naming.rebind("StrServer", strServerImpl);
}
catch(Exception e) {
System.out.println("Exception: " + e);
}
}
}
