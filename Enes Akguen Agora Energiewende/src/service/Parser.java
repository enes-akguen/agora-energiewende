package service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.AbsoluteEmission;
import dto.AbstractData;
import dto.EmissionFactor;
import dto.EnergySource;
import utils.Utilities;

public class Parser {
	
	/**
	 * Array containing the start index of energy sources for the regex pattern
	 * based on the API data structure
	 */
	private final String[][] energySourcesIndex = {
			// Konv. Kraftwerke
			{"Konv. Kraftwerke","\\\"name\\\":\\\"Konv. Kraftwerke\\\""},
			// Wasserkraft
			{"Wasserkraft","\\\"name\\\":\\\"Wasserkraft\\\""},
			// Braunkohle
			{"Braunkohle","\\\"name\\\":\\\"Braunkohle\\\""},
			// Andere
			{"Andere","\\\"name\\\":\\\"Andere\\\""},
			// Solar
			{"Solar","\\\"name\\\":\\\"Solar\\\""},
			// Biomasse
			{"Biomasse","\\\"name\\\":\\\"Biomasse\\\""},
			// Kernenergie
			{"Kernenergie","\\\"name\\\":\\\"Kernenergie\\\""},
			// CO2-Emissionsfaktor des Strommix
			{"CO2-Emissionsfaktor des Strommix","\\\"name\\\":\\\"CO<sub>2<\\\\\\/sub>-Emissionsfaktor des Strommix\\"},
			// Emissionen der Stromerzeugung
			{"Emissionen der Stromerzeugung","\\\"name\\\":\\\"Emissionen der Stromerzeugung\\\""},
			// Wind Onshore
			{"Wind Onshore","\\\"name\\\":\\\"Wind Onshore\\\""},
			// Stromverbrauch
			{"Stromverbrauch","\\\"name\\\":\\\"Stromverbrauch\\\""},
			// Pumpspeicher
			{"Pumpspeicher","\\\"name\\\":\\\"Pumpspeicher\\\""},
			// Wind Offshore
			{"Wind Offshore","\\\"name\\\":\\\"Wind Offshore\\\""},
			// Steinkohle
			{"Steinkohle","\\\"name\\\":\\\"Steinkohle\\\""},
			// Erdgas
			{"Erdgas","\\\"name\\\":\\\"Erdgas\\\""}
	};
	
	private String jsonString;
	
	private ArrayList<AbstractData> abstractData = new ArrayList<AbstractData>();
	
	private EmissionFactor emissionFactor;
	
	private AbsoluteEmission absoluteEmission;
	
	private EnergySource parsedData;
	
	public Parser(String jsonString)
	{
		this.jsonString = jsonString;
	}
	
	public ArrayList<AbstractData> parseEnergyData()
	{
		for (int i = 0; i < energySourcesIndex.length; i++) {
		  parse(energySourcesIndex[i][0], energySourcesIndex[i][1]);
		}
		this.abstractData.add(emissionFactor);
		return this.abstractData;
	}
	
	
	private void parse(String energySourceName, String energySourceIndex)
	{
		String data = this.jsonString.substring(this.jsonString.indexOf(energySourceIndex));
		List<String> parsedDatasets = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\[[^\\[]\\S*?(?=\\]\\})", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(data);
	    
	    if (matcher.find()) {
	    	String wasserKraftDatasets = matcher.group(0);
	    	for (String Dataset : wasserKraftDatasets.split("\\],\\[")) {
	    		for (String DatasetPart : Dataset.split(",")) {
		    		parsedDatasets.add(DatasetPart.replaceAll("[\\[\\]]", ""));
			    }
		    }
		}

	    for (int i = 0; i < parsedDatasets.size(); i++) {
	    	if (!(this.parsedData instanceof EnergySource)) {
	    		this.parsedData = new EnergySource();
	    		this.parsedData.setName(energySourceName);
	    	} 
	    	if (!(this.emissionFactor instanceof EmissionFactor)) {
	    		this.emissionFactor = new EmissionFactor();
	    	}
	    	if (!(this.absoluteEmission instanceof AbsoluteEmission)) {
	    		this.absoluteEmission = new AbsoluteEmission();
	    	} 
	    	if (i % 2 == 0)
	    	{
	    		if (!energySourceName.equals("CO2-Emissionsfaktor des Strommix") &&
    				!energySourceName.equals("Emissionen der Stromerzeugung"))
	    		{
	    			this.parsedData.setDate(Utilities.convertTimestamp(parsedDatasets.get(i)));
	    			
	    		} else 
	    		{
	    			this.emissionFactor.setDate(Utilities.convertTimestamp(parsedDatasets.get(i)));
	    			this.absoluteEmission.setDate(Utilities.convertTimestamp(parsedDatasets.get(i)));
	    		}
	    	} 
	    	else 
	    	{
	    	    DecimalFormat df = new DecimalFormat("#,###");
	    	    df.setRoundingMode(RoundingMode.CEILING);
	    	    df.format(Math.round(Float.parseFloat(parsedDatasets.get(i))));
			    if (energySourceName.equals("CO2-Emissionsfaktor des Strommix"))
	 		    {
		    		this.emissionFactor.setEmissionFactor(df.format(Math.round(Float.parseFloat(parsedDatasets.get(i)))) + " g/kWh");
		    		this.abstractData.add(emissionFactor);
		    		this.emissionFactor = null;
	 		    } else if (energySourceName.equals("Emissionen der Stromerzeugung")) {
 		    		this.absoluteEmission.setAbsoluteEmissions(df.format(Math.round(Float.parseFloat(parsedDatasets.get(i)))) + " t");
 		    		this.abstractData.add(absoluteEmission);
		    		this.absoluteEmission = null;
	    	    }
	 		    else {
	 		    	this.parsedData.setEnergy(df.format(Math.round(Float.parseFloat(parsedDatasets.get(i)))) + " GW");
	 		    	this.abstractData.add(parsedData);
	 		    	this.parsedData = null;
	 		    }
	    	}
	    }
	}
}
