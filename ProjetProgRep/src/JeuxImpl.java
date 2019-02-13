
// Implémentation de l'interface Hello
import java.rmi.*;
import java.rmi.server.*;

public class JeuxImpl extends UnicastRemoteObject implements JeuxInterface {
	public JeuxImpl() throws RemoteException {
		super();
	}

	public String echo() throws RemoteException {
		return "Hello World ";
	}
}
