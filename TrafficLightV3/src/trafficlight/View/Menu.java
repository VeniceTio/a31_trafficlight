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
    private JDesktopPane _desktop = new JDesktopPane();
    JComboBox _cbo = new JComboBox(new DefaultComboBoxModel(TrafficLightViewManager.getInstance().getViews()));

    public Menu(){
        TrafficLightManager.getInstance().changeCity(_strategie[0]);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 500);
        this.setLayout(new BorderLayout());
        this.setTitle("Traffic Light");
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
        buttons.add(_cbo);
        buttons.add( new JButton( new AbstractAction("Delete frame") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                TrafficLightViewManager.getInstance().deleteView((TrafficLightView)_cbo.getSelectedItem());
            }
        }));
        this.getContentPane().add(buttons,BorderLayout.NORTH);
        this.getContentPane().add(_desktop,BorderLayout.CENTER);
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
    public JDesktopPane getDesktop(){return _desktop;}
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
