package aspect;

import java.util.Comparator;

public class Aspect implements Comparator<Aspect>, Comparable<Aspect>{
	
	private String name;
	private String symbol;
	private double angle;
	
	public Aspect(String name, String symbol, double angle) {
		this.name = name;
		this.symbol = symbol;
		this.angle = angle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	@Override
	public int compareTo(Aspect anotherAspect) {
		return Double.compare(this.getAngle(), anotherAspect.getAngle());
	}

	@Override
	public int compare(Aspect a1, Aspect a2) {
		return Double.compare(a1.getAngle(), a2.getAngle());
	}
}
