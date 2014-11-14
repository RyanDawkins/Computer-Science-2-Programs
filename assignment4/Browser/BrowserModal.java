import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.IllegalStateException;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;

public class BrowserModal
{
	private String webPage;
	private static boolean DEBUG_IS_ON = false;
	private static int DEFAULT_PORT = 80;

	public void getWebPageTitle(String webPage)
	{
		this.webPage = webPage;
		getWebPageTitle();
	}
	
	// This function assumes you stored the webpage originally.
	public String getWebPageTitle()
	{
		String title = null;
		Matcher match = null;
		
		if(this.webPage != null)
		{
			match = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(this.webPage);
		}
		else
		{
			return null;
		}
		try
		{
			while(match.find()){title = match.group(1);}
		}
		catch(IllegalStateException e)
		{
			if(DEBUG_IS_ON)
			{
				System.out.print("Stack trace: ");
				e.printStackTrace();
				System.out.println("Message: "+e.getMessage());
			}
			return null;
		}
		return title;
	}
	
	
	public String getPage(String url, int port)
	{
		String rawPage = getSource(url, port);
		
		String page = "";
		
		if(rawPage != null)
		{
	    
	    	String body = removeBody(rawPage);
	    
	    	page = body.replaceAll(
	    
	    		// Replaces all javascript
	    		"<script[^>]*>(.*?)</script>", "").replaceAll(
	
				// Replaces all input tags
		    	"<select[^>]*>(.*?)</select>", "").replaceAll(
		    	"<input[^>]*>(.*?)</input>", "").replaceAll(
	    	
		    	// Replaces all extra html tags
		    	"<[^>]*>", "").replaceAll(
	    	
	    		// Fixes spaces and converts html spaces to real spaces
	    		"&nbsp;", " ").replaceAll(
	    		
	    		// Removes the ending comment tag from html
	    		"-[^>]*>", "").replaceAll(
	    	
	   		 	// forces all double spaces to be new lines, this stops the application from being
	    		// one big blob of text when using the regex " +" replacing with " "
	    		"  +", "\n").trim();
	    }
	    return page;

	}
	
	private String removeBody(String rawPage)
	{
	
		String body = null;
	
		// This regex extracts the body tag.
		// <body[^>]*> - allows all patterns of body to be extracted, such as <body class="body">
		Matcher match = Pattern.compile("<body[^>]*>(.*?)</body>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawPage);
	    
	    try
	    {
	    	while(match.find()){ body = match.group(1); }
	    }
	    catch(IllegalStateException e)
	    {
	    	if(DEBUG_IS_ON)
	    	{
	    		System.out.print("Stack trace: ");
				e.printStackTrace();
				System.out.println("Message: "+e.getMessage());
			}
			return null;
	    }
	    return body;
	}
	
	
	public String getPage(String url)
	{
		return this.getPage(url, DEFAULT_PORT);
	}
	
	private String getSource(String url, int port)
	{

        Socket socket = null;
        PrintWriter out;
        BufferedReader in;
        String protocol = "";
        String pagefile;
        
        URL urlObj = null;
        
        if(!(url.substring(0, 7).equalsIgnoreCase("http://")))
        {
        	url = "http://"+url;
        }
        
        try
        {
        	urlObj = new URL(url);
            pagefile = urlObj.getFile() == null ? urlObj.getFile() : "/";
            url = urlObj.getHost();
            
            if(!(urlObj.getProtocol().equals("http")) && !(urlObj.getProtocol().equals("")))
            {
            	return null;
            }
            
        }
        catch(MalformedURLException e)
        {
            if(DEBUG_IS_ON)
            {
                e.printStackTrace();
            }
            
            return null;
        }

        String rawPage = null;


		// Tries connecting to the url
		try
		{
			socket = new Socket(url, 80);
		}
		catch(IOException e)
		{
			if(DEBUG_IS_ON)
			{
				System.out.println("ERROR: Check your internet connection, and your URL.");
			}
            return null;
		}
		
		// if is connecting will begin get a input/output stream
		if(socket != null && socket.isConnected())
		{
			
			// Output stream
            try
            {
                out = new PrintWriter(socket.getOutputStream());
            }
            catch(IOException e)
            {
                if(DEBUG_IS_ON)
                {
                    System.out.println("ERROR: Cannot get output stream");
                }
                return null;
            }
            
            // Input Stream
            try
            {
                in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            }
            catch(IOException e)
            {
                if(DEBUG_IS_ON)
                {
                    System.out.println("ERROR: Cannot get input stream");
                }
                return null;
            }

            // HTTP Request
            out.print("GET "+ pagefile +" HTTP/1.1\n");
            out.print("host: "+url+" \n\n");
            out.flush();


			// Building the page as a String
            String line;
            boolean check = true;
            try
            {
                while((line = in.readLine()) != null && check)
                {
                    rawPage += line;
                    //if(DEBUG_IS_ON) System.out.println(line);
                }
            }
            catch(IOException e)
            {
                if(DEBUG_IS_ON)
                {
                    System.out.println("ERROR: No response from server.");
                }
            }
		}
		
		// Stores the page in the object for further parsing
		this.webPage = rawPage;
		
        return rawPage;
	
	}
	
	public String decodeUrl(String url)
	{
	
		// Removes protocol
		String newUrl = url.replaceAll("(?i)http://", "").replaceAll("(?i)https://", "");
		return newUrl;
	}
	
}
