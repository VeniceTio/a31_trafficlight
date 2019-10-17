package trafficlight.uttilities;

import trafficlight.Model.LightColor;

public interface TrafficLightObserver {
	public abstract void update(LightColor color, Boolean isOn );
}

