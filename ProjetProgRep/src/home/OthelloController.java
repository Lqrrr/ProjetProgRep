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
import javafx.scene.control.Label;

public class OthelloController implements Initializable{
	 private VueOthello vue;
	 private JeuxInterface othelloInterface;
	 private int tour=1;
	@FXML
	private GridPane gridpane;
	@FXML
	private Label lbl_info;
	
	


		public OthelloController()
	    {

	    }
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
			try {
				this.othelloInterface = (JeuxInterface)Naming.lookup("rmi://localhost:8000/jeux");
				this.othelloInterface.initPlateau();
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
			
			if (tour%2 ==1) {
				//----------------------------------------TourNoir--------------------------------------------------------------------

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
											((Circle)gridpane.getChildren().get((colonne-j) + (ligne-j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne-j, colonne-j, "noir");
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
											((Circle)gridpane.getChildren().get(colonne + (ligne-j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne-j, colonne, "noir");
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
											((Circle)gridpane.getChildren().get((colonne+j) + (ligne-j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne-j, colonne+j, "noir");
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
											((Circle)gridpane.getChildren().get((colonne-j) + ligne*8)).setStroke(Color.BLACK);
	
											
											this.othelloInterface.setPlateauAt(ligne, colonne-j, "noir");
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
											((Circle)gridpane.getChildren().get((colonne+j) + ligne*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne, colonne+j, "noir");
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
											((Circle)gridpane.getChildren().get((colonne-j) + (ligne+j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne+j, colonne-j, "noir");
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
											((Circle)gridpane.getChildren().get(colonne + (ligne+j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne+j, colonne, "noir");
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
											((Circle)gridpane.getChildren().get((colonne+j) + (ligne+j)*8)).setStroke(Color.BLACK);
	
											this.othelloInterface.setPlateauAt(ligne+j, colonne+j, "noir");
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
					}
					if (place) {
						((Circle)gridpane.getChildren().get(colonne + ligne*8)).setFill(Color.BLACK);
						((Circle)gridpane.getChildren().get(colonne + ligne*8)).setStroke(Color.BLACK);
						this.othelloInterface.setPlateauAt(ligne, colonne, "noir");
						//if (!passeBlanc()) {
							tour++;
							lbl_info.setText("Tour Blanc");
						//}
						
					}
				
			}
				else {
					//----------------------------------------TourBlanc--------------------------------------------------------------------
					
						if (this.othelloInterface.getPlateauAt(ligne,colonne).equals("vide")) {
							if(ligne-1>=0 && colonne-1>=0) {
								if (this.othelloInterface.getPlateauAt(ligne-1,colonne-1).equals("noir")) {
									while (ligne-i>=0 && colonne-i>=0 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne-j) + (ligne-j)*8)).setFill(Color.WHITE);
												((Circle)gridpane.getChildren().get((colonne-j) + (ligne-j)*8)).setStroke(Color.BLACK);
	
												this.othelloInterface.setPlateauAt(ligne-j, colonne-j, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne-1,colonne).equals("noir")) {
									while (ligne-i>=0 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get(colonne + (ligne-j)*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get(colonne + (ligne-j)*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne-j, colonne, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne-1,colonne+1).equals("noir")) {
									while (ligne-i>=0 && colonne+i<=7 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne+j) + (ligne-j)*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get((colonne+j) + (ligne-j)*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne-j, colonne+j, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne,colonne-1).equals("noir")) {
									while (colonne-i>=0 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne-j) + ligne*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get((colonne-j) + ligne*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne, colonne-j, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne,colonne+1).equals("noir")) {
									while (colonne+i>=0 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne+j) + ligne*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get((colonne+j) + ligne*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne, colonne+j, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne+1,colonne-1).equals("noir")) {
									while (colonne-i>=0 && ligne+i<=7 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne-j) + (ligne+j)*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get((colonne-j) + (ligne+j)*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne+j, colonne-j, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne+1,colonne).equals("noir")) {
									while (ligne+i<=7 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get(colonne + (ligne+j)*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get(colonne + (ligne+j)*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne+j, colonne, "blanc");
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
								if (this.othelloInterface.getPlateauAt(ligne+1,colonne+1).equals("noir")) {
									while (ligne+i<=7 && colonne+i<=7 && continu) {
										if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("noir")){
											i++;
										}
										else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("blanc")) {
											while (j<i) {
												((Circle)gridpane.getChildren().get((colonne+j) + (ligne+j)*8)).setFill(Color.WHITE);
	
												((Circle)gridpane.getChildren().get((colonne+j) + (ligne+j)*8)).setStroke(Color.BLACK);
												this.othelloInterface.setPlateauAt(ligne+j, colonne+j, "blanc");
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
						}
						if (place) {
							((Circle)gridpane.getChildren().get(colonne + ligne*8)).setFill(Color.WHITE);
	
							((Circle)gridpane.getChildren().get(colonne + ligne*8)).setStroke(Color.BLACK);
							this.othelloInterface.setPlateauAt(ligne, colonne, "blanc");
							//if (!passeNoir()) {
								tour++;
								lbl_info.setText("Tour noir");
							//}
							
	
						}
					
				}
				if (this.othelloInterface.finOthello()==true) {
					int blanc = this.othelloInterface.comptePionBlanc();
					int noir = this.othelloInterface.comptePionNoir();
					if (blanc>noir) {
						lbl_info.setText("Le blanc t'es le monstre de l'othello, le noir t'es un débile");
					}
					else if (blanc<noir) {
						lbl_info.setText("Le noir t'es le monstre de l'othello, le blanc t'es un débile");
					}
					else {
						lbl_info.setText("Égalité, vous êtes des débiles");
					}
				}
				this.othelloInterface.affichePlateau();
			}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public boolean passeBlanc() throws RemoteException{
	    	int i=2;int j=1; boolean continu=true;
	    	for(int ligne = 0;ligne<8;ligne++){
				for(int colonne =0;colonne<8;colonne++)
				{
					if (this.othelloInterface.getPlateauAt(ligne,colonne).equals("vide")) {
						if(ligne-1>=0 && colonne-1>=0) {
							if (this.othelloInterface.getPlateauAt(ligne-1,colonne-1).equals("noir")) {
								while (ligne-i>=0 && colonne-i>=0 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("blanc")) {
										System.out.println("Blanc Passe");
										continu=false;
										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne-1,colonne).equals("noir")) {
								while (ligne-i>=0 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne-i,colonne).equals("blanc")) {
										System.out.println("Blanc Passe"); 
										continu=false;

										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne-1,colonne+1).equals("noir")) {
								while (ligne-i>=0 && colonne+i<=7 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne-i,colonne+i).equals("blanc")) {
										System.out.println("Blanc Passe"); 
										continu=false;

										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne,colonne-1).equals("noir")) {
								while (colonne-i>=0 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne,colonne-i).equals("blanc")) {
										System.out.println("Blanc Passe"); 
										continu=false;
										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne,colonne+1).equals("noir")) {
								while (colonne+i>=0 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne,colonne+i).equals("blanc")) {
										System.out.println("Blanc Passe");
										continu=false;
										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne+1,colonne-1).equals("noir")) {
								while (colonne-i>=0 && ligne+i<=7 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne+i,colonne-i).equals("blanc")) {
										System.out.println("Blanc Passe");
										continu=false;
										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne+1,colonne).equals("noir")) {
								while (ligne+i<=7 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne+i,colonne).equals("blanc")) {
										System.out.println("Blanc Passe");
										continu=false;

										return true;
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
							if (this.othelloInterface.getPlateauAt(ligne+1,colonne+1).equals("noir")) {
								while (ligne+i<=7 && colonne+i<=7 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("noir")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("blanc")) {
										System.out.println("Blanc Passe"); 
										continu=false;
										return true;
									}
									else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("vide")) {
										continu=false;
									}
								}
							}
						}
					}
				}
			}
	    	return false;
	    }
	    
	    
	    public boolean passeNoir() throws RemoteException{
	    	int i=2;int j=1; boolean continu=true;
	    	for(int ligne = 0;ligne<8;ligne++){
				for(int colonne =0;colonne<8;colonne++)
				{
					if (this.othelloInterface.getPlateauAt(ligne,colonne).equals("vide")) {
						if(ligne-1>=0 && colonne-1>=0) {
							if (this.othelloInterface.getPlateauAt(ligne-1,colonne-1).equals("blanc")) {
								while (ligne-i>=0 && colonne-i>=0 && continu) {
									if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("blanc")){
										i++;
									}
									else if (this.othelloInterface.getPlateauAt(ligne-i,colonne-i).equals("noir")) {
										System.out.println("Noir Passe");
										continu=false;
										return true;
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
										System.out.println("Noir Passe"); 
										continu=false;

										return true;
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
										System.out.println("Noir Passe"); 
										continu=false;

										return true;
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
										System.out.println("Noir Passe"); 
										continu=false;
										return true;
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
										System.out.println("Noir Passe");
										continu=false;
										return true;
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
										System.out.println("Noir Passe");
										continu=false;
										return true;
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
										System.out.println("Noir Passe");
										continu=false;

										return true;
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
										System.out.println("Noir Passe"); 
										continu=false;
										return true;
									}
									else if (this.othelloInterface.getPlateauAt(ligne+i,colonne+i).equals("vide")) {
										continu=false;
									}
								}
							}
						}
					}
				}
			}
	    	return false;
	    }
		
		public void setVue(VueOthello vueOthello) {
			this.vue = vueOthello;
		}

}
