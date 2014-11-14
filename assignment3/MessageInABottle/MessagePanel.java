import java.awt.*;
import javax.swing.*;

public class MessagePanel extends JPanel
{

    public void paintComponent(Graphics g)
    {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screensize = tk.getScreenSize();

        super.paintComponent(g);
        g.drawString("Help! I'm trapped in CS II!", 400, 500);
        g.drawLine(
            350,
            800,
            650,
            800
        );
        g.drawLine(
            350,
            800,
            350,
            500
        );
        g.drawLine(
            650,
            800,
            650,
            500
        );
        g.drawLine(
            350,
            500,
            450,
            200
        );
        g.drawLine(
            650,
            500,
            550,
            200
        );
        g.drawOval(
            450,
            170,
            100,
            50
        );
    }

}
