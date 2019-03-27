package home;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;



import javafx.fxml.Initializable;


public class OthelloController implements Initializable{
	 private VueOthello vue;
	 private JeuxInterface othelloInterface;



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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	    public void findCandidates(){
	    	
	    }

		

		public void setVue(VueOthello vueOthello) {
			this.vue = vueOthello;
		}

}
