package data_layer;

public class RadiationAbsorption extends Measurement{
	private Double unitAbsorptionValue;
	
    public RadiationAbsorption(int year, int month,Double unitAbsorptionValue) {
		super(year, month);
		this.unitAbsorptionValue = unitAbsorptionValue;
		this.intensityNumber = setIntensityNumber();		//methods to initialize intensity of the radiation
		this.intensity = getIntensityByNumber(intensityNumber);
	}
    
	public enum RadiationIntensity{
        LOW(1), MEDIUM(2), HIGH(3);
		private final int intensityNumber;			//radiation intensity can be choosen with using number
		RadiationIntensity(int intensityNumber) {	
		        this.intensityNumber = intensityNumber;
		    }
		    
		    public int getIntensityNumber() {
		        return intensityNumber;
		    }
    }
	
	private RadiationIntensity intensity;
	private int intensityNumber;
	
	public static RadiationIntensity getIntensityByNumber(int intensityNumber) {
        for (RadiationIntensity intensity : RadiationIntensity.values()) {
            if (intensity.getIntensityNumber() == intensityNumber) {
                return intensity;
            }
        }
        throw new IllegalArgumentException("Invalid intensity number: " + intensityNumber);
    }
	
	private int setIntensityNumber() {				//number is calculated from unitAbosptioValue
		if(unitAbsorptionValue < 10.0) {			//and number is used to set intensity which is an enum
			return 1;
		}
		else if(unitAbsorptionValue< 15.0) {
			return 2;
		}
		else
			return 3;
	}
	
	public RadiationAbsorption(RadiationAbsorption otherRadiation){
    	super(otherRadiation);		//sets month and year of copied object to our original object's.
    	this.unitAbsorptionValue = otherRadiation.unitAbsorptionValue;
    	this.intensity = otherRadiation.intensity;
	}
	
	public Double getUnitAbsorptionValue() {
		return unitAbsorptionValue;
	}
	
	public RadiationIntensity getRadiationIntensity() {
		return intensity;
	}
}