package trafficlight.Model;

import trafficlight.uttilities.Observable;

public class TrafficLight extends Observable {

	private Boolean _isOn = false;
	private LightColor _color = LightColor.RED;
	private LightColor _history = LightColor.ORANGE;
	private City _city;
	private Boolean _isStrasbourg = true;

	public TrafficLight() {}

	public void onOff() {
		_isOn = !_isOn;
		_color = LightColor.RED;
		notifyObservers( _color, _isOn );
	}

	public void swicthColor() {
		_city.changeColor(this);
		notifyObservers( _color, _isOn ) ;
	}
	public City getCity(){return _city;}
	public void setCity(City city){_city = city;_isStrasbourg=!_isStrasbourg;}
	public LightColor getColor(){
	    return this._color;
    }
    void setColor(LightColor lightColor){
		this._history = _color;
		this._color = lightColor;}
    public Boolean getIsOn(){
	    return this._isOn;
    }
    public LightColor getHistory(){return _history;}
    public Boolean isStrasbourg(){
		return _isStrasbourg;
	}

}

