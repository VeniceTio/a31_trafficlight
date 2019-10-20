package trafficlightV4.Controls;

import trafficlightV4.Model.*;
import trafficlightV4.View.TrafficLightView;
import trafficlightV4.Uttilities.TrafficLightObserver;

import java.util.Collection;
import java.util.Vector;

public class TrafficLightManager {
    private static TrafficLightManager _instance;
    private Vector<TrafficLight> _trafficLights = new Vector<TrafficLight>();
    private City[] _cities = {new Strasbourg(),new Kehl()};

    private TrafficLightManager(){}
    public static TrafficLightManager getInstance()
    {
        if (_instance == null)
        {   _instance = new TrafficLightManager();
        }
        return _instance;
    }

    public void addTrafficLight(){
        TrafficLight TFL = new TrafficLight();
        TFL.setCity(_cities[0]);
        _trafficLights.add(TFL);
    }
    public void removeTrafficLight(int id){
        TrafficLight TFL = _instance.getTrafficLight(id);
        Collection<TrafficLightObserver> obs = TFL.getObservers();
        for(TrafficLightObserver view : obs){
            TrafficLightViewManager.getInstance().deleteView((TrafficLightView)view);
        }
        _trafficLights.remove(TFL);
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
    public void switchCity(int id){
        if(getTrafficLight(id).getCity().getType().equals(_cities[0].getType())){
            getTrafficLight(id).setCity(_cities[1]);
        }
        else{
            getTrafficLight(id).setCity(_cities[0]);
        }
    }
    public Vector<TrafficLight> getTrafficLights(){return _trafficLights;}
}
