package angle.find;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignHelper {

	static final String SIGN_ANGLE_CELL_FORMAT = "(?<intAngle>\\d+)(?<symbol>.+?)(?<doubleAngle>\\d+[.]\\d+)";
	static HashMap<String, Sign> signs = new HashMap<String, Sign>();
	
	static {
		signs.put("AR",	new Sign("ARIES", "♈", 0));
		signs.put("TA", new Sign("TAURUS", "♉", 30));
		signs.put("GE", new Sign("GEMINI", "♊", 60));
		signs.put("CA", new Sign("CANCER", "♋", 90));
		signs.put("LE", new Sign("LEO", "♌", 120));
		signs.put("VI", new Sign("VIRGO", "♍", 150));
		signs.put("LI", new Sign("LIBRA", "♎", 180));
		signs.put("SC", new Sign("SCORPIO", "♏", 210));
		signs.put("SG",	new Sign("SAGITTARIUS", "♐", 240));
		signs.put("CP", new Sign("CAPRICORN", "♑", 270));
		signs.put("AQ", new Sign("AQURARIUS", "♒", 300));
		signs.put("PI", new Sign("PISCES", "♓", 330));
		
		signs.put("♈",	new Sign("ARIES", "♈", 0));
		signs.put("♉", 	new Sign("TAURUS", "♉", 30));
		signs.put("♊", 	new Sign("GEMINI", "♊", 60));
		signs.put("♋", 	new Sign("CANCER", "♋", 90));
		signs.put("♌", 	new Sign("LEO", "♌", 120));
		signs.put("♍", 	new Sign("VIRGO", "♍", 150));
		signs.put("♎", 	new Sign("LIBRA", "♎", 180));
		signs.put("♏", 	new Sign("SCORPIO", "♏", 210));
		signs.put("♐",	new Sign("SAGITTARIUS", "♐", 240));
		signs.put("♑", 	new Sign("CAPRICORN", "♑", 270));
		signs.put("♒", 	new Sign("AQURARIUS", "♒", 300));
		signs.put("♓", 	new Sign("PISCES", "♓", 330));
	}
	
	public static Sign getSign(String key) {
		return signs.get(key);
	}
	
	public static String[] splitParts(String str) {
		Pattern pattern = Pattern.compile(SIGN_ANGLE_CELL_FORMAT);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			String[] parts = {matcher.group("intAngle"), matcher.group("symbol"), matcher.group("doubleAngle")};
		    return parts;
		}
		
		throw new RuntimeException("Split cell parts failed");
	}
}
