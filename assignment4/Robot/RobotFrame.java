import javax.swing.JFrame;
import java.awt.Container;

public class RobotFrame extends JFrame
{

    private static String TITLE = "Robot Connector";

    public RobotFrame()
    {
        // Defaults
        setSize(500, 500);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = getContentPane();
        RobotPanel rp = new RobotPanel();
        content.add(rp);

        setVisible(true);
    }
}
