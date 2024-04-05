package data_layer;

public abstract class Measurement {
	
	public enum Months {		//months is an enum type object that has its own methods
	    JANUARY(1),FEBRUARY(2),MARCH(3),APRIL(4),MAY(5),JUNE(6),JULY(7),AUGUST(8),SEPTEMBER(9),OCTOBER(10),NOVEMBER(11),DECEMBER(12);
		
	    private final int monthNumber;	//we made it so month can be choosen with using number
	    
	    Months(int monthNumber) {
	        this.monthNumber = monthNumber;
	    }
	    public int getMonthNumber() {
	        return monthNumber;
	    }
	}
	
	Months month;
	int year;
	
	public static Months getMonthByNumber(int monthNumber) {	//with order number of the month is given as argument
        for (Months month : Months.values()) {					//measurement's month attribute is choosen from the enum
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + monthNumber);
    }

	Measurement(int year, int month){		//we create measurement with int argument order number of the month
		this.year = year;
		this.month = getMonthByNumber(month);		//measurement's month attribute is choosen from the enum
	}
	
	Measurement(Measurement measurement){	// we made copy constructor to not make shallow copy
		this.year = measurement.year;
		this.month = measurement.month;
	}
	
	public Months getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	@Override
	public String toString() {
		return ("in the year " + year + " in " + month.toString());
	}
}