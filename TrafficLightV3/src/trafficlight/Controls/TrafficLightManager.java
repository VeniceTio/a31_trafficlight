package trafficlight.Controls;

import trafficlight.Model.City;
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
    public Boolean getIsOn(){return _trafficLight.getIsOn();}
    public Boolean getIsStrasbourg(){return _trafficLight.isStrasbourg();}
    public void changeCity(City city){_trafficLight.setCity(city);}
    public void turnOnOff(){_trafficLight.onOff();}
    public void changeColor(){_trafficLight.swicthColor();}
    public void addListenner(TrafficLightView trafficLightView){_trafficLight.add(trafficLightView);}
}
