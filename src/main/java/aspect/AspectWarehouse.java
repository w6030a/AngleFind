package aspect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import angle.find.Angle;

public class AspectWarehouse {

	//HashMap<owner(Planet), HashMap<Aspect Name, ArrayList<Aspect>>>
	static HashMap<String, HashMap<String, ArrayList<Angle>>> aspects = new HashMap<String, HashMap<String, ArrayList<Angle>>>();
	
	public static void add(String planet, String aspect, Angle angle) {
		HashMap<String, ArrayList<Angle>> aspectMap = aspects.get(planet);
		if(aspectMap == null) {
			aspectMap = new HashMap<String, ArrayList<Angle>>();
			ArrayList<Angle> angleList = new ArrayList<Angle>();
			angleList.add(angle);
			aspectMap.put(aspect, angleList);
			aspects.put(planet, aspectMap);
		} else {
			ArrayList<Angle> angleList = aspectMap.get(aspect);
			if(angleList == null) {
				angleList = new ArrayList<Angle>();
				angleList.add(angle);
			} else {
				angleList.add(angle);
			}
		}
	}
	
	public static Set<String> getPlanetTypes() {
		return aspects.keySet();
	}
	
	public static Set<String> getAspectTypes(String planet) {
		return aspects.get(planet).keySet();
	}
	
	public static HashMap<String, ArrayList<Angle>> getAspectsByPlanet(String planet) {
		return aspects.get(planet);
	}
	
	public static ArrayList<Angle> getAspectsByPlanetAndAspectName(String planet, String aspectName) {
		return aspects.get(planet).get(aspectName);
	}
	
	public static ArrayList<Angle> getSortedAspectsByPlanetAndAspectName(String planet, String aspectName) {
		Collections.sort(aspects.get(planet).get(aspectName));
		return aspects.get(planet).get(aspectName);
	}
}
