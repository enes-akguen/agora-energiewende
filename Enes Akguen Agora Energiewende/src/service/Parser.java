package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.Utilities;

public class Parser {
	public static String parseEnergyData(String jsonString)
	{
		String wasserKraftData = jsonString.substring(jsonString.indexOf("\\\"Wasserkraft\\\",\\\"legendIndex\\\":40,\\\"index\\\":80,\\\"type\\\":\\\"area\\\",\\\"color\\\":\\\"rgb(121,168,202)\\\",\\\"yAxis\\\":0,\\\"data\\\":")+119, 
				jsonString.indexOf("]},{\\\"id\\\":\\\"biomass\\"));
		// System.out.print(data);
		
		List<String> wasserKraftDatasets = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\[[\\d,\\.]*\\]", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(wasserKraftData);
	    
	    while (matcher.find()) {
	    	wasserKraftDatasets.add(matcher.group());
    	 }
	    
	    List<String[]> wasserKraftParsedDatasets = new ArrayList<String[]>();
	    for (String element : wasserKraftDatasets) {
	    	wasserKraftParsedDatasets.add(element.split(","));
	    }
	    
	    System.out.print("Wasserkraft Daten:\n");
	    for (String[] element : wasserKraftParsedDatasets) {
	    	//System.out.print("Datum:");
	        System.out.printf("Datum %s ", Utilities.convertTimestamp(element[0].replace("[", "")));
	        System.out.printf("Wert %s GW",element[1].replace("]", ""));
	        System.out.print("\n");
	    }
	    
	    // TODO ... other energy sources
	    // TODO prepare to persist in database
		
		return "";
	}
}
