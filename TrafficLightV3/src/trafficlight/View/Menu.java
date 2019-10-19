package trafficlight.View;

import trafficlight.Controls.TrafficLightManager;
import trafficlight.Controls.TrafficLightViewManager;
import trafficlight.Model.City;
import trafficlight.Model.Kehl;
import trafficlight.Model.Strasbourg;
import trafficlight.Model.TrafficLight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{

    private City[] _strategie = {new Strasbourg(),new Kehl()};
    private JDesktopPane _desktop = new JDesktopPane();
    JComboBox _cboView = new JComboBox(new DefaultComboBoxModel(TrafficLightViewManager.getInstance().getViews()));
    JComboBox _cboTrafficLight = new JComboBox(new DefaultComboBoxModel(TrafficLightManager.getInstance().getTrafficLights()));

    public Menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 500);
        this.setLayout(new BorderLayout());
        this.setTitle("Traffic Light");
        TrafficLightManager.getInstance().addTrafficLight(_strategie[0]);
        JPanel buttons = new JPanel();
        buttons.add( new JButton( new AbstractAction("Add TrafficLight") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addTrafficLight();
            }
        }));
        buttons.add(_cboTrafficLight);
        buttons.add( new JButton( new AbstractAction("Delete TrafficLight") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (_cboTrafficLight.getItemCount()>1){
                    deleteTrafficLight(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());
                }
            }
        }));
        buttons.add( new JButton( new AbstractAction("AddTextualView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addTextualView(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());
            }
        }));

        buttons.add( new JButton( new AbstractAction("AddGraphicalView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addGraphicalView(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());
            }
        }));
        buttons.add( new JButton( new AbstractAction("AddPedestriansView") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPedestriansView(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());
            }
        }));

        buttons.add( new JButton( new AbstractAction("AddTurnRightView") {
            @Override
            public void actionPerformed(ActionEvent arg0) { addTurnRightView(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());}
        }));
        buttons.add( new JButton( new AbstractAction("On/Off") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ((TrafficLight)_cboTrafficLight.getSelectedItem()).onOff();
            }
        }));

        buttons.add( new JButton( new AbstractAction("Change color") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                TrafficLightManager.getInstance().getTrafficLight(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID()).swicthColor();
            }
        }));
        buttons.add( new JButton( new AbstractAction("Change city") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeStrategy(((TrafficLight)_cboTrafficLight.getSelectedItem()).getID());
            }
        }));
        buttons.add(_cboView);
        buttons.add( new JButton( new AbstractAction("Delete frame") {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (_cboView.getItemCount()>0){
                    TrafficLightViewManager.getInstance().deleteView((TrafficLightView) _cboView.getSelectedItem());
                }
            }
        }));
        this.getContentPane().add(buttons,BorderLayout.NORTH);
        this.getContentPane().add(_desktop,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void addTrafficLight(){
        TrafficLightManager.getInstance().addTrafficLight(_strategie[0]);
    }
    public void deleteTrafficLight(int id){
        TrafficLightManager.getInstance().removeTrafficLight(id);
    }
    public void addTextualView(int id){
        TrafficLightViewManager.getInstance().createTextualView(id);
    }
    public void addGraphicalView(int id){
        TrafficLightViewManager.getInstance().createGraphicalView(id);
    }
    public void addPedestriansView(int id){
        TrafficLightViewManager.getInstance().createPedestriansView(id);
    }
    public void addTurnRightView(int id){
        TrafficLightViewManager.getInstance().createTurnRightView(id);
    }
    public JDesktopPane getDesktop(){return _desktop;}
    public void changeStrategy(int id){
        System.out.println("action");
        if(TrafficLightManager.getInstance().getTrafficLight(id).getCity().getType().equals(_strategie[0].getType())){
            TrafficLightManager.getInstance().getTrafficLight(id).setCity(_strategie[1]);
        }
        else{
            TrafficLightManager.getInstance().getTrafficLight(id).setCity(_strategie[0]);
        }
    }
}
