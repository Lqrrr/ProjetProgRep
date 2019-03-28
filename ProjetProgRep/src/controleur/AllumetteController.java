package controleur;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import modele.JeuxInterface;
import vue.VueAllumette;
import javafx.scene.control.Label;

public class AllumetteController implements Initializable{
	    
	    private VueAllumette vue;
		private JeuxInterface allumetteInterface;

		@FXML
		private ImageView img_allumette1;
		@FXML
		private ImageView img_allumette2;
		@FXML
		private ImageView img_allumette3;
		@FXML
		private ImageView img_allumette4;
		@FXML
		private ImageView img_allumette5;
		@FXML
		private ImageView img_allumette6;
		@FXML
		private ImageView img_allumette7;
		@FXML
		private ImageView img_allumette8;
		@FXML
		private ImageView img_allumette9;
		@FXML
		private ImageView img_allumette10;
		@FXML
		private ImageView img_allumette11;
		@FXML
		private ImageView img_allumette12;
		@FXML
		private ImageView img_allumette13;
		@FXML
		private Button btn_1allumette;
		@FXML
		private Button btn_2allumettes;
		@FXML
		private Label lbl_comptejoueur;
		@FXML
		private Label lbl_compteia;
		@FXML
		private Label lbl_info;
		
	

		public AllumetteController()
	    {

	    }
	    
	    

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
			try {
				
				
				this.allumetteInterface = (JeuxInterface)Naming.lookup("rmi://localhost:8000/jeux");
				this.allumetteInterface.initAllumettes();
				if (this.allumetteInterface.joueurCommence() == false) {
					btn_1allumette.setDisable(true);
					btn_2allumettes.setDisable(true);

					Random rand= new Random();
					int r= rand.nextInt(2);
					if (r==1) {
						this.allumetteInterface.enleveDeuxAllumettes();
						int temp = Integer.parseInt(lbl_compteia.getText());
						temp= temp+2;
						lbl_compteia.setText(String.valueOf(temp));

					}
					else {
						this.allumetteInterface.enleveUneAllumette();
						int temp = Integer.parseInt(lbl_compteia.getText());
						temp= temp+1;
						lbl_compteia.setText(String.valueOf(temp));

					}
					btn_1allumette.setDisable(false);
					btn_2allumettes.setDisable(false);
					actualiseInterface();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
	

		}

	    @FXML
	    private void clicAllumette(ActionEvent mouseEvent) throws IOException, InterruptedException {
		    	 if (mouseEvent.getSource() == btn_1allumette) {
		    		 	this.allumetteInterface.enleveUneAllumette();
						int temp = Integer.parseInt(lbl_comptejoueur.getText());
						temp= temp+1;
						lbl_comptejoueur.setText(String.valueOf(temp));
				    	 System.out.println("joueur enleve 1");
				    	 btn_1allumette.setDisable(true);
						 btn_2allumettes.setDisable(true);
						 if(this.allumetteInterface.finPartie()==false) {		
							 int comptej=Integer.parseInt(lbl_comptejoueur.getText());
							 int comptei=Integer.parseInt(lbl_compteia.getText());
							 if(comptej+comptei!= 12) {
								Random rand= new Random();
								int r= rand.nextInt(2);
								if (r==1) {
									this.allumetteInterface.enleveDeuxAllumettes();
									int temp4 = Integer.parseInt(lbl_compteia.getText());
									temp4= temp4+2;
									lbl_compteia.setText(String.valueOf(temp4));
								}
								else {
									this.allumetteInterface.enleveUneAllumette();
									int temp5 = Integer.parseInt(lbl_compteia.getText());
									temp5= temp5+1;
									lbl_compteia.setText(String.valueOf(temp5));
								}
							 }
							 else {
								this.allumetteInterface.enleveUneAllumette();
								int temp5 = Integer.parseInt(lbl_compteia.getText());
								temp5= temp5+1;
								lbl_compteia.setText(String.valueOf(temp5));
							 }
						 }
						 if(this.allumetteInterface.finPartie()==false) {		
						 	btn_1allumette.setDisable(false);
							btn_2allumettes.setDisable(false);
		    	 		}
						 else {
							 int res = Integer.parseInt(lbl_comptejoueur.getText());
							 System.out.println("fin de partie");

							 if (res % 2 == 1){
								 lbl_info.setText("T'as gagné t'es le monstre du jeu des allumettes");
							 }
							 else {
								 lbl_info.setText("T'as perdu t'es un débile");
							 }
						 }
						 actualiseInterface();
			        }
			     else if (mouseEvent.getSource() == btn_2allumettes) {
				    	int comptejo=Integer.parseInt(lbl_comptejoueur.getText());
						int comptese=Integer.parseInt(lbl_compteia.getText());
						if(comptejo+comptese != 12) {
							this.allumetteInterface.enleveDeuxAllumettes();
							int temp3 = Integer.parseInt(lbl_comptejoueur.getText());
							temp3= temp3+2;
							lbl_comptejoueur.setText(String.valueOf(temp3));
					    	System.out.println("joueur enleve 2");
						}
						else {
							this.allumetteInterface.enleveUneAllumette();
							int temp = Integer.parseInt(lbl_comptejoueur.getText());
							temp= temp+1;
							lbl_comptejoueur.setText(String.valueOf(temp));
					    	System.out.println("joueur enleve 1");
						}	      
				    	 btn_1allumette.setDisable(true);
						 btn_2allumettes.setDisable(true);
						 if(this.allumetteInterface.finPartie()==false) {
							 int comptej=Integer.parseInt(lbl_comptejoueur.getText());
							 int comptei=Integer.parseInt(lbl_compteia.getText());
							 if(comptej+comptei != 12) {
								Random rand= new Random();
								int r= rand.nextInt(2);
								if (r==1) {
									this.allumetteInterface.enleveDeuxAllumettes();
									int temp4 = Integer.parseInt(lbl_compteia.getText());
									temp4= temp4+2;
									lbl_compteia.setText(String.valueOf(temp4));
								}
								else {
									this.allumetteInterface.enleveUneAllumette();
									int temp5 = Integer.parseInt(lbl_compteia.getText());
									temp5= temp5+1;
									lbl_compteia.setText(String.valueOf(temp5));
								}
							 }
							 else {
								this.allumetteInterface.enleveUneAllumette();
								int temp5 = Integer.parseInt(lbl_compteia.getText());
								temp5= temp5+1;
								lbl_compteia.setText(String.valueOf(temp5));
							 }
						 }
						 if(this.allumetteInterface.finPartie()==false) {		
							 	btn_1allumette.setDisable(false);
								btn_2allumettes.setDisable(false);
			    	 	}
						 else {
							 System.out.println("fin de partie");
							 int res = Integer.parseInt(lbl_comptejoueur.getText());
							 if (res % 2 == 1){
								 lbl_info.setText("T'as gagné t'es le monstre du jeu des allumettes");
							 }
							 else {
								 lbl_info.setText("T'as perdu t'es un débile");
							 }
						 }
						 actualiseInterface();
			     }
	    }
	    
	    
	    public void actualiseInterface() throws RemoteException {
	    	int all = this.allumetteInterface.getAllumettes();
	    	ArrayList<ImageView> tabimages = new ArrayList<ImageView>() {
				private static final long serialVersionUID = 1L;
			{
	    		 add(img_allumette1);
	    		 add(img_allumette2);
	    		 add(img_allumette3);
	    		 add(img_allumette4);
	    		 add(img_allumette5);
	    		 add(img_allumette6);
	    		 add(img_allumette7);
	    		 add(img_allumette8);
	    		 add(img_allumette9);
	    		 add(img_allumette10);
	    		 add(img_allumette11);
	    		 add(img_allumette12);
	    		 add(img_allumette13);
	    		}};
	    	for (int i=all;i<=12;i++) {
	    		tabimages.get(i).setVisible(false);
	    	}
	    }

		

		public void setVue(VueAllumette vueAllumette) {
			this.vue = vueAllumette;
		}

}
