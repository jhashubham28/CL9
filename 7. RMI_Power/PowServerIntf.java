import java.rmi.*;
public interface PowServerIntf extends Remote {
double pow(double d1, double d2) throws RemoteException;
}
