package trafficlight.View;

import trafficlight.Controls.TrafficLightManager;
import trafficlight.Controls.TrafficLightViewManager;
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

    private City[] _strategie = {new Strasbourg(),new Kehl()};

    public Menu(){
        TrafficLightManager.getInstance().changeCity(_strategie[0]);

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
        buttons.add( new JButton( new AbstractAction("AddPedestriansView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPedestriansView();
            }
        }));

        buttons.add( new JButton( new AbstractAction("AddTurnRightView") {
            @Override
            public void actionPerformed(ActionEvent arg0) { addTurnRightView();}
        }));
        buttons.add( new JButton( new AbstractAction("On/Off") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                TrafficLightManager.getInstance().turnOnOff();
            }
        }));

        buttons.add( new JButton( new AbstractAction("Change color") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                TrafficLightManager.getInstance().changeColor();
            }
        }));
        buttons.add( new JButton( new AbstractAction("Change city") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeStrategy();
            }
        }));
        this.getContentPane().add(buttons);
        this.setVisible(true);
    }
    public void addTextualView(){
        TrafficLightViewManager.getInstance().createTextualView();
    }
    public void addGraphicalView(){
        TrafficLightViewManager.getInstance().createGraphicalView();
    }
    public void addPedestriansView(){
        TrafficLightViewManager.getInstance().createPedestriansView();
    }
    public void addTurnRightView(){
        TrafficLightViewManager.getInstance().createTurnRightView();
    }
    public void changeStrategy(){
        System.out.println("action");
        if(TrafficLightManager.getInstance().getIsStrasbourg()){
            TrafficLightManager.getInstance().changeCity(_strategie[1]);
        }
        else{
            TrafficLightManager.getInstance().changeCity(_strategie[0]);
        }
    }
}
