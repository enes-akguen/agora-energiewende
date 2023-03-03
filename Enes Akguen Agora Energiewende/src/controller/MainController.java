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
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Api api = new Api();
		
		Parser parser = new Parser(api.getJson());
		ArrayList<AbstractData> abstractData = parser.parseEnergyData();
		
		Database database = new Database();
		
		for (AbstractData data : abstractData) { 
			if(data instanceof EnergySource) {
				database.persistEnergySource(data);	
			} else {
//				System.out.println(data.getAbsoluteEmissions());
//				System.out.println(data.getEmissionFactor());
				//System.out.println(data.getDate());
//				if (data.getDate() == null) {
//					System.out.println("ok");
//					System.out.println(data.getAbsoluteEmissions());
//					System.out.println(data.getEmissionFactor());
//				}
//				if (data.getEmissionFactor() != null) {
//					System.out.println("ok");
//					System.out.println(data.getAbsoluteEmissions());
//					System.out.println(data.getEmissionFactor());
//				}
				database.persistEmissionFactor(data);
			}
		}  
	}
}
