package angle.find;

import java.util.HashMap;

public class PlanetTable {

	static HashMap<String, Planet> planets = new HashMap<String, Planet>();
	
	public static Planet getPlanet(String key) {
		return planets.get(key);
	}
	
	public static HashMap<String,Planet> getPlanets() {
		return planets;
	}
	
	static {
//		planets.put("MOON", 	new Planet("MOON", "☽"));
//		planets.put("SUN", 		new Planet("SUN", "☼"));
//		planets.put("MER", 		new Planet("MER", "♀"));
//		planets.put("MARS", 	new Planet("MARS", "♂"));
//		planets.put("JUP", 		new Planet("JUP", "♃"));
//		planets.put("SAT", 		new Planet("SAT", "♄"));
//		planets.put("URA", 		new Planet("URA", "♅"));
//		planets.put("NEP", 		new Planet("NEP", "♆"));
//		planets.put("PLU", 		new Planet("PLU", "♇"));
//		planets.put("NN", 		new Planet("NN", "☊"));
//		planets.put("SN", 		new Planet("SN", "☋"));
//		planets.put("MC", 		new Planet("MC", "MC"));
//		planets.put("VX", 		new Planet("VX", "Vx"));
//		planets.put("ASC", 		new Planet("ASC", "Asc"));
//		planets.put("PF", 		new Planet("PF", "PF"));
//		planets.put("V1", 		new Planet("V1", "V1"));
//		planets.put("PLA 2 ASC",new Planet("PLA 2 ASC"));
//		planets.put("PLA2 MC", 	new Planet("PLA2 MC"));
//		planets.put("FT2", 		new Planet("FT2"));
//		planets.put("V2", 		new Planet("V2"));
//		planets.put("PLA 3 ASC",new Planet("PLA 3 ASC"));
//		planets.put("PLA3 MC", 	new Planet("PLA3 MC"));
//		planets.put("FT3", 		new Planet("FT3"));
//		planets.put("V3", 		new Planet("V3"));
//		planets.put("PLA 4 ASC",new Planet("PLA 4 ASC"));
//		planets.put("FT4", 		new Planet("FT4"));
//		planets.put("V4", 		new Planet("V4"));
//		planets.put("N☿", 		new Planet("N☿"));
//		planets.put("S☿", 		new Planet("S☿"));
//		planets.put("N♀", 		new Planet("N♀"));
//		planets.put("S♀", 		new Planet("S♀"));
//		planets.put("N♂", 		new Planet("N♂"));
//		planets.put("S♂", 		new Planet("S♂"));
//		planets.put("N♃", 		new Planet("N♃"));
//		planets.put("S♃", 		new Planet("S♃"));
//		planets.put("N♄", 		new Planet("N♄"));
//		planets.put("S♄", 		new Planet("S♄"));
//		planets.put("N♅", 		new Planet("N♅"));
//		planets.put("S♅", 		new Planet("S♅"));
//		planets.put("N♆", 		new Planet("N♆"));
//		planets.put("S♆", 		new Planet("S♆"));
//		planets.put("N♇", 		new Planet("N♇"));
//		planets.put("S♇", 		new Planet("S♇"));
	}
}
