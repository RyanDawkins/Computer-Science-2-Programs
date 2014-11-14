import javax.swing.JPanel;
import java.awt.Graphics;

public class RobotPanel extends JPanel
{

    Controller launchBtn = null;
    Controller landBtn = null;
    Controller turnLBtn = null;
    Controller turnRBtn = null;
    Controller forwardBtn = null;
    Controller backwardBtn = null;
    Controller leftBtn = null;
    Controller rightBtn = null;
    Controller upBtn = null;
    Controller downBtn = null;
    Controller stopBtn = null;
    
    RModel model = null;

    public RobotPanel()
    {
        super();
        initializeButtons();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    public void initializeButtons()
    {
    	
    	this.model = new RModel();
    
        this.launchBtn = new Controller("Launch");
        this.launchBtn.setAction(RModel.LAUNCH);
        this.launchBtn.setModel(this.model);
        this.add(this.launchBtn);
        
        this.landBtn = new Controller("Land");
        this.landBtn.setAction(RModel.LAND);
        this.landBtn.setModel(this.model);
        this.add(this.landBtn);
        
        this.turnLBtn = new Controller("Turn Left");
        this.turnLBtn.setAction(RModel.TURN_LEFT);
        this.turnLBtn.setModel(this.model);
        this.add(this.turnLBtn);
        
        this.turnRBtn = new Controller("Turn Right");
        this.turnRBtn.setAction(RModel.TURN_RIGHT);
        this.turnRBtn.setModel(this.model);
        this.add(this.turnRBtn);
        
        this.forwardBtn = new Controller("Move Forward");
        this.forwardBtn.setAction(RModel.MOVE_FORWARD);
        this.forwardBtn.setModel(this.model);
        this.add(this.forwardBtn);
        
        this.backwardBtn = new Controller("Move Backward");
        this.backwardBtn.setAction(RModel.MOVE_BACKWARD);
        this.backwardBtn.setModel(this.model);
        this.add(this.backwardBtn);
        
        this.leftBtn = new Controller("Move Left");
        this.leftBtn.setAction(RModel.MOVE_LEFT);
        this.leftBtn.setModel(this.model);
        this.add(this.leftBtn);
        
        this.rightBtn = new Controller("Move Right");
        this.rightBtn.setAction(RModel.MOVE_RIGHT);
        this.rightBtn.setModel(this.model);
        this.add(this.rightBtn);
        
        this.upBtn = new Controller("Move Up");
        this.upBtn.setAction(RModel.MOVE_UP);
        this.upBtn.setModel(this.model);
        this.add(this.upBtn);
        
        this.downBtn = new Controller("Move Down");
        this.downBtn.setAction(RModel.MOVE_DOWN);
        this.downBtn.setModel(this.model);
        this.add(this.downBtn);
        
        this.stopBtn = new Controller("Stop");
        this.stopBtn.setAction(RModel.STOP);
        this.stopBtn.setModel(this.model);
        this.add(this.stopBtn);
    }
}
