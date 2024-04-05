package data_layer;

public class WindSpeed extends Measurement{
		private double speed_MPerS;
		private double speed_KmPerH;
		
	public WindSpeed(int year, int month, double speed) {
		super(year, month);
		this.speed_MPerS = speed;
		this.speed_KmPerH = getSpeed_MPerS()*18/5;
	}
	
	public WindSpeed(WindSpeed otherWindSpeed){
    	super(otherWindSpeed);		//sets month and year of copied object to our original object's.
    	this.speed_MPerS = otherWindSpeed.speed_MPerS;
    	this.speed_KmPerH = otherWindSpeed.speed_KmPerH;
	}

	public double getSpeed_MPerS() {
		return speed_MPerS;
	}

	public double getSpeed_KmPerH() {
		return speed_KmPerH;
	}
	
	 

}
