package home;

// Interface de Hello
import java.rmi.*;

/* Remote Interface HelloInterface pour l'application Hello */
public interface JeuxInterface extends Remote {
	public String echo() throws RemoteException;
	public int enleveUneAllumette(int allumettes) throws java.rmi.RemoteException;
	public int enleveDeuxAllumettes(int allumettes) throws java.rmi.RemoteException;
	public boolean finPartie(boolean fin,int allumettes) throws java.rmi.RemoteException;
	public int initAllumettes(int allumettes) throws java.rmi.RemoteException;
}