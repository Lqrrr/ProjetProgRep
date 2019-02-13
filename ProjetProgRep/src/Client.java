import java.rmi.*;
import java.rmi.server.*;

// programme client pour l'exemple "Hello, world!"
public class Client {
	public static void main(String[] argv) {
		try {
			int port = 8000;
			JeuxInterface obj = (JeuxInterface) Naming.lookup("rmi://localhost:" + port + "/jeux");
			System.out.println(obj.echo());
		} catch (Exception e) {
			System.out.println("JeuxClient exception: " + e);
		}
	}
}