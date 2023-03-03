package dto;

public class EmissionFactor extends AbstractData {
	private String emissionFactor = "";
	private String absoluteEmissions = "";
	
	public EmissionFactor()
	{
		
	}
	
	public String getName()
	{
		return "CO2-Emissionsfaktor des Strommix";
	}
	
	public void setDate (String date)
	{
		this.date = date;
	}
	
	public String getDate ()
	{
		return this.date;
	}
	
	@Override
	public void setEmissionFactor (String emissionFactor)
	{
		this.emissionFactor = emissionFactor;
	}
	
	@Override
	public String getEmissionFactor ()
	{
		return this.emissionFactor;
	}
	
	@Override
	public void setAbsoluteEmissions (String absoluteEmissions)
	{
		this.absoluteEmissions = absoluteEmissions;
	}
	
	@Override
	public String getAbsoluteEmissions ()
	{
		return this.absoluteEmissions;
	}

	@Override
	public String getEnergy() {
		return "";
	}
}
