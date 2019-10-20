package trafficlightV4.Model;

import trafficlightV4.uttilities.Observable;

public class TrafficLight extends Observable {

	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;
	private City _city;
	private int _id;
	private static int nextID =0;

	public TrafficLight() {_id= nextID;
		nextID++;}

	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers( _color, _isOn );
	}
	public int getID(){
		return _id;
	}
	public void swicthColor() {
		_city.changeColor(this);
		notifyObservers( _color, _isOn ) ;
	}
	public City getCity(){return _city;}
	public void setCity(City city){_city = city;}
	public LightColor getColor(){
	    return this._color;
    }
    void setColor(LightColor lightColor){
		this._color = lightColor;}
    public Boolean getIsOn(){
	    return this._isOn;
    }
}

