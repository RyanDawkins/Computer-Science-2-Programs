import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class MessageFrame extends JFrame
{

    private String title = "Message In a Bottle";
    private int WINDOW_HEIGHT = 1000;
    private int WINDOW_WIDTH = 1000;


    public MessageFrame()
    {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        MessagePanel mp = new MessagePanel();
        contentPane.add(mp);
        setVisible(true);
    }
}
