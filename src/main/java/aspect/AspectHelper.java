package aspect;

import java.util.ArrayList;

public class AspectHelper {

	private static ArrayList<Aspect> aspects = new ArrayList<Aspect>();
	
	static {
		aspects.add(new Aspect("CONJUNCTION", "", 0));
		aspects.add(new Aspect("SEMI_SEXTILE", "", 30));
		aspects.add(new Aspect("SEMI_SQUARE", "", 45));
		aspects.add(new Aspect("SEXTILE", "", 60));
		aspects.add(new Aspect("QUINTILE", "", 72));
		aspects.add(new Aspect("SQUARE", "", 90));
		aspects.add(new Aspect("TRINE", "", 120));
		aspects.add(new Aspect("SESQUI_QUADRATE", "", 135));
		aspects.add(new Aspect("BI_QUINTILE", "", 144));
		aspects.add(new Aspect("QUINCUNX", "", 150));
		aspects.add(new Aspect("OPPOSITION", "", 180));
	}
	
	public static ArrayList<Aspect> getAspects() {
		return aspects;
	}

	//	public enum AspectType {
//		CONJUNCTION(0),
//		SEMI_SEXTILE(30),
//		SEMI_QSUARE(45),
//		SEXTILE(60),
//		QUINTILE(72),
//		SQUARE(90),
//		TRINE(120),
//		SESQUI_QUADRATE(135),
//		BI_QUINTILE(144),
//		QUINCUNX(150),
//		OPPOSITION(180);
//		
//		private final int angle;
//		
//		private AspectType(int angle) {
//			this.angle = angle;
//		}
//		
//		public int getAngle() {
//			return angle;
//		}
//	}
	
}
