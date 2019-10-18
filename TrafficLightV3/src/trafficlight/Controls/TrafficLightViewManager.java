package trafficlight.Controls;

import trafficlight.Model.TrafficLight;
import trafficlight.View.*;

import java.util.ArrayList;
import java.util.Collection;

public class TrafficLightViewManager {
    private Collection<TrafficLightView> _views = new ArrayList<TrafficLightView>();
    private static TrafficLightViewManager INSTANCE;

    public static TrafficLightViewManager getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new TrafficLightViewManager();
        }
        return INSTANCE;
    }

    public void createGraphicalView(){
        TrafficLightView view = new GraphicalLight(); //modifier
        _views.add(view);
        TrafficLightManager.getInstance().addListenner(view);
    }
    public void createTextualView(){
        TrafficLightView view = new TextualLight(); // modifier
        _views.add(view);
        TrafficLightManager.getInstance().addListenner(view);
    }
    public void createPedestriansView(){
        TrafficLightView view = new PedestriansView(); // modifier
        _views.add(view);
        TrafficLightManager.getInstance().addListenner(view);
    }
    public void createTurnRightView(){
        TrafficLightView view = new TurnRightView(); // modifier
        _views.add(view);
        TrafficLightManager.getInstance().addListenner(view);
    }
}
