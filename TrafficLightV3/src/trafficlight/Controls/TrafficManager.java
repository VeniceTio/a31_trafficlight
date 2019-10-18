package trafficlight.Controls;

import trafficlight.Model.TrafficLight;
import trafficlight.View.Menu;

public class TrafficManager {
    private TrafficLight _trafficLight;

	public TrafficManager() {
		Menu _menu = new Menu();
	}

	public static void main(String[] args) {
		new TrafficManager();
	}

}
