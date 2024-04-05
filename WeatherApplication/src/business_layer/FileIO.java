package business_layer;

import data_layer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	private String line = "";
	private String splitBy = ", "; //in file strings are separated by ', '
	public static final int CITY_COUNT = 15;
	public static final int COUNTRY_COUNT = 5;
	private String[] cityNameArray = new String[CITY_COUNT];
	private String[] countryNameArray = new String[COUNTRY_COUNT];
	private ArrayList<Country> countryArrayList = new ArrayList<Country>();
	private ArrayList<City> cityArrayList = new ArrayList<City>();
	
	public FileIO() {
		readLocations();
		initializeLocationArrayLists();		//locations are set as locations objects which names' are read from readMethod
	}
	
	private void readLocations() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("countries_and_cities.csv"));
			int countryIndex = 0;
			int cityIndex = 0;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split(splitBy);
				countryNameArray[countryIndex] = temp[0];
				for(int i=1;i<temp.length;i++) {	//starts at 1 because 0th index is not a city
					cityNameArray[cityIndex] = temp[i];
					cityIndex++;
				}
				countryIndex++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//country and city objects are constructed here with only using locations' name
	private void initializeLocationArrayLists() {
		for(int i=0;i<countryNameArray.length;i++) {
			Country newCountry = new Country(countryNameArray[i]);
			countryArrayList.add(newCountry);
		}
		for(int i=0;i<cityNameArray.length;i++) {
			 City newCity = new City(cityNameArray[i]);
			 cityArrayList.add(newCity);
		}
	}	
	
	//getters copy array to make deep copy
	public ArrayList<Country> getCountryArrayList() {
		ArrayList<Country> tempList = new ArrayList<Country>();
		for(int i=0;i<countryArrayList.size();i++) {
			Country newCountry = new Country(countryArrayList.get(i));
			tempList.add(newCountry);
		}
		return tempList;
	}
	
	public ArrayList<City> getCityArrayList() {
		ArrayList<City> tempList = new ArrayList<City>();
		for(int i=0;i<cityArrayList.size();i++) {
			City newCity = new City(cityArrayList.get(i));
			tempList.add(newCity);
		}
		return tempList;
	}
}