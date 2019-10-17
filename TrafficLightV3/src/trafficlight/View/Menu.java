package trafficlight.View;

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

    public Menu(TrafficLight tfl){
        this._trafficLight = tfl;

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
            _trafficLight.setCity(new Kehl());
        }
        else{
            _trafficLight.setCity(new Strasbourg());
        }
    }
}
