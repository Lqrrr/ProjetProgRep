
// Interface de Hello
import java.rmi.*;

/* Remote Interface HelloInterface pour l'application Hello */
public interface JeuxInterface extends Remote {
	public String echo() throws RemoteException;
}