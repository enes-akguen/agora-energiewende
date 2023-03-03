package dto;

public class EnergySource extends AbstractData {
	private String name = "";
	private String energy = "";
	
	public EnergySource()
	{
	}
	
	public void setDate (String date)
	{
		this.date = date;
	}
	
	@Override
	public String getDate ()
	{
		return this.date;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	@Override
	public String getName ()
	{
		return this.name;
	}
	
	public void setEnergy (String energy)
	{
		this.energy = energy;
	}
	
	@Override
	public String getEnergy ()
	{
		return this.energy;
	}

	@Override
	public String getEmissionFactor() {
		return "";
	}

	@Override
	public String getAbsoluteEmissions() {
		return "";
	}

	@Override
	public void setEmissionFactor(String emissionFactor) {
		return;
		
	}

	@Override
	public void setAbsoluteEmissions(String absoluteEmissions) {
		return;
		
	}
}
