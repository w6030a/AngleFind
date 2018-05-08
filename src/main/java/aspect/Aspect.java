package aspect;

public class Aspect {
	
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
}
