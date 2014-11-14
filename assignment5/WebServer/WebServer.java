import java.net.ServerSocket;
import java.io.IOException;

public class WebServer
{

	private static final int DEFAULT_PORT = 8080;

	public static void main(String[] args)
	{
		ServerSocket socket = null;
		
		int port = DEFAULT_PORT;
		
		if(args.length == 1)
		{
			try
			{
				port = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Error you didn't give a integer.");
				System.out.println("Try: java WebServer <port>");
			}
		}
		
		try
		{
			socket = new ServerSocket(port);
		}
		catch(SecurityException e)
		{
			System.out.println("Not aloud to use the designated port.");
			if(port != DEFAULT_PORT)
			{
				System.out.println("Not aloud to use the designated port.");
				System.out.println("Trying 8080...");
				try
				{
					socket = new ServerSocket();
				}
				catch(IOException ex)
				{
					System.out.println("Didn't allow port 8080.");
				}
			}
			else{}
		}
		catch(IOException e)
		{
			System.out.println("Error connecting to port.");
		}
		
		while(true)
		{
			try
			{
				Thread connection = new Thread(new ClientConnection(socket.accept()));
				connection.start();
			}
			catch(IOException e)
			{
				System.out.println("Error in webserver");
			}
		}
		
	}

}
