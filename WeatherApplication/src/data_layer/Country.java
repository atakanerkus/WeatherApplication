package data_layer;

public class Country extends Location{
	//country is inherited from Location class
	Temperature temperature;
	
	public Country(String countryName){
		super(countryName);
	}
	
	public Country(Country country){
		super(country);
	}
}