package trafficlight.View;

import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class GraphicalLight extends TrafficLightView {

	private JPanel _colorPanel;

	public GraphicalLight( TrafficLight trafficLight ) {
		super(trafficLight);

		this.setTitle("Graphical view");

		_colorPanel = new JPanel();
		_colorPanel.setBackground(Color.RED);
		this.getContentPane().add(_colorPanel, BorderLayout.CENTER);

		update(trafficLight.getColor(),trafficLight.getIsOn());
		this.setVisible(true);
	}

	@Override
	public void update(LightColor color, Boolean isOn ) {
		if ( isOn ) {
			switch ( color ) {
				case RED:
					_colorPanel.setBackground(Color.RED);
					break;
				case GREEN:
					_colorPanel.setBackground(Color.GREEN);
					break;
				case ORANGE:
					_colorPanel.setBackground(Color.ORANGE);
					break;
				default:
					break;
			}
		}
		else {
			_colorPanel.setBackground(Color.GRAY);
		}
	}

}

