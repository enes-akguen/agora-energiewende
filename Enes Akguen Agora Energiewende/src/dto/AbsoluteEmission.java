package dto;

public class AbsoluteEmission extends AbstractData {
	private String emissionFactor = "";
	private String absoluteEmissions = "";
	
	public AbsoluteEmission()
	{
		
	}
	
	public void setDate (String date)
	{
		this.date = date;
	}
	
	@Override
	public String getDate() {
		return this.date;
	}

	@Override
	public String getName() {
		return "Absolute Emissionen";
	}

	@Override
	public String getEnergy() {
		return "";
	}

	@Override
	public String getEmissionFactor() {
		return this.emissionFactor;
	}

	@Override
	public void setEmissionFactor(String emissionFactor) {
		return;
		
	}

	@Override
	public String getAbsoluteEmissions() {
		return this.absoluteEmissions;
	}

	@Override
	public void setAbsoluteEmissions(String absoluteEmissions) {
		this.absoluteEmissions = absoluteEmissions;
		
	}

}
