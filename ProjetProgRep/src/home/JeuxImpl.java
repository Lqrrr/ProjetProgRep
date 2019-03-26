package home;

// Implémentation de l'interface Hello
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JeuxImpl extends UnicastRemoteObject implements JeuxInterface {
	

	private static final long serialVersionUID = 1L;
	private int allumettes;
	
	public JeuxImpl() throws RemoteException {
		super();
	}

	
	public void initAllumettes(){
		this.allumettes = 13;
	}
	
	public int getAllumettes() {
		return this.allumettes;
	}

	public void printAllumettes() {
		System.out.println("Il reste "+allumettes+" allumettes");
	}


	public void setAllumettes(int allumettes) {
		this.allumettes = allumettes;
	}


	public void enleveUneAllumette(){
		this.allumettes =  allumettes-1;
	}
	
	public void enleveDeuxAllumettes(){
		if(this.allumettes>=2){
			this.allumettes =allumettes-2;
		}
		else{
			this.allumettes = allumettes -1;
		}
	}
	
	public boolean finPartie(){
		if (this.allumettes==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean joueurCommence() {
		Random random = new Random();
	    int r = random.nextInt(2);
	    if (r == 1){
	    	return true;
	    }
	    else 
	    	return false;
	}
	public void enleveAllumettesServeur() {
		Random random = new Random();
	    int r = random.nextInt(2);
	    if (r == 1){
	    	if(this.allumettes>=2){
	    		this.allumettes =allumettes-2;
			}
			else{
				 this.allumettes = allumettes -1;
			}
	    }
	    else
			 this.allumettes = allumettes -1;
	}





	
}
