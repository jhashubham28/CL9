import java.rmi.*;
import java.rmi.server.*;
public class StrServerImpl extends UnicastRemoteObject
implements StrServerIntf {
public StrServerImpl() throws RemoteException {
}
public String str_rev(String d1,String d2) throws RemoteException {
  String str, rev = "";
  String flag="";
      
     
      str = d1;
 
      int length = str.length();
 
      for ( int i = length - 1; i >= 0; i-- )
         rev = rev + str.charAt(i);
 
      if (rev.equals(d2))
         flag="matched";
      else
         flag="unmatched";
 
return flag;
}
}
