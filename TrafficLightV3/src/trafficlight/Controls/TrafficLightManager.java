package trafficlight.Controls;

import trafficlight.Model.City;
import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;
import trafficlight.View.TrafficLightView;
import trafficlight.uttilities.TrafficLightObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class TrafficLightManager {
    private static TrafficLightManager _instance;
    private Vector<TrafficLight> _trafficLights = new Vector<TrafficLight>();

    private TrafficLightManager(){}
    public static TrafficLightManager getInstance()
    {
        if (_instance == null)
        {   _instance = new TrafficLightManager();
        }
        return _instance;
    }

    public void addTrafficLight(City city){
        TrafficLight TFL = new TrafficLight();
        TFL.setCity(city);
        _trafficLights.add(TFL);
    }
    public void removeTrafficLight(int id){
        TrafficLight TFL = _instance.getTrafficLight(id);
        Collection<TrafficLightObserver> obs = TFL.getObservers();
        for(TrafficLightObserver view : obs){
            TrafficLightViewManager.getInstance().deleteView((TrafficLightView)view);
        }
        _trafficLights.remove(id);
    }
    public TrafficLight getTrafficLight(int id){
        TrafficLight trafficLight = null;
        for(TrafficLight TFL : _trafficLights){
            if (TFL.getID()==id){
                trafficLight = TFL;
            }
        }
        return trafficLight;
    }
    public Vector<TrafficLight> getTrafficLights(){return _trafficLights;}
    public LightColor getColor(TrafficLight TFL){return _trafficLights.get(_trafficLights.indexOf(TFL)).getColor();}
    public Boolean getIsOn(TrafficLight TFL){return _trafficLights.get(_trafficLights.indexOf(TFL)).getIsOn();}

}
