package home;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

public class serveur {
	public static void main(String[] argv) {
		try {
			int port = 8000;
			// Naming.rebind ("hello", new HelloImpl());
			LocateRegistry.createRegistry(port);
			Naming.rebind("rmi://localhost:" + port + "/jeux", new JeuxImpl());
			System.out.println("Jeux Server prêt ! .");
		} catch (Exception e) {
			System.out.println("Jeux Server échec " + e);
		}
	}
}