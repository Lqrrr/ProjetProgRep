
// Interface de Hello
import java.rmi.*;

/* Remote Interface HelloInterface pour l'application Hello */
public interface JeuxInterface extends Remote {
	public String echo() throws RemoteException;
	public int enleveUneAllumette(int allumettes);
	public int enleveDeuxAllumettes(int allumettes);
	public boolean finPartie(boolean fin,int allumettes);
	public int initAllumettes(int allumettes);
}