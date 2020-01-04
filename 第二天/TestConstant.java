public class TestConstant{
	public static void main(String[] args){
		final double PI=3.14;
		double r=4;
		double area=r*r*PI;
		double circle=2*PI*r;
		System.out.println("面积"+area);
		System.out.println("周长"+circle);
	}
}