package data_layer;

import java.util.ArrayList;
import java.util.Random;

public class City extends Location{
	
	private ArrayList<ArrayList<Temperature>> feltTemperatureArrayList = new ArrayList<ArrayList<Temperature>>();	
	protected ArrayList<ArrayList<WindSpeed>> windSpeedArrayList = new ArrayList<ArrayList<WindSpeed>>();
	protected ArrayList<ArrayList<Humidity>> humidityArrayList = new ArrayList<ArrayList<Humidity>>();
	protected ArrayList<ArrayList<RadiationAbsorption>> radiationAbsorptionArrayList = new ArrayList<ArrayList<RadiationAbsorption>>();
	//mesaurements are stored in a 2d ArrayLists
	public City(String cityName){
		super(cityName);
		setWindSpeedArrayList();		//measurement datas are taken from their objects and put in a 2d ArrayLists
		setHumidityArrayList();
		setRadiationAbsorptionArrayList();
		calcFeltTemperatureArrayList();
	}
	
	public City(City city){
		super(city);
		this.windSpeedArrayList = city.windSpeedArrayList;		//copy constructor to make deep copy
		this.humidityArrayList = city.humidityArrayList;
		this.radiationAbsorptionArrayList = city.radiationAbsorptionArrayList;
		this.feltTemperatureArrayList = city.getFeltTemperatureArrayList();
	}	
	
	private void calcFeltTemperatureArrayList() {
		ArrayList<ArrayList<Temperature>> temperatureList = getTemperatureArrayList();
		ArrayList<ArrayList<WindSpeed>> windSpeedList = getWindSpeedArrayList();
		ArrayList<ArrayList<Humidity>> humidityList = getHumidityArrayList();
		ArrayList<ArrayList<RadiationAbsorption>> radiationList = getRadiationRadiationAbsorptionArrayList();
		for(int i=0;i<temperatureList.size();i++) {
			ArrayList<Temperature> oneYearFeltTemperatureList = new ArrayList<Temperature>();
			for(int j=0;j<temperatureList.get(i).size();j++) {		//needed datas are taken from measurements and calculated feltTemperature
				Temperature temperature = temperatureList.get(i).get(j);
				WindSpeed windSpeed = windSpeedList.get(i).get(j);
				Humidity humidity = humidityList.get(i).get(j);
				RadiationAbsorption radiation = radiationList.get(i).get(j);
				Temperature feltTemperature = new Temperature(i,j+1);		//enum Months start at 1 --> j+1
				double feltCelcius = temperature.getCelcius() + (0.3*humidity.getHumidityPercentage())
						- 0.7*(radiation.getUnitAbsorptionValue()/(windSpeed.getSpeed_MPerS()+10));
				feltTemperature.setInCelcius(feltCelcius);
				oneYearFeltTemperatureList.add(feltTemperature);
			}
			feltTemperatureArrayList.add(oneYearFeltTemperatureList);	//calculatedFeltTemperature data is stored inside a 2d ArrayList
		}
	}
	
	public ArrayList<ArrayList<Temperature>> getFeltTemperatureArrayList() {
		ArrayList<ArrayList<Temperature>> temp2D_ArrayList = new ArrayList<ArrayList<Temperature>>();
		for (ArrayList<Temperature> tempTemperatureArrayList : feltTemperatureArrayList){
			ArrayList<Temperature> tempArrayList = new ArrayList<Temperature>();
			for(Temperature temperatures : tempTemperatureArrayList) {
				Temperature temp = new Temperature(temperatures);
				tempArrayList.add(temp);
			}
			temp2D_ArrayList.add(tempArrayList);
		}
		return temp2D_ArrayList;		//ArrayList copied to make deep copy
	}
	
