package trafficlight.View;

import trafficlight.Model.City;
import trafficlight.Model.Kehl;
import trafficlight.Model.Strasbourg;
import trafficlight.Model.TrafficLight;
import trafficlight.View.GraphicalLight;
import trafficlight.View.TextualLight;
import trafficlight.View.TrafficLightView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{

    private TrafficLight _trafficLight;
    private City[] _strategie = {new Strasbourg(),new Kehl()};

    public Menu(TrafficLight tfl){
        this._trafficLight = tfl;
        _trafficLight.setCity(_strategie[0]);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 480);
        this.setLayout(new BorderLayout());
        this.setTitle("Menu");

        JPanel buttons = new JPanel();
        buttons.add( new JButton( new AbstractAction("AddTextualView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addTextualView();
            }
        }));

        buttons.add( new JButton( new AbstractAction("AddGraphicalView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addGraphicalView();
            }
        }));
        buttons.add( new JButton( new AbstractAction("On/Off") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                _trafficLight.onOff();
            }
        }));

        buttons.add( new JButton( new AbstractAction("Change color") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                _trafficLight.swicthColor();
            }
        }));²
        this.getContentPane().add(buttons);
        this.setVisible(true);
    }
    public void addTextualView(){
        TrafficLightView view = new TextualLight( this._trafficLight );
        this._trafficLight.add(view);
    }
    public void addGraphicalView(){
        TrafficLightView view = new GraphicalLight( this._trafficLight );
        this._trafficLight.add(view);
    }
    public void changeStrategy(){
        if(_trafficLight.isStrasbourg()){
            _trafficLight.setCity(_strategie[1]);
        }
        else{
            _trafficLight.setCity(_strategie[0]);
        }
    }
}
