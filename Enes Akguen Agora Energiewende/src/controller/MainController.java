package controller;

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
		Parser.parseEnergyData(api.getJson());
	}
}
