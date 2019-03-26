package home;

// Interface de Hello
import java.rmi.*;

/* Remote Interface HelloInterface pour l'application Hello */
public interface JeuxInterface extends Remote {
	public void enleveUneAllumette() throws RemoteException;
	public void enleveDeuxAllumettes() throws RemoteException;
	public boolean finPartie() throws RemoteException;
	public void initAllumettes() throws RemoteException;
	public void printAllumettes() throws RemoteException;
	public boolean joueurCommence() throws RemoteException;
	public void enleveAllumettesServeur() throws RemoteException;
	public int getAllumettes() throws RemoteException;
}