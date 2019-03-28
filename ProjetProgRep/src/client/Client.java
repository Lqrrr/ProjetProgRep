package client;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.JeuxInterface;
import vue.VueAllumette;
import vue.VueOthello;
import javafx.application.*;
import javafx.event.ActionEvent;

public class Client extends Application{
	
	    @Override
	    public void start(Stage primaryStage){
		    try{
		        Parent root = FXMLLoader.load(getClass().getResource("../vue/Accueil.fxml"));
		        primaryStage.setTitle("Logiciel de jeux en réseau");
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		    } catch (Exception e) {
				e.printStackTrace();
			}
	    }

	
		private static final int port = 8000; 
		
			@FXML 
		    private Button btnAllumette;

		    @FXML
		    private Button btnOthello;

		public static void main(String[] args) throws RemoteException{
			try {
				setServJeuxInterface(service, port);			
				launch(args);	
			} catch (Exception e) {
				System.out.println("JeuxClient exception: " + e);
			}
		}
		
		public static JeuxInterface service;

		public static JeuxInterface getServJeuxInterface() {
			return service;
		}

		public static void setServJeuxInterface(JeuxInterface service, int port) {
			try {
				Client.service = (JeuxInterface) Naming.lookup("rmi://localhost:"+port+"/jeux");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("Client erreur : " + e);
			}
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
