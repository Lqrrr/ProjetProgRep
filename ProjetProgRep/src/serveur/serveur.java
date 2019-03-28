package serveur;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Random;

import modele.JeuxImpl;

public class serveur {

	public static void main(String[] argv) {
		try {
			int port = 8000;
	        LocateRegistry.createRegistry(port); 
			Naming.bind("rmi://localhost:" + port + "/jeux", new JeuxImpl());
			System.out.println("Jeux Server prêt ! .");
		} catch (Exception e) {
			System.out.println("Jeux Server échec " + e);
		}
	}
}