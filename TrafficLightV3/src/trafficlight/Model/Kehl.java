package trafficlight.Model;

public class Kehl implements City{

    public void changeColor(TrafficLight trafficLight) {
        switch (trafficLight.getColor()) {
            case GREEN:
                trafficLight.setColor(LightColor.ORANGE);
                break;
            case ORANGE:
                if(trafficLight.getHistory()==LightColor.GREEN){
                    trafficLight.setColor(LightColor.RED);
                }
                else {
                    trafficLight.setColor(LightColor.GREEN);
                }
                break;
            case RED:
                trafficLight.setColor(LightColor.GREEN);
                break;
            default:
                return;
        }
    }
}
