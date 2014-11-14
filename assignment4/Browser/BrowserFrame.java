import javax.swing.JFrame;
import java.awt.Container;

public class BrowserFrame extends JFrame
{

    private static int defaultHeight = 500;
    private static int defaultWidth = 500;
    private static boolean isVisible = true;

    private String title = "Blank Page";

    public BrowserFrame()
    {
    
    	// Defaults
        setSize(defaultWidth, defaultHeight);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Container
		Container container = getContentPane();
		BrowserPanel bp = new BrowserPanel();
		bp.setFrame(this);
		container.add(bp);

        setVisible(isVisible);
    }

}
