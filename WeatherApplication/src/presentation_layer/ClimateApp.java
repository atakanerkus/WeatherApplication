package presentation_layer;

import business_layer.*;

import java.util.Scanner;

public class ClimateApp {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		String choice="";	//choice is initialized
		while(choice != "7") {	//7 to end the program
			Menu.getMenu();		//menu to inform the user
			choice = Menu.getChoice();	//user's choice is stored 
			Menu.getQuery(choice);		//to invoke needed query method
		}
	}
	
	public class Menu {
		public static void getMenu() {
			System.out.println("[1] Calculate average temperature for a country according to temperature unit and year. ");
			System.out.println("[2] Calculate average temperature for a city according to temperature unit and year. ");
			System.out.println("[3] Calculate average wind speed for a city according to speed unit and year. ");
			System.out.println("[4] Calculate average humidity of a city for every year. ");
			System.out.println("[5] Count how many times a year a specific radiation intensity value appears for a city. ");
			System.out.println("[6] Calculate the \"felt temperature\" value of a city for a specific month and year. ");
			System.out.println("[7] Exit the application. ");
			System.out.print("Please select an option: ");
		}
		public static String getChoice() {
			String choice;
			boolean flag = true;
			do {
				flag = true;		//flag is set to true for user making more than 1 mistakes
				choice = keyboard.next();
				choice =
				    switch (choice) {
				        case "1":  yield "1";
				        case "2":  yield "2";
				        case "3":  yield "3";
				        case "4":  yield "4";
				        case "5":  yield "5";
				        case "6":  yield "6";
				        case "7":  yield "7";
				        default: {
				        	System.out.print("Incorrect option input! Please reenter another option input: ");
				        	flag = false;	//flag is set to false if user made a mistake
				        	yield "";
				        }
				   };
			}
		while(!flag);
		return choice;
		}
		public static void getQuery(String choice) {
			Query query = new Query();
			switch(choice) {
				case "1": query.Query1();
				break;
				case "2": query.Query2();
				break;
				case "3": query.Query3();
				break;
				case "4": query.Query4();
				break;
				case "5": query.Query5();
				break;
				case "6": query.Query6();
				break;
				case "7":System.out.println("Closing the application…");
				break;
				default:
					System.out.println("This shouldn't happen -.-");//really shouldn't happen
			}
		}
	}
}
