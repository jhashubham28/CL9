import java.rmi.*;
import java.rmi.server.*;
public class PowServerImpl extends UnicastRemoteObject
implements PowServerIntf {
public PowServerImpl() throws RemoteException {
}
public double pow(double d1, double d2) throws RemoteException {
double k;
 k= Math.pow(d1,d2);
return k;
}
}
