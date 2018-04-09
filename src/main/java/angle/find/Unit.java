package angle.find;

public class Unit {

	private Planet planet;
	private String postFix;
	private double angle;
	private Unit next = null;

	public String getSymbol() {
		return planet.getSymbol() + postFix;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	public String getPostFix() {
		return postFix;
	}
	
	public void setPostFix(String postFix) {
		this.postFix = postFix;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Unit getNext() {
		return next;
	}

	public void setNext(Unit next) {
		this.next = next;
	}
}
