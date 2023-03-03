package controller;

import java.util.ArrayList;

import db.Database;
import dto.AbstractData;
import dto.EnergySource;
import gui.Gui;
import service.Api;
import service.Parser;

/**
 * @author Enes Akg�n
 */
public class Controller {
	/**
	 * @param args, default
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		Gui gui = new Gui(controller); 
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @throws ClassNotFoundException
	 */
	public void persist(String startDate, String endDate) throws ClassNotFoundException
	{
		Api api = new Api(startDate,endDate);
		
		Parser parser = new Parser(api.getJson());
		ArrayList<AbstractData> abstractData = parser.parseEnergyData();
		
		Database database = new Database();
		
		for (AbstractData data : abstractData) { 
			if(data instanceof EnergySource) {
				database.persistEnergySource(data);	
			} else {
				database.persistEmissionFactor(data);
			}
		} 
	}
}
