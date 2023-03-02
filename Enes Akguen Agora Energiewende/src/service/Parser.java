package service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Utilities;

public class Parser {
	public static String parseEnergyData(String jsonString, String energySourceIndex)
	{
		String data = jsonString.substring(jsonString.indexOf(energySourceIndex));
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
	    
	    System.out.print("Wasserkraft Daten:\n");
	    for (int i = 0; i < parsedDatasets.size(); i++) {
	    	if (i % 2 == 0)
	    	{
	    		System.out.printf("Datum %s ", Utilities.convertTimestamp(parsedDatasets.get(i)));
	    	} 
	    	else 
	    	{
	    		DecimalFormat df = new DecimalFormat("#,###");
	    		df.setRoundingMode(RoundingMode.CEILING);
	    		df.format(Math.round(Float.parseFloat(parsedDatasets.get(i))));
	    		System.out.printf("Wert %s GW",df.format(Math.round(Float.parseFloat(parsedDatasets.get(i)))));
	    	}
	    	
	    	System.out.print("\n");        
	    }
	    
	    // TODO ... other energy sources
	    // TODO prepare to persist in database
		
		return "";
	}
}
