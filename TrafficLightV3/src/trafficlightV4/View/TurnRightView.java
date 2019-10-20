package trafficlightV4.View;

import trafficlightV4.Model.LightColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnRightView extends TrafficLightDecorateur {
    private Timer _timer;
    private Color _colorPan = Color.GRAY;
    private TrafficLightDecorateur _this;

    public TurnRightView(TrafficLightView trafficLightView){
        super(trafficLightView);
        _this = this;
        this.setTitle("Turn Right View");
        trafficLightView.changeVisibility();

        this.getColorPan().setBackground(Color.RED);
        this.getContentPane().add(this.getColorPan(), BorderLayout.CENTER);
        this.setVisible(true);

        ActionListener changeColor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (_colorPan==Color.GRAY){
                    _this.getColorPan().setBackground(Color.ORANGE);
                    _colorPan = Color.ORANGE;
                }
                else {
                    _this.getColorPan().setBackground(Color.GRAY);
                    _colorPan = Color.GRAY;
                }
            }
        };

        _timer = new Timer(500,changeColor);
        _timer.start();
    }

    @Override
    public void update(LightColor color, Boolean isOn) {
        if (isOn){
            if (color==LightColor.RED){
                _timer.start();
            }
            else {
                _timer.stop();
                this.getColorPan().setBackground(Color.GRAY);
            }
        }
        else {
            _timer.stop();
            this.getColorPan().setBackground(Color.GRAY);
        }

    }
}
