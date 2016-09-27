package A4;

public class Aufgabe415 {
	public static void main (String[] args) {
		final double PI = 3.141592;
		double u, h;
		u = 10; // geeignete Testwerte einbauen
		h = 5; // geeignete Testwerte einbauen
		
		// nachfolgend die fehlenden Deklarationen ergaenzen
		double dBoden, fBoden, fMantel, fGesamt, v;
		
		// nachfolgend die fehlenden Berechnungen ergaenzen
		dBoden = u / PI;
		fBoden = PI * Math.pow(dBoden / 2, 2.0);
		fMantel = u * h;
		fGesamt = 2 * fBoden + fMantel;
		v = fBoden * h;
		
		// nachfolgend die fehlenden Ausgaben ergaenzen
		System.out.println("Durchmesser: " + dBoden);
		System.out.println("Fläche: " + fBoden);
		System.out.println("Mantelfläche: " + fMantel);
		System.out.println("Gesamtfläche: " + fGesamt);
		System.out.println("Volumen: " + v);
	}
}