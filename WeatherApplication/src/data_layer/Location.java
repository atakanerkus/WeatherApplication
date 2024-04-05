package data_layer;

import java.util.ArrayList;

public abstract class Location {
	
	protected String name;
	protected ArrayList<ArrayList<Temperature>> temperatureArrayList = new ArrayList<ArrayList<Temperature>>();//3(year)*12(months in a year)
	//temperature data stored inside location class with a 2d ArrayList
	public Location(String name){
		this.name = name;
		setTemperatureArrayList();	//temperature data is taken from the temperature object and stored in a 2d ArrayList
	}
	
	Location(Location location){
		this.name = location.name;
		this.temperatureArrayList = location.temperatureArrayList;
		
	}
	
	private void setTemperatureArrayList() {
		for (int i = 0; i<3; i++) {
			ArrayList<Temperature> oneYearTemperatureArray = new ArrayList<Temperature>();
			for (int j= 0; j<12; j++) {									//Years start at 2020
				Temperature temperature = new Temperature(i+2020, j+1); //enum Months start at 1 --> j+1
				oneYearTemperatureArray.add(temperature);
			}
			temperatureArrayList.add(oneYearTemperatureArray);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<ArrayList<Temperature>> getTemperatureArrayList() {
		ArrayList<ArrayList<Temperature>> temp2D_ArrayList = new ArrayList<ArrayList<Temperature>>();
		for (ArrayList<Temperature> tempTemperatureArrayList : temperatureArrayList){	
			ArrayList<Temperature> tempArrayList = new ArrayList<Temperature>();
			for(Temperature temperatures : tempTemperatureArrayList) {
				Temperature temp = new Temperature(temperatures);
				tempArrayList.add(temp);
			}
			temp2D_ArrayList.add(tempArrayList);
		}
		return temp2D_ArrayList;	//temperatureArray is copied to a another array to deep copy
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}