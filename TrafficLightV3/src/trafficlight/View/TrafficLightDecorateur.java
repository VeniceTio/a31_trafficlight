package trafficlight.View;

import trafficlight.Model.TrafficLight;

import javax.swing.*;

public abstract class TrafficLightDecorateur extends TrafficLightView {
    private JPanel _colorPanel;
    private TrafficLightView _trafficLightView;
    TrafficLightDecorateur(TrafficLightView trafficLightView){
        super();
        _trafficLightView = trafficLightView;
        _colorPanel = new JPanel();
    }
    public JPanel getColorPan(){
        return _colorPanel;
    }

}
