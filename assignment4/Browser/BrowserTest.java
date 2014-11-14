import java.net.URL;

public class BrowserTest
{
    public static void main(String[] args)
    {
    
    	String link = "http://cs.okstate.edu/index.php";
    	URL urlObj = null;
    	
    	
    	try
    	{
    		urlObj = new URL(link);
    	}
    	catch(Exception e)
    	{
    	}
    	
    	System.out.println(urlObj.getFile());
    	System.out.println(urlObj.getPath());
    
    }
}
