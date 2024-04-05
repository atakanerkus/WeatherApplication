package data_layer;

public class Humidity extends Measurement{
		private double humidityPercentage;
		
	public Humidity(int year, int month, double humidityPercentage) {
		super(year, month);
		this.humidityPercentage = humidityPercentage;
	}
	
	public Humidity(Humidity otherHumidity){
    	super(otherHumidity);		//sets month and year of copied object to our original object's.
    	this.humidityPercentage = otherHumidity.humidityPercentage;
	}

	public double getHumidityPercentage() {
		return humidityPercentage;
	}

}
