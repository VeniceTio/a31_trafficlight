package trafficlight.Model;

public class Strasbourg implements City {

    public void changeColor(TrafficLight trafficLight) {
        switch (trafficLight.getColor()) {
            case GREEN:
                trafficLight.setColor(LightColor.ORANGE);
                break;
            case ORANGE:
                trafficLight.setColor(LightColor.RED);
                break;
            case RED:
                trafficLight.setColor(LightColor.GREEN);
                break;
            default:
                return;
        }
    }

    @Override
    public String getType() {
        return "Strasbourg";
    }
}
