import java.net.Socket;
import java.io.PrintStream;
import java.io.IOException;

public class RModel
{

	// Defaults
    private static String URL = "139.78.141.250";
    private static int PORT = 9090;
    private static boolean DEBUG_IS_ON = false;

	// Action Codes
    public static final int LAUNCH = 0;
    public static final int LAND = 1;
    public static final int MOVE_UP = 2;
    public static final int MOVE_DOWN = 3;
    public static final int MOVE_LEFT = 4;
    public static final int MOVE_RIGHT = 5;
    public static final int TURN_RIGHT = 6;
    public static final int TURN_LEFT = 7;
    public static final int MOVE_FORWARD = 8;
    public static final int MOVE_BACKWARD = 9;
    public static final int STOP = 10;

	// Messages
	private static final String HANDSHAKE = "raw\r\n\r\n";
	private static final String LAUNCH_JSON = "{\"receiver\":\"/ardrone/takeoff\",\"msg\":{},\"type\":\"std_msgs/Empty\"}";
	private static final String LAND_JSON = "{\"receiver\":\"/ardrone/land\",\"msg\":{},\"type\":\"std_msgs/Empty\"}";
	private static final String STOP_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String UP_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String DOWN_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":-0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String LEFT_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":-0.25,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String RIGHT_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0.25,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String TURN_L_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0.25}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String TURN_R_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":-0.25}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String FORWARD_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0.25,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";
	private static final String BACKWARD_JSON = "{\"receiver\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":-0.25,\"y\":0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}},\"type\":\"geometry_msgs/Twist\"}";

	// Instance variables
    private PrintStream out;
    private Socket socket;

    public RModel()
    {
    
    	// Tries to connect to defaulted url, port
        try
        {
            this.socket = new Socket(URL, PORT);
        }
        catch(IOException e)
        {
            if(DEBUG_IS_ON)
            {
                e.printStackTrace();
            }
            return;
        }
        
        // Tries to create stream to talk
        try
        {
            this.out = new PrintStream(socket.getOutputStream());
            this.out.print(HANDSHAKE);
            this.out.flush();
        }
        catch(IOException e)
        {
            if(DEBUG_IS_ON)
            {
                e.printStackTrace();
            }
            return;
        }
        
        // Debug info
        if(this.socket.isConnected())
        {
        	if(DEBUG_IS_ON){ System.out.println("Yay it's connected"); }
        }
        else
        {
        	if(DEBUG_IS_ON){ System.out.println("It's not connected."); }
        }
    }

    public void doAction(int action)
    {
    
    	String message = null;
    
    	// Action decider
    	switch(action)
    	{
    		case LAUNCH:
    			message = LAUNCH_JSON;
    			break;
    		case LAND:
    			message = LAND_JSON;
    			break;
    		case STOP:
    			message = STOP_JSON;
    			break;
    		case MOVE_UP:
    			message = UP_JSON;
    			break;
    		case MOVE_DOWN:
    			message = DOWN_JSON;
    			break;
    		case MOVE_LEFT:
    			message = LEFT_JSON;
    			break;
    		case MOVE_RIGHT:
    			message = RIGHT_JSON;
    			break;
    		case TURN_LEFT:
    			message = TURN_L_JSON;
    			break;
    		case TURN_RIGHT:
    			message = TURN_R_JSON;
    			break;
    		case MOVE_FORWARD:
    			message = FORWARD_JSON;
    			break;
    		case MOVE_BACKWARD:
    			message = BACKWARD_JSON;
    			break;
    		default:
    			System.out.println("Nothing happened.");
    		break;
    	}
    	
    	if(DEBUG_IS_ON){ System.out.println("Preforming action: "+action); }
    	
    	// Sends message
    	if(message != null)
    	{
    		if(DEBUG_IS_ON){ System.out.println("Sending message.."); }
    		this.sendMessage(message);
    	}
    	else
    	{
    		if(DEBUG_IS_ON){ System.out.println("ERROR: bad message"); }
    	}
    
    }
    
    private void sendMessage(String message)
    {
    	// Dr. Cricks method of talking to the server
    	this.out.write(0);
    	this.out.print(message);
    	this.out.write(-1);
    	this.out.flush();
    	
    	if(DEBUG_IS_ON){ System.out.println("Message sent."); }
    }
    
}
