package dto;

public abstract class AbstractData {
	protected String date;
	
	abstract public String getName();
	abstract public String getDate();
	abstract public String getEnergy();
	abstract public String getEmissionFactor();
	abstract public String getAbsoluteEmissions();
}
