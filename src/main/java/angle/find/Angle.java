package angle.find;

public class Angle {
 
	public static enum Type{
		Zero, Thirty, Fourty, Sixty, SeventyTwo,
		Ninty, OneTwenty, OneThirtyFive, OneFourtyFour,
		OneFifty, OneEighty,
		
		TwoTen, TwoFourty, TwoSeventy, ThreeHundred,
		ThreeSixty,
	}
	
	double angle;

	public Angle(double angle) {
		this.angle = angle;
	}
	
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
}
