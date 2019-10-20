package trafficlightV4.View;

import javax.swing.*;

public abstract class TrafficLightDecorateur extends TrafficLightView {
    private JPanel _colorPanel;
    private TrafficLightView _decorated;
    TrafficLightDecorateur(TrafficLightView trafficLightView){
        super();
        _decorated = trafficLightView;
        _colorPanel = new JPanel();
    }
    public JPanel getColorPan(){
        return _colorPanel;
    }

}
