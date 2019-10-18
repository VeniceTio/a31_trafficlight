package trafficlight.View;

import trafficlight.Controls.TrafficLightManager;
import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class GraphicalLight extends TrafficLightView {

	private JPanel _panel;

	public GraphicalLight() {
		super();
		this.setTitle("Graphical view");

		_panel = new JPanel();
		_panel.setBackground(Color.RED);
		this.getContentPane().add(_panel, BorderLayout.CENTER);

		update(TrafficLightManager.getInstance().getColor(), TrafficLightManager.getInstance().getIsOn());
		this.setVisible(true);
	}


	@Override
	public void update(LightColor color, Boolean isOn ) {
		if ( isOn ) {
			switch ( color ) {
				case RED:
					_panel.setBackground(Color.RED);
					break;
				case GREEN:
					_panel.setBackground(Color.GREEN);
					break;
				case ORANGE:
					_panel.setBackground(Color.ORANGE);
					break;
				default:
					break;
			}
		}
		else {
			_panel.setBackground(Color.GRAY);
		}
	}

}

