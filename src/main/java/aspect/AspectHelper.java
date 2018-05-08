package aspect;

public class AspectHelper {

	public enum AspectType {
		CONJUNCTION(0),
		SEMI_SEXTILE(30),
		SEMI_QSUARE(45),
		SEXTILE(60),
		QUINTILE(72),
		SQUARE(90),
		TRINE(120),
		SESQUI_QUADRATE(135),
		BI_QUINTILE(144),
		QUINCUNX(135),
		OPPOSISITION(180);
		
		private final int angle;
		
		private AspectType(int angle) {
			this.angle = angle;
		}
		
		public int getAngle() {
			return angle;
		}
	}
}
