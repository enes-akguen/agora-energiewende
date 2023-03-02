package controller;

import java.util.ArrayList;

import db.Database;
import dto.AbstractData;
import dto.EnergySource;
import service.Api;
import service.Parser;

/**
 * @author Enes Akg�n
 */
public class MainController {
	/**
	 * @param args, default
	 */
	public static void main(String[] args) {
		Api api = new Api();
		
		Parser parser = new Parser(api.getJson());
		ArrayList<AbstractData> abstractData = parser.parseEnergyData();
		
		for (AbstractData data : abstractData) { 
			if(data instanceof EnergySource) {
				System.out.println(data.getName()); 	
			}
	      }  
	}
}
