import java.rmi.*;
public interface StrServerIntf extends Remote {
String str_concat(String d1, String d2) throws RemoteException;
}
