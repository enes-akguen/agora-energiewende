package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Enes Akgün
 */
public class Api {
	
	private URL url;
	
	/**
	 * @Todo Make user choose date range
	 */
	public Api() 
	{
		try {
			this.url = new URL("https://www.agora-energiewende.de/service/agorameter/chart/data/power_generation/21.11.2022/24.11.2022/today/chart.json");
		} catch (MalformedURLException e) {
			System.out.print("Invalid URL");
		}
	}
	
	public String getJson() 
	{
		try (InputStream input = this.url.openStream()) {
	        InputStreamReader isr = new InputStreamReader(input);
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder json = new StringBuilder();
	        int c;
	        while ((c = reader.read()) != -1) {
	            json.append((char) c);
	        }
	        return json.toString();
	    } catch (IOException e) {
	    	System.out.print("No data received");
			e.printStackTrace();
		}
		return null;
	}
}
