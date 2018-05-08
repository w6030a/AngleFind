package sign;

public class Sign {

	private String name;
	private String abbrv;
	private String symbol;
	private double angle;
	
	public Sign(String name, String symbol, double angle) {
		this.name = name;
		this.abbrv = name.substring(0, 1);
		this.symbol = symbol;
		this.angle = angle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrv() {
		return abbrv;
	}

	public void setAbbrv(String abbrv) {
		this.abbrv = abbrv;
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
