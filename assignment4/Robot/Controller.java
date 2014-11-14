import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controller extends JButton
{

    private int action = 11;
    private static RModel model = null;

	/**
	 * Default constructor if no text is given
	 */
    public Controller()
    {
        super("Default");
        this.addActionListener(new Listener());
    }
    
    /**
     * Constructor that should always be used, this will add the text wanted and instantiate the action listener
     */
    public Controller(String title)
    {
    	super();
        this.setText(title);
        this.addActionListener(new Listener());
    }

    public void setAction(int action)
    {
        this.action = action;
    }

	public void setModel(RModel model)
    {
        this.model = model;
    }

    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
    		model.doAction(action);
        }
    }
}
