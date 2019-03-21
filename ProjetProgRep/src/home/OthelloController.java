package home;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.fxml.Initializable;


public class OthelloController implements Initializable{
	 private VueOthello vue;



		public OthelloController()
	    {

	    }
	    
	    

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {

	    	
		}

		

		public void setVue(VueOthello vueOthello) {
			this.vue = vueOthello;
		}

}
