package angle.find;

public class Angle implements Comparable<Angle>{

	private double degree;
	private String firstSymbol;
	private String secondSymbol;

	public Angle(double degree, String firstSymbol, String secondSymbol) {
		super();
		this.degree = degree;
		this.firstSymbol = firstSymbol;
		this.secondSymbol = secondSymbol;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}

	public String getFirstSymbol() {
		return firstSymbol;
	}

	public void setFirstSymbol(String firstSymbol) {
		this.firstSymbol = firstSymbol;
	}

	public String getSecondSymbol() {
		return secondSymbol;
	}

	public void setSecondSymbol(String secondSymbol) {
		this.secondSymbol = secondSymbol;
	}

	@Override
	public int compareTo(Angle anotherAngle) {
		return Double.compare(this.getDegree(), anotherAngle.getDegree());
	}
}
