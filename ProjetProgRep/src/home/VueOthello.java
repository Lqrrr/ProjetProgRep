package home;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueOthello extends Stage{
		public VueOthello(){
			try {
				final URL fxmlURL=
				getClass().getResource("/home/Othello.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final AnchorPane node = (AnchorPane)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.setScene(scene);
				AllumetteController controleur = fxmlLoader.getController();
				controleur.setVue(this);
				this.initModality(Modality.APPLICATION_MODAL);
				this.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}	
}
