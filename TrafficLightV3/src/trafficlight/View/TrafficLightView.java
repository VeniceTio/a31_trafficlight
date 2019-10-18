package trafficlight.View;

import trafficlight.Model.TrafficLight;
import trafficlight.uttilities.TrafficLightObserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

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

