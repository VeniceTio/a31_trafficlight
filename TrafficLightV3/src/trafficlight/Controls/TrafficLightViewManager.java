package trafficlight.Controls;

import trafficlight.Model.TrafficLight;
import trafficlight.View.*;
import trafficlight.View.Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import static java.awt.SystemColor.menu;

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

    public void createGraphicalView(){
        TrafficLightView view = new GraphicalLight();
        addView(view);
    }
    public void createTextualView(){
        TrafficLightView view = new TextualLight();
        addView(view);
    }
    public void createPedestriansView(){
        TrafficLightView view = new PedestriansView(new GraphicalLight());
        addView(view);
    }
    public void createTurnRightView(){
        TrafficLightView view = new TurnRightView(new GraphicalLight());
        addView(view);
    }
    public void addView(TrafficLightView view){
        _views.add(view);
        _frame.getDesktop().add(view);
        view.toFront();
        TrafficLightManager.getInstance().addListenner(view);
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