	private void setWindSpeedArrayList() {
		Random rand = new Random();
		for (int i = 0; i<3; i++) {
			ArrayList<WindSpeed> oneYearWindSpeedArray = new ArrayList<WindSpeed>();
			for (int j= 0; j<12; j++) {
				double speed = rand.nextDouble(0, 113.2);
				WindSpeed windSpeed = new WindSpeed(i+2020, j+1, speed);		//enum Months start at 1 --> j+1
				oneYearWindSpeedArray.add(windSpeed);
			}
			windSpeedArrayList.add(oneYearWindSpeedArray);
		}
	}
	
	private void setHumidityArrayList() {
		Random rand = new Random();
		for (int i = 0; i<3; i++) {
			ArrayList<Humidity> oneYearHumidityArray = new ArrayList<Humidity>();
			for (int j= 0; j<12; j++) {
				double humidityPercentage = rand.nextDouble(0, 100);
				Humidity humidity = new Humidity(i+2020, j+1, humidityPercentage);	//enum Months start at 1 --> j+1
				oneYearHumidityArray.add(humidity);
			}
			humidityArrayList.add(oneYearHumidityArray);
		}
	}
	
	private void setRadiationAbsorptionArrayList() {
		Random rand = new Random();
		for (int i = 0; i<3; i++) {
			ArrayList<RadiationAbsorption> oneYearRadiationAbsorptionArray = new ArrayList<RadiationAbsorption>();
			for (int j= 0; j<12; j++) {
				double unitAbsorbtionValue = rand.nextDouble(5, 20);
				RadiationAbsorption radiation = new RadiationAbsorption(i+2020, j+1, unitAbsorbtionValue);	//enum Months start at 1 --> j+1
				oneYearRadiationAbsorptionArray.add(radiation);
			}
			radiationAbsorptionArrayList.add(oneYearRadiationAbsorptionArray);
		}
	}
	
	public ArrayList<ArrayList<WindSpeed>> getWindSpeedArrayList() {
		ArrayList<ArrayList<WindSpeed>> temp2D_ArrayList = new ArrayList<ArrayList<WindSpeed>>();
		for (ArrayList<WindSpeed> tempWindSpeedArrayList : windSpeedArrayList){	
			ArrayList<WindSpeed> tempArrayList = new ArrayList<WindSpeed>();
			for(WindSpeed windSpeed : tempWindSpeedArrayList) {
				WindSpeed temp = new WindSpeed(windSpeed);
				tempArrayList.add(temp);
			}
			temp2D_ArrayList.add(tempArrayList);
		}
		return temp2D_ArrayList;		//ArrayList copied to make deep copy
	}

	public ArrayList<ArrayList<Humidity>> getHumidityArrayList() {
		ArrayList<ArrayList<Humidity>> temp2D_ArrayList = new ArrayList<ArrayList<Humidity>>();
		for (ArrayList<Humidity> tempHumidityArrayList : humidityArrayList){
			ArrayList<Humidity> tempArrayList = new ArrayList<Humidity>();
			for(Humidity humidity : tempHumidityArrayList) {
				Humidity temp = new Humidity(humidity);
				tempArrayList.add(temp);
			}
			temp2D_ArrayList.add(tempArrayList);
		}
		return temp2D_ArrayList;		//ArrayList copied to make deep copy
	}

	public ArrayList<ArrayList<RadiationAbsorption>> getRadiationRadiationAbsorptionArrayList() {
		ArrayList<ArrayList<RadiationAbsorption>> temp2D_ArrayList = new ArrayList<ArrayList<RadiationAbsorption>>();
		for (ArrayList<RadiationAbsorption> tempRadiationAbsorptionArrayList : radiationAbsorptionArrayList){
			ArrayList<RadiationAbsorption> tempArrayList = new ArrayList<RadiationAbsorption>();
			for(RadiationAbsorption radiation : tempRadiationAbsorptionArrayList) {
				RadiationAbsorption temp = new RadiationAbsorption(radiation);
				tempArrayList.add(temp);
			}
			temp2D_ArrayList.add(tempArrayList);
		}
		return temp2D_ArrayList;		//ArrayList copied to make deep copy
	}
}
