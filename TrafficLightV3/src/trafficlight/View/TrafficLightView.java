package trafficlight.View;

import trafficlight.Model.TrafficLight;
import trafficlight.uttilities.TrafficLightObserver;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TrafficLightView extends JFrame implements TrafficLightObserver {

	private TrafficLight _trafficLight;

	public TrafficLightView( TrafficLight trafficLight ) {

		_trafficLight = trafficLight;

		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(600, 480);
		this.setLayout(new BorderLayout());

	}

}

