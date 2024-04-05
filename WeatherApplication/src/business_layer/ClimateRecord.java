package business_layer;

import java.util.ArrayList;

import data_layer.*;

/*	
  	every city and country will be held here and
	their measurements are held within the location itself
	measurements are 2d arrayList objects which organized as 
	(3years) * 12months
	this class is for query class access.
	and includes methods for query
*/

public class ClimateRecord {	
	FileIO file = new FileIO();
	ArrayList<Country> countryArrayList = file.getCountryArrayList();
	ArrayList<City> cityArrayList = file.getCityArrayList();
	
	public ArrayList<Country> getCountryArrayList() {
		ArrayList<Country> tempList = new ArrayList<Country>();
		for(int i=0;i<countryArrayList.size();i++) {
			Country newCountry = new Country(countryArrayList.get(i));
			tempList.add(newCountry);
		}
		return tempList;	//copied ArrayList to make deep copy
	}
	
	public ArrayList<City> getCityArrayList() {
		ArrayList<City> tempList = new ArrayList<City>();
		for(int i=0;i<cityArrayList.size();i++) {
			City newCity = new City(cityArrayList.get(i));
			tempList.add(newCity);
		}
		return tempList;	//copied ArrayList to make deep copy
	}
	
	public double getAverageTemperatureOfYear(Location loc, int year, String measurementType) {
		double sum = 0;
		if(measurementType.equals("Celcius")) {
			for(int i=0;i<loc.getTemperatureArrayList().get(year).size();i++) {			//i<12
				sum+=loc.getTemperatureArrayList().get(year).get(i).getCelcius();
			}
			return sum/loc.getTemperatureArrayList().get(year).size();					//sum/12
		}
		if(measurementType.equals("Fahrenheit")) {
			for(int i=0;i<loc.getTemperatureArrayList().get(year).size();i++) {			//i<12
				sum+=loc.getTemperatureArrayList().get(year).get(i).getFahrenheit();
			}
			return sum/loc.getTemperatureArrayList().get(year).size();					//sum/12
		}
		if(measurementType.equals("Kelvin")) {
			for(int i=0;i<loc.getTemperatureArrayList().get(year).size();i++) {			//i<12
				sum+=loc.getTemperatureArrayList().get(year).get(i).getKelvin();
			}
			return sum/loc.getTemperatureArrayList().get(year).size();					//sum/12
		}
		else {
			System.out.println("Error invalid measurementType");
			System.out.println("Error occured in getAverageTemperatureOfYear method in ClimateRecord");
			return -1000;
		}
	}
	
	public double getAverageWindSpeedOfMonth(City city, String unit, String monthOfYears) {//unit --> [1](km/h) , [2](m/s)
		double sum = 0.0;
		if(unit.equals("1")) {
			for(int i=0;i<city.getWindSpeedArrayList().size();i++) {	//i<3(year count)
				for(int j=0;j<city.getWindSpeedArrayList().get(i).size();j++) {		//j<12(month count in a year)
					if(monthOfYears.equals(city.getWindSpeedArrayList().get(i).get(j).getMonth().toString())) {		//we search the month we 
						sum+=city.getWindSpeedArrayList().get(i).get(j).getSpeed_KmPerH();							//want in enum-month	
					}																								//in all lower case
				}
			}
			return sum/city.getWindSpeedArrayList().size();		// 'sum/3'
		}
		if(unit.equals("2")) {
			for(int i=0;i<city.getWindSpeedArrayList().size();i++) {	//i<3(year count)
				for(int j=0;j<city.getWindSpeedArrayList().get(i).size();j++) {		//j<12(month count in a year)
					if(monthOfYears.equals(city.getWindSpeedArrayList().get(i).get(j).getMonth().toString())) {	//we search the month we 
						sum+=city.getWindSpeedArrayList().get(i).get(j).getSpeed_MPerS();						//want in enum-month
																												//in all lower case
					}
				}
			}
			return sum/city.getWindSpeedArrayList().size();		// 'sum/3'
		}
		else {
			System.out.println("An error occured while calculating the average, exiting");
			return -1;
		}
	}
	
	public double getAverageHumidityPercantageOverall(City city) {
		double sum = 0.0;
		for(int i=0;i<city.getHumidityArrayList().size();i++) {		//i<3(year count)
			for(int j=0;j<city.getHumidityArrayList().get(i).size();j++) {		//j<12(month count in a year)
				sum+=city.getHumidityArrayList().get(i).get(j).getHumidityPercentage();
			}
		}
		return sum/(city.getHumidityArrayList().size()*city.getHumidityArrayList().get(0).size());		// 'sum/(3*12)'
	}
	
	public int getRadiationIntensityFrequencyOfYear(City city, int year, String intensityValue) {
		int frequency = 0;
			for(int i=0;i<city.getRadiationRadiationAbsorptionArrayList().get(0).size();i++) {		//i<12
				if(intensityValue.equals(city.getRadiationRadiationAbsorptionArrayList().get(year).get(i).getRadiationIntensity().toString())) {
					frequency++;
				}
			}
		return frequency;
	}
	
	public double getFeltTemperatureOfYearOfMonth(City city, int year, int month) {
		return city.getFeltTemperatureArrayList().get(year).get(month).getCelcius();	//feltTemperature is calculated once for one month
	}
}