package trafficlight.Controls;

import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;
import trafficlight.View.TrafficLightView;

import java.util.ArrayList;
import java.util.Collection;

public class TrafficLightManager {
    private static TrafficLightManager INSTANCE;
    private TrafficLight _trafficLight = new TrafficLight();
    private TrafficLightManager(){};
    public static TrafficLightManager getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new TrafficLightManager();
        }
        return INSTANCE;
    }

    public LightColor getColor(){return _trafficLight.getColor();}
    public void addListenner(TrafficLightView trafficLightView){_trafficLight.add(trafficLightView);}
}
