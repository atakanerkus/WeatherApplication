package business_layer;

import data_layer.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Query {
	FileIO file = new FileIO();
	ClimateRecord record = new ClimateRecord();
	Scanner keyboard = new Scanner(System.in);
	
	ArrayList<City> cityArrayList = record.getCityArrayList();
	ArrayList<Country> countryArrayList = record.getCountryArrayList();
	
	private City selectCity() {
		String cityName;
		City city = null;
		boolean flag = false;
		do {
			flag = false;	//need to initiate flag to false inside 'do' for making more than 1 mistakes situation
			System.out.print("Please enter the name of the city: ");
			cityName = keyboard.next();
			for(int i=0;i<cityArrayList.size();i++) {
				if(cityName.toLowerCase().equals(cityArrayList.get(i).getName().toLowerCase())) {
					city = new City(cityArrayList.get(i));
					flag = true;	//flag is set to true if inputed cityName matches name of the city in our array
					return city;
				}
			}
			if(flag){break;}
			System.out.println("City name is not found!");
			}
		while(!flag);
		return city;
		}
	
	private String selectYear() {
		String yearChoice;
		String year;
		boolean flag = true;
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
			System.out.println("[1]2020 [2]2021 [3]2022");
			System.out.print("Please select a year: ");
			yearChoice = keyboard.next();
			year =
				    switch (yearChoice) {
				        case "1":  yield "2020";
				        case "2":  yield "2021";
				        case "3":  yield "2022";
				        default: System.out.println("Incorrect Year");
				        	flag = false;	//flag is set to false if a mistake is done by user
				        	yield "-1";
				   };
		}
		while(!flag);
		return year;
	}
	
	private String selectMeasurementType() {
		String measurementChoice;
		String measurementType;
		boolean flag=true;
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
		    System.out.println("[1]Celcius [2]Fahrenheit [3]Kelvin");
		    System.out.print("Please select a temperature unit: ");
		    measurementChoice = keyboard.next();
		    measurementType =
		        switch (measurementChoice) {
		            case "1":  yield "Celcius";
		            case "2":  yield "Fahrenheit";
		            case "3":  yield "Kelvin";
		            default: System.out.println("Incorrect Measurement Type");
		            	flag = false;	//flag is set to false if a mistake is done by user
		                yield "";
		        };
		} while(!flag);
		return measurementType;
	}
	
	private String selectMonth() {
		String monthChoice;
		String month;
		boolean flag = true;
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
			System.out.println("[1]January [2]February [3]March [4]April [5]May [6]June");
			System.out.println("[7]July [8]August [9]September [10]October [11]November [12]December");
			System.out.print("Please select a month: ");
			monthChoice = keyboard.next();
			month =			//month is taken from the user with using integer not month name for making more robust code
				    switch (monthChoice) {
				        case "1":  yield "JANUARY";
				        case "2":  yield "FEBRUARY";
				        case "3":  yield "MARCH";
				        case "4":  yield "APRIL";
				        case "5":  yield "MAY";
				        case "6":  yield "JUNE";
				        case "7":  yield "JULY";
				        case "8":  yield "AUGUST";
				        case "9":  yield "SEPTEMBER";
				        case "10":  yield "OCTOBER";
				        case "11":  yield "NOVEMBER";
				        case "12":  yield "DECEMBER";
				        default: System.out.println("Incorrect Month");
				        	flag = false;	//flag is set to false if a mistake is done by user
				        	yield "";
				   };
		}
		while(!flag);
		return month;
	}
	
	public void Query1() {
		String countryName;
		String measurementType;
		String year;
		boolean flag = false;
		Country country = new Country("initialized"); //initialize country outside the loop
		do {
			flag = false;	//need to initiate flag to false inside 'do' for making more than 1 mistakes situation
		    System.out.print("Please enter the name of the country: ");
		    countryName = keyboard.nextLine();
		    for(int i=0;i<countryArrayList.size();i++) {
		        if(countryName.toLowerCase().equals(countryArrayList.get(i).getName().toLowerCase())) {
		            country = new Country(countryArrayList.get(i));
		            flag = true;	//flag set to true if inputed countryName matches the name of a country in our ArrayList
		            break;
		        }
		    }
		    if(flag == true) {break;}	//if wrong country name is inputed
		    System.out.println("Incorrect option input!");
		} while(!flag);
		
		measurementType = selectMeasurementType();
		year = selectYear();
		
		double average = 0.0;
		average = record.getAverageTemperatureOfYear(country, Integer.parseInt(year)-2020, measurementType);
	    System.out.format("Average Temperature of " + countryName + " in "+ measurementType + " in the year "+year + ": "+"%.1f", average);
	    System.out.println("\n****************************************************************************");
	}
	
	public void Query2() {
		String measurementType;
		String year;
		double average = 0.0;
		City city = new City("initialized");	//initialize city outside the loop
		city = selectCity();
		measurementType = selectMeasurementType();
		year = selectYear();
		average = record.getAverageTemperatureOfYear(city, Integer.parseInt(year)-2020, measurementType);
	    System.out.format("Average Temperature of " + city.getName() + " in "+ measurementType + " in the year "+year + ": "+"%.1f", average);
	    System.out.println("\n****************************************************************************");
	}
	
	public void Query3() {
		String measurementType;
		String month;
		String measurementChoice;
		double average = 0.0;
		City city = new City("initialized");	//initialize city outside the loop
		city = selectCity();
		boolean flag=true;
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
		    System.out.println("[1]Km/H [2]m/s");
		    System.out.print("Please select a measurement type for wind speed: ");
		    measurementChoice = keyboard.next();
		    measurementType =
		        switch (measurementChoice) {
		            case "1":  yield "1";
		            case "2":  yield "2";
		            default: System.out.println("Unknown Measurement Type");
		            	flag = false;	//flag is set to false if a mistake is done by user
		                yield "";
		        };
		} while(!flag);
		month = selectMonth();
		average = record.getAverageWindSpeedOfMonth(city, measurementType, month);
		if(measurementType.equals("1"))
			System.out.format("Average Wind Speed of " + city.getName() + " in Km/h in "+month.toLowerCase() + ": "+"%.1f", + average);
		if(measurementType.equals("2"))
			System.out.format("Average Wind Speed of " + city.getName() + " in m/s in "+month.toLowerCase() + ": "+"%.1f", + average);
		System.out.println("\n****************************************************************************");
	}
	
	public void Query4() {
		City city = new City("initialized");	//initialize city outside the loop
		double average = 0.0;
		city = selectCity();
		average = record.getAverageHumidityPercantageOverall(city);
		System.out.format("Average Humidity Percantage in 3 Year Period of "+city.getName()+": " +"%.1f", average);
		System.out.println("\n****************************************************************************");
	}
	
	public void Query5() {
		City city = new City("initialized");	//initialize city outside the loop
		String year;
		String intensity;
		String intensityChoice;
		int frequency = 0;
		boolean flag = true;
		city = selectCity();
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
			System.out.println("[1]Low [2]Medium [3]High");
			System.out.print("Please select an intensity level: ");
			intensityChoice = keyboard.next();
			intensity =
				    switch (intensityChoice) {
				        case "1":  yield "LOW";
				        case "2":  yield "MEDIUM";
				        case "3":  yield "HIGH";
				        default: System.out.println("Incorrect Intensity");
				        	flag = false;	//flag is set to false if a mistake is done by user
				        	yield "";
				   };
		}
		while(!flag);
		year = selectYear();
		frequency = record.getRadiationIntensityFrequencyOfYear(city, Integer.parseInt(year)-2020, intensity);
		System.out.println("Total count of "+intensity+" radiation intensity in "+ city.getName()+" in "+year+": "+frequency);
		System.out.println("****************************************************************************");
	}
	
	public void Query6() {
		City city = new City("initialized");	//initialize city outside the loop
		city = selectCity();
		String year = selectYear();
		String monthChoice;
		String month;
		boolean flag = true;
		do {
			flag = true;	//need to initiate flag to true inside 'do' for making more than 1 mistakes situation
			System.out.println("[1]January [2]February [3]March [4]April [5]May [6]June");
			System.out.println("[7]July [8]August [9]September [10]October [11]November [12]December");
			System.out.print("Please select a month: ");
			monthChoice = keyboard.next();
			month =
				    switch (monthChoice) {
				        case "1":  yield "JANUARY";
				        case "2":  yield "FEBRUARY";
				        case "3":  yield "MARCH";
				        case "4":  yield "APRIL";
				        case "5":  yield "MAY";
				        case "6":  yield "JUNE";
				        case "7":  yield "JULY";
				        case "8":  yield "AUGUST";
				        case "9":  yield "SEPTEMBER";
				        case "10":  yield "OCTOBER";
				        case "11":  yield "NOVEMBER";
				        case "12":  yield "DECEMBER";
				        default: System.out.println("Incorrect Month");
				        	flag = false;	//flag is set to false if a mistake is done by user
				        	yield "";
				   };
		}
		while(!flag);
		double feltTemperature = record.getFeltTemperatureOfYearOfMonth(city, Integer.parseInt(year)-2020, Integer.parseInt(monthChoice)-1);
		System.out.format("Felt Temperature of " + city.toString() + " in celcius in the year "+year + " in "+ month.toLowerCase()+": "+"%.1f", feltTemperature);
		System.out.println("\n****************************************************************************");
	}
}
