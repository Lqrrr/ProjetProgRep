package home;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class OthelloController implements Initializable{
	 private VueOthello vue;
	 private JeuxInterface othelloInterface;

	@FXML
	private GridPane gridpane;
	
	


		public OthelloController()
	    {

	    }
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
			try {
				this.othelloInterface = (JeuxInterface)Naming.lookup("rmi://localhost:8000/jeux");
				this.othelloInterface.initPlateau();
				this.othelloInterface.affichePlateau();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch blocky
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	  
	    
	    @FXML
		public void Placement(MouseEvent mouseEvent) throws RemoteException
		{	
			int ligne,colonne;
			Circle circleClique = (Circle)mouseEvent.getSource();
			if (GridPane.getRowIndex(circleClique)!=null){
				ligne = GridPane.getRowIndex(circleClique);
			}
			else {
				ligne = 0;
			}
				
			if (GridPane.getColumnIndex(circleClique)!=null){
				colonne = GridPane.getColumnIndex(circleClique);
			}
			else {
				colonne = 0;
			}
			int i=2;
			int j=1;
			boolean continu = true;
			boolean place = false;
			
			if (this.othelloInterface.getPlateauAt(ligne,colonne).equals("vide")) {
				if(ligne-1>=0 && colonne-1>=0) {
					if (this.othelloInterface.getPlateauAt(ligne-1,colonne-1).equals("blanc")) {
						while (ligne-i>=0 && colonne-i>=0 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne-j) + (ligne-j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if(ligne-1>=0) {
					if (this.othelloInterface.getPlateauAt(ligne-1,colonne).equals("blanc")) {
						while (ligne-i>=0 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get(colonne + (ligne-j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if(ligne-1>=0 && colonne+1<=7) {
					if (this.othelloInterface.getPlateauAt(ligne-1,colonne+1).equals("blanc")) {
						while (ligne-i>=0 && colonne+i<=7 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne+j) + (ligne-j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if(colonne-1>=0) {
					if (this.othelloInterface.getPlateauAt(ligne,colonne-1).equals("blanc")) {
						while (colonne-i>=0 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne-j) + ligne*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if(colonne+1<=7) {
					if (this.othelloInterface.getPlateauAt(ligne,colonne+1).equals("blanc")) {
						while (colonne+i>=0 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne+j) + ligne*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if(colonne-1>=0 && ligne+1<=7) {
					if (this.othelloInterface.getPlateauAt(ligne+1,colonne-1).equals("blanc")) {
						while (colonne-i>=0 && ligne+i<=7 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne-j) + (ligne+j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if (ligne+1<=7) {
					if (this.othelloInterface.getPlateauAt(ligne+1,colonne).equals("blanc")) {
						while (ligne+i<=7 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get(colonne + (ligne+j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				i=2;
				j=1;
				continu = true;
				if (ligne+1<=7 && colonne+1<=7) {
					if (this.othelloInterface.getPlateauAt(ligne+1,colonne+1).equals("blanc")) {
						while (ligne+i<=7 && colonne+i<=7 && continu) {
							if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("blanc")){
								i++;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("noir")) {
								while (j<i) {
									((Circle)gridpane.getChildren().get((colonne+j) + (ligne+j)*8)).setFill(Color.BLACK);
									j++;
								}	
								continu=false;
								place = true;
							}
							else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("vide")) {
								continu=false;
							}
						}
					}
				}
				
				if (place) {
					((Circle)gridpane.getChildren().get(colonne + ligne*8)).setFill(Color.BLACK);
				}
			}
		}
		

		

		public void setVue(VueOthello vueOthello) {
			this.vue = vueOthello;
		}

}
