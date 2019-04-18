import java.net.*;
import java.rmi.*;
public class PowServer {
public static void main(String args[]) {
try {
PowServerImpl powServerImpl = new PowServerImpl();
Naming.rebind("PowServer", powServerImpl);
}
catch(Exception e) {
System.out.println("Exception: " + e);
}
}
}
