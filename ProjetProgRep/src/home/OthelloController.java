package home;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
	    
	    public boolean est_jouable(int ligne, int colonne){
	    	return false;
	    }
	    
		public void Placement(ActionEvent mouseEvent)
		{
			Circle circleClique = (Circle)mouseEvent.getSource();
			int ligne = GridPane.getRowIndex(circleClique);
			int colonne = GridPane.getColumnIndex(circleClique);
			
			((Circle)gridpane.getChildren().get(colonne + ligne*8)).setFill(Color.RED);
		}

		

		public void setVue(VueOthello vueOthello) {
			this.vue = vueOthello;
		}

}
