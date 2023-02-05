package controller;

import service.Api;
import service.Parser;

/**
 * @author Enes Akgün
 */
public class MainController {
	/**
	 * @param args, default
	 */
	public static void main(String[] args) {
		Api api = new Api();
		
		
		/**
		 * Array containing the start and end range of energy sources for regex pattern
		 * based on API data structure
		 */
		final String[][] energySourcesRange = {
//				// Konv. Kraftwerke
//				{"\\\"name\\\":\\\"Konv. Kraftwerke\\\""
//						,"]},{\\\"id\\\":\\\"emission-co2\\"},
				// Wasserkraft
				{"\\\"name\\\":\\\"Wasserkraft\\\""}
//				// Braunkohle
//				{"\\\"name\\\":\\\"Braunkohle\\\""
//					,"]},{\\\"id\\\":\\\"uranium\\\""},
//				// Andere
//				{"\\\"name\\\":\\\"Andere\\\""
//					,"]},{\\\"id\\\":\\\"total-load\\\""},
//				// Solar
//				{"\\\"name\\\":\\\"Solar\\\""
//					,"]},{\\\"id\\\":\\\"wind-onshore\\\""},
//				// Biomasse
//				{"\\\"name\\\":\\\"Biomasse\\\""
//					,"]},{\\\"id\\\":\\\"hydro-pumped-storage\\\""},
//				// Kernenergie
//				{"\\\"name\\\":\\\"Kernenergie\\\""
//					,"]},{\\\"id\\\":\\\"other\\\""},
//				// CO2-Emissionsfaktor des Strommix
//				{"\\\"name\\\":\\\"CO<sub>2<\\\\\\/sub>-Emissionsfaktor des Strommix\\"
//					,"]}]}"},
//				// Wind Onshore
//				{"\\\"name\\\":\\\"Wind Onshore\\\""
//					,"]},{\\\"id\\\":\\\"wind-offshore\\\""},
//				// Stromverbrauch
//				{"\\\"name\\\":\\\"Stromverbrauch\\\""
//					,"]},{\\\"id\\\":\\\"conventional-power\\\""},
//				// Pumpspeicher
//				{"\\\"name\\\":\\\"Pumpspeicher\\\""
//					,"]},{\\\"id\\\":\\\"gas\\\""},
//				// Wind Offshore
//				{"\\\"name\\\":\\\"Wind Offshore\\\""
//					,"]},{\\\"id\\\":\\\"run-of-the-river\\\""},
//				// Steinkohle
//				{"\\\"name\\\":\\\"Steinkohle\\\""
//					,"]},{\\\"id\\\":\\\"run-of-the-river\\\""},
				// Erdgas
//				{"\\\"name\\\":\\\"Erdgas\\\""
//					,"]},{\\\"id\\\":\\\"coal\\\""}
		};
		
		
		for (int i = 0; i < energySourcesRange.length; i++) {
			  Parser.parseEnergyData(api.getJson(), energySourcesRange[i][0]);
		}
	}
}
