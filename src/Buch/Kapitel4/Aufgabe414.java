package A4;

public class Aufgabe414 {
	public static void main (String[] args) {
		double x = 192119201, y = 35675640;
		double result;
//		result = (1/107751) * ((1682*x*(y*y*y*y)) + (3*(x*x*x)) + (29*x*(y*y)) + (832));
		result = ((x*y*y) / 107751) * ((1682*y*y) + 29) + ((x*x*x) / (107751)) * (3-(2*x*x)) + (832 / 107751);
		System.out.println("Result: " + result);
	}
}