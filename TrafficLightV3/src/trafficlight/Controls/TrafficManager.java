package trafficlight.Controls;

import trafficlight.Model.TrafficLight;
import trafficlight.View.Menu;

public class TrafficManager {
    private TrafficLight _trafficLight;

	public TrafficManager() {
		this._trafficLight =  new TrafficLight();
		Menu _menu = new Menu(this._trafficLight);
	}

	public static void main(String[] args) {
		new TrafficManager();
	}

}