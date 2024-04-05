package data_layer;

import java.util.Random;

public class Temperature extends Measurement{
	
	private Double celciusMeasurement;		//every measurement unit is an attribute
    private Double fahrenheitMeasurement;
    private Double kelvinMeasurement;
    
    public Temperature(int year, int month) {
		super(year, month);
		setCelcius();
		setMeasurements();
	}
    
    private void setCelcius() {				//celcius is choosen from the range (-40,50)
    	Random random = new Random();
    	this.celciusMeasurement = random.nextDouble(-40,50);
    }
    
    private void setMeasurements() {		//other unit attributes are derived from the celcius attribute
    	this.fahrenheitMeasurement = ((celciusMeasurement*1.8)+32);
		this.kelvinMeasurement = celciusMeasurement+273.15;
    }
    
    public Temperature(Temperature otherTemperature){
    	super(otherTemperature);		//sets month and year of copied object to our original object's.
    	this.celciusMeasurement = otherTemperature.celciusMeasurement;
    	this.fahrenheitMeasurement = otherTemperature.fahrenheitMeasurement;
    	this.kelvinMeasurement = otherTemperature.kelvinMeasurement;
    }
    
    public void setInCelcius(double celcius) {		//we need this method to calculate felt temperature in city
    	this.celciusMeasurement = celcius;			//so we divided setMeasurements and setCelcius
    	setMeasurements();
    }
    
    public Double getCelcius() {
        return celciusMeasurement;
    }
    
    public Double getFahrenheit() {
        return fahrenheitMeasurement;
    }
    
    public Double getKelvin() {
        return kelvinMeasurement;
    }
}