import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SFrame extends JFrame
{
    
    private static String TITLE = "Sierpinski's Triangle";
    private static int INITIAL_WIDTH = 500;
    private static int INITIAL_HEIGHT = 500;

    public SFrame()
    {
        setTitle(TITLE);
        setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        TriPanel tp = new TriPanel();
        contentPane.add(tp);
        addComponentListener(new ScreenResizer(tp));
		setVisible(true);
    }
    
    private class ScreenResizer implements ComponentListener
    {
    
    	private TriPanel tp;
    
    	public ScreenResizer(TriPanel tp)
    	{
    		super();
    		this.tp = tp;
    	}
    
    	public void componentHidden(ComponentEvent e){}
    	public void componentMoved(ComponentEvent e){}
    	public void componentShown(ComponentEvent e){}
    	public void componentResized(ComponentEvent e)
    	{
    		tp.screenResize();
    	}
    }
}
