package trafficlight.View;

import trafficlight.Model.LightColor;
import trafficlight.Model.TrafficLight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnRightView extends TrafficLightDecorateur {
    private Timer _timer;
    public TurnRightView(TrafficLightView trafficLightView, TrafficLight trafficLight){
        super(trafficLightView, trafficLight);
        this.setTitle("Turn Right View");

        this.getColorPan().setBackground(Color.RED);
        this.getContentPane().add(this.getColorPan(), BorderLayout.CENTER);

        update(trafficLight.getColor(),trafficLight.getIsOn());
        this.setVisible(true);

        ActionListener changeColor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (trafficLightView.getColorPan().get)
            }
        }

        Timer timer = new Timer(200,changeColor);
    }

    @Override
    public void update(LightColor color, Boolean isOn) {
        if (isOn){
            if (color==LightColor.RED){
                _timer.start();
            }
        }
        else {
            _timer.stop();
            this.getColorPan().setBackground(Color.GRAY);
        }
    }
}
