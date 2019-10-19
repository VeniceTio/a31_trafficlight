package trafficlight.Model;

public class Kehl implements City{
    private LightColor _history;

    public void changeColor(TrafficLight trafficLight) {
        switch (trafficLight.getColor()) {
            case GREEN:
                trafficLight.setColor(LightColor.ORANGE);
                _history=LightColor.GREEN;
                break;
            case ORANGE:
                if(_history==LightColor.GREEN){
                    trafficLight.setColor(LightColor.RED);
                }
                else {
                    trafficLight.setColor(LightColor.GREEN);
                }
                break;
            case RED:
                trafficLight.setColor(LightColor.ORANGE);
                _history=LightColor.RED;
                break;
            default:
                return;
        }
    }

    @Override
    public String getType() {
        return "Kehl";
    }
}
