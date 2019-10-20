package trafficlightV4.View;

import trafficlightV4.Uttilities.TrafficLightObserver;
import java.awt.BorderLayout;
import javax.swing.*;

public abstract class TrafficLightView extends JInternalFrame implements TrafficLightObserver {


	public TrafficLightView() {

		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(200, 200);
		this.setLayout(new BorderLayout());
	}
	public void changeVisibility(){this.setVisible(false);}
	public String toString(){return "box";}

}

