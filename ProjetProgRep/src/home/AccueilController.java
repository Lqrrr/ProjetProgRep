package home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AccueilController implements Initializable {

    @FXML
    private Button btnAllumette;

    @FXML
    private Button btnOthello;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		
	}


    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == btnAllumette) {
        	System.err.println("BONJOUR");
        	new VueAllumette();
        }
        else if (mouseEvent.getSource() == btnOthello) {
        	new VueOthello();
        }
    }


}
