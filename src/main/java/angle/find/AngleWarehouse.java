package angle.find;

import java.util.ArrayList;
import java.util.HashMap;

public class AngleWarehouse {

	//HashMap<owner, HashMap<angleType, ArrayList<angle>>>
	static HashMap<String, HashMap<Angle.Type, ArrayList<Angle>>> angles = new HashMap<String, HashMap<Angle.Type, ArrayList<Angle>>>();
	
	public static HashMap<Angle.Type, ArrayList<Angle>> getAngleByPlanet(String planet) {
		return angles.get(planet);
	}
	
	public static ArrayList<Angle> getAngleByPlanetAndType(String planet, Angle.Type type) {
		return angles.get(planet).get(type);
	}
}
