import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrowserPanel extends JPanel
{

	BrowserFrame frame;
	JTextArea textView;
	JTextField urlBar;
	JScrollPane scroller;
	
	private static final String ERROR_MESSAGE = "ERROR: Incorrect url or bad connection.";

	public BrowserPanel()
	{
		super();
		setLayout(new BorderLayout());
		
		urlBar = new JTextField();
		textView = new JTextArea();
		textView.setLineWrap(true);
		scroller = new JScrollPane(textView);
		
		urlBar.addActionListener(new PageRequest());
		
		add(urlBar, BorderLayout.PAGE_START);
		add(scroller, BorderLayout.CENTER);
	}
	
	public void paintCompoent(Graphics g)
	{
		super.paintComponent(g);
	}
	
	public void setFrame(BrowserFrame frame)
	{
		this.frame = frame;
	}
	
	
	private class PageRequest implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String url = urlBar.getText();
			
			BrowserModal bm = new BrowserModal();
			
			String pageText = bm.getPage(url);
			
			if(pageText != null)
			{
				textView.setText(pageText);
				String title = bm.getWebPageTitle();
				if(title != null)
				{
					frame.setTitle(title);
				}
			}
			else
			{
				textView.setText(ERROR_MESSAGE);
			}
			
		}
	}
	
}