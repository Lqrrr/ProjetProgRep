package home;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
