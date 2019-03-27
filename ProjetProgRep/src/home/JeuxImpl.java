package home;

// Implémentation de l'interface Hello
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;



public class JeuxImpl extends UnicastRemoteObject implements JeuxInterface {
	

	private static final long serialVersionUID = 1L;
	private int allumettes;
	
	private String plateau[][] = new String[8][8];
	
	
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


	public String[][] getPlateau() {
		return plateau;
	}


	public void setPlateau(String[][] plateau) {
		this.plateau = plateau;
	}

	
	public void initPlateau(){
		this.plateau[3][3] = "blanc";
		this.plateau[4][4] = "blanc";
		this.plateau[3][4] = "noir";
		this.plateau[4][3] = "noir";
	}
	
	public boolean finOthello(){
		for(int i = 0;i<8;i++){
			for(int j =0;j<8;j++)
			{
				if ((plateau[i][j] != "noir") && (plateau[i][j] != "blanc")){
					return false;
				}
			}
		}
		return true;
	}
	
	public void affichePlateau(){
		for(int i = 0;i<8;i++){
			for(int j =0;j<8;j++)
			{
				System.out.println("("+i+","+j+") : "+plateau[i][j]);
			}
		}
	}
	
	public int comptePionNoir(){
		int compteur = 0;
		for(int i = 0;i<8;i++){
			for(int j =0;j<8;j++)
			{
				if (plateau[i][j] == "noir"){
					compteur=compteur+1;
				}	
			}
		}
		return compteur;
	}

	public int comptePionBlanc(){
		int compteur = 0;
		for(int i = 0;i<8;i++){
			for(int j =0;j<8;j++)
			{
				if (plateau[i][j] == "blanc"){
					compteur=compteur+1;
				}
			}
		}
		return compteur;
	}



	

	



	
}
