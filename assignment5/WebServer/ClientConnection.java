import java.net.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientConnection implements Runnable
{

	private static final String ERROR_HEADER = "HTTP/1.1 404 Not Found\r\n\r\n";
	private static final String SUCCESS_HEADER = "HTTP/1.1 200 OK\r\n";
	private static final String CONTENT_HTML = "Content-type: text/html\r\n\r\n";
	private static final String CONTENT_JPG = "Content-type: image/jpg\r\n\r\n";

	private Socket socket;

	public ClientConnection(Socket socket)
	{
		this.socket = socket;
	}

	public void run()
	{
	
		String input = "";
	
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((input = reader.readLine()) != null)
			{
				if(input.substring(0, 3).equals("GET"))
				{
					break;
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		String fileName = getFileName(input);
		
		String header = "";
		
		header = (fileName != null) ? SUCCESS_HEADER : ERROR_HEADER;
		
		BufferedWriter bf = null;
		File inputFile = null;
		
		try
		{
			inputFile = new File(fileName);
			if(!inputFile.exists()) 
			{
				header = ERROR_HEADER;
				bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				if(new File("404.html").exists())
				{
					page404(bf);
				}
				else
				{
					bf.write(header);
					bf.flush();
					bf.close();
				}
				return;
			}
			else
			{
				bf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bf.write(header);
			}
		}
		catch(FileNotFoundException e){ System.out.println("File not found."); }
		catch(IOException e){ System.out.println("No output stream");}
		catch(Exception e){System.out.println("Other");}
		
		try
		{
			if(header.equals(SUCCESS_HEADER))
			{
			
				if(fileName.substring(fileName.length() - 4).equals(".jpg"))
				{
				
					bf.write(CONTENT_JPG);
					inputFile = new File(fileName);
					FileInputStream imageReader = new FileInputStream(inputFile);
					byte[] arr = new byte[(int)inputFile.length()];
					imageReader.read(arr);
					String output = new String(arr, "UTF-8");
					bf.write(output);
					bf.flush();
					bf.close();
				}
				else
				{
					BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
					String output = "";
					String x = "";
					while((x = fileReader.readLine()) != null)
					{
						output = output+x;
					}
					if(bf != null)
					{
						bf.write(CONTENT_HTML);
						bf.write(output);
						bf.flush();
						bf.close();
					}
				}
			}
		}
		catch(IllegalStateException e)
		{
			System.out.println("Illegal state excetpion");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void page404(BufferedWriter bf)
	{
		try
		{
			BufferedReader fileReader = new BufferedReader(new FileReader(new File("404.html")));
			String output = "";
			String x = "";
			while((x = fileReader.readLine()) != null)
			{
				output = output+x;
			}
			if(bf != null)
			{
				bf.write(SUCCESS_HEADER);
				bf.write(CONTENT_HTML);
				bf.write(output);
				bf.flush();
				bf.close();
			}
		}
		catch(Exception e)
		{
		}
		
	}
	
	private String getFileName(String input)
	{
	
		String file = "";
		if(input == null) return "index.html";	
		Matcher match = Pattern.compile("GET\\s\\/(.*?)\\sHTTP\\/1\\.1", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(input);
		try{ while(match.find()){ file = match.group(1); } }
		catch(Exception e)
		{
			System.out.println("File not found!");
			return null;
		}
		
		if(file.equals("/") || file.equals("") || file == null) return "index.html";
		
		return file;
	}

}