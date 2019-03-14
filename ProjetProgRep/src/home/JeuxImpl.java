package home;

// Implémentation de l'interface Hello
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

public class JeuxImpl extends UnicastRemoteObject implements JeuxInterface {
	
	
	private static final long serialVersionUID = 1L;
	int allumettes;
	boolean fin;
	
	public JeuxImpl() throws RemoteException {
		super();
	}

	public String echo() throws RemoteException {
		return "Hello World ";
	}
	
	public int initAllumettes(int allumettes){
		Random r = new Random();
        int n = r.nextInt(20)+10;
        if (n % 2 == 1){
        	n=n-1;
        }
        return n;
	}
	
	public int enleveUneAllumette(int allumettes){
		return allumettes-1;
	}
	
	public int enleveDeuxAllumettes(int allumettes){
		if(allumettes>=2){
			return allumettes-2;
		}
		else{
			return 0;
		}
	}
	
	public boolean finPartie(boolean fin,int allumettes){
		if (allumettes==0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
