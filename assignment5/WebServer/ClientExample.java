import java.io.*;
import java.net.*;
public class ClientExample {
	public static void main(String[] args) {
		String message = "GET Test.java HTTP/1.1";
		try {
			InetAddress local = InetAddress.getLocalHost();
			Socket socket = new Socket(local, 8080);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				out.println(message);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}