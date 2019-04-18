import java.rmi.*;
import java.rmi.server.*;
public class StrServerImpl extends UnicastRemoteObject
implements StrServerIntf {
public StrServerImpl() throws RemoteException {
}
public String str_concat(String d1, String d2) throws RemoteException {
 String s1 ;
 //String s2 ;
 s1=d1.concat(d2);
 System.out.println(s1);
return s1;
}
}
