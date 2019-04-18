import java.rmi.*;
public interface StrServerIntf extends Remote {
String str_rev(String d1, String d2) throws RemoteException;
}
