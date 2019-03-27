package home;

// Interface de Hello
import java.rmi.*;

/* Remote Interface HelloInterface pour l'application Hello */
public interface JeuxInterface extends Remote {
	// méthode allumettes
	public void enleveUneAllumette() throws RemoteException;
	public void enleveDeuxAllumettes() throws RemoteException;
	public boolean finPartie() throws RemoteException;
	public void initAllumettes() throws RemoteException;
	public void printAllumettes() throws RemoteException;
	public boolean joueurCommence() throws RemoteException;
	public void enleveAllumettesServeur() throws RemoteException;
	public int getAllumettes() throws RemoteException;
	
	//méthode othello
	public String[][] getPlateau() throws RemoteException;
	public boolean finOthello() throws RemoteException;
	public int comptePionNoir() throws RemoteException;
	public int comptePionBlanc() throws RemoteException;
	public void initPlateau() throws RemoteException;
	public void affichePlateau() throws RemoteException;
	public String getPlateauAt(int ligne, int colonne) throws RemoteException;
	public void setPlateauAt(int ligne, int colonne, String pion) throws RemoteException;
}