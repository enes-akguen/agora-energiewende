package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Utilities;

public class Parser {
	public static String parseEnergyData(String jsonString, String startIndex)
	{
		String wasserKraftData = jsonString.substring(jsonString.indexOf(startIndex));
		List<String> wasserKraftParsedDatasets = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\[[^\\[]\\S*?(?=\\]\\})", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(wasserKraftData);
	    
	    if (matcher.find()) {
	    	String wasserKraftDatasets = matcher.group(0);
	    	for (String Dataset : wasserKraftDatasets.split("\\],\\[")) {
	    		for (String DatasetPart : Dataset.split(",")) {
		    		wasserKraftParsedDatasets.add(DatasetPart.replaceAll("[\\[\\]]", ""));
			    }
		    }
		}
	    
	    System.out.print("Wasserkraft Daten:\n");
	    for (int i = 0; i < wasserKraftParsedDatasets.size(); i++) {
	    	if (i % 2 == 0)
	    	{
	    		System.out.printf("Datum %s ", Utilities.convertTimestamp(wasserKraftParsedDatasets.get(i)));
	    	} 
	    	else 
	    	{
	    		System.out.printf("Wert %s GW",wasserKraftParsedDatasets.get(i));
	    	}
	    	
	    	System.out.print("\n");        
	    }
	    
	    // TODO ... other energy sources
	    // TODO prepare to persist in database
		
		return "";
	}
}
