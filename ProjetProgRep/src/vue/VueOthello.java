package vue;
import java.net.URL;

import controleur.OthelloController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueOthello extends Stage{
		public VueOthello(){
			try {
				final URL fxmlURL=
				getClass().getResource("Othello.fxml");
				final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				final FlowPane node = (FlowPane)fxmlLoader.load();
				Scene scene = new Scene(node);
				this.setScene(scene);
				OthelloController controleur = fxmlLoader.getController();
				controleur.setVue(this);
				this.initModality(Modality.APPLICATION_MODAL);
				this.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}	
}
