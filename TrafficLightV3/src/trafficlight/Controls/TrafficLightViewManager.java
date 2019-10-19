package trafficlight.Controls;

import trafficlight.Model.TrafficLight;
import trafficlight.View.*;
import trafficlight.View.Menu;

import java.awt.*;
import java.util.Vector;

public class TrafficLightViewManager {
    private Vector<TrafficLightView> _views = new Vector<TrafficLightView>();
    private int nbr;
    private Menu _frame;
    private static TrafficLightViewManager INSTANCE;

    private static int _frameCountY=1;
    private static int _frameCountX=0;

    public static TrafficLightViewManager getInstance()
    {
        if (INSTANCE == null) {
            INSTANCE = new TrafficLightViewManager();
            INSTANCE._frame = new Menu();
        }
        return INSTANCE;
    }

    public void createGraphicalView(int id){
        TrafficLightView view = new GraphicalLight();
        addView(id,view);
    }
    public void createTextualView(int id){
        TrafficLightView view = new TextualLight();
        addView(id,view);
    }
    public void createPedestriansView(int id){
        TrafficLightView view = new PedestriansView(new GraphicalLight());
        addView(id,view);
    }
    public void createTurnRightView(int id){
        TrafficLightView view = new TurnRightView(new GraphicalLight());
        addView(id,view);
    }
    public void addView(int id,TrafficLightView view){
        _views.add(view);
        _frame.getDesktop().add(view);
        view.toFront();
        view.update(TrafficLightManager.getInstance().getTrafficLight(id).getColor(),TrafficLightManager.getInstance().getTrafficLight(id).getIsOn());
        TrafficLightManager.getInstance().getTrafficLight(id).add(view);
        view.setLocation(new Point(15*_frameCountY+100*_frameCountX, 15*_frameCountY));
        if(_frameCountY++>9){
            _frameCountY=1;
            if(_frameCountX++>5){
                _frameCountY=1;
                _frameCountX=1;
            }
        }
    }
    public Vector<TrafficLightView> getViews(){

        return _views;
    }
    public void deleteView(TrafficLightView trafficLightView){
        trafficLightView.dispose();
        _views.remove(trafficLightView);
    }
}
