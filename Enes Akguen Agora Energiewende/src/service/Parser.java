package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Utilities;

public class Parser {
	public static String parseEnergyData(String jsonString, String index)
	{
		String data = jsonString.substring(jsonString.indexOf(index));
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
	    		System.out.printf("Wert %s GW",parsedDatasets.get(i));
	    	}
	    	
	    	System.out.print("\n");        
	    }
	    
	    // TODO ... other energy sources
	    // TODO prepare to persist in database
		
		return "";
	}
}
