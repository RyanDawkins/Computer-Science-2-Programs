import java.awt.*;
import javax.swing.*;

public class TriPanel extends JPanel
{

	public void paintComponent(Graphics g)
	{
		int height = getHeight();
		int width = getWidth();
		int depth = (height < width) ? height : width;
		triGenerator(g, 0, 0, depth);
		repaint();
	}
	
	public void screenResize()
	{
		paintComponent(getGraphics());
	}
	
	public void triGenerator(Graphics g, int x, int y, int depth)
	{
	
		if(depth == 1)
		{
			g.drawRect(x, y, 1, 1);
		}
		else
		{
			// Center Pixel
			int xC = x + (depth / 4);
			int yC = y;
			triGenerator(g, xC, yC, depth / 2);
		
			// Left Pixel
			int xL = x;
			int yL = y + (depth / 2);
			triGenerator(g, xL, yL, depth / 2);
		
			// Right Pixel
			int xR = x + (depth / 2);
			int yR = y + (depth / 2);
			triGenerator(g, xR, yR, depth / 2);
		}
	}

}