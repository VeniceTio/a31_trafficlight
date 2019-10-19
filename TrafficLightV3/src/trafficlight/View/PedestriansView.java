package trafficlight.View;

import trafficlight.Controls.TrafficLightManager;
import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;

import javax.swing.*;
import java.awt.*;

public class PedestriansView extends TrafficLightDecorateur {
    public PedestriansView(TrafficLightView trafficLightView){
        super(trafficLightView);
        this.setTitle("Pedestrian view");
        trafficLightView.changeVisibility();

        this.getColorPan().setBackground(Color.RED);
        this.getContentPane().add(this.getColorPan(), BorderLayout.CENTER);

        this.setVisible(true);
    }
    @Override
    public void update(LightColor color, Boolean isOn) {
        if (isOn){
            if (color==LightColor.RED) {
                this.getColorPan().setBackground(Color.GREEN);
            }
            else{
                this.getColorPan().setBackground(Color.RED);
            }
        }
        else{
            this.getColorPan().setBackground(Color.GRAY);
        }
    }
}
