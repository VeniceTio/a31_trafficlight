package trafficlightV4.uttilities;

import trafficlightV4.Model.LightColor;

public interface TrafficLightObserver {
	public abstract void update(LightColor color, Boolean isOn );
}

