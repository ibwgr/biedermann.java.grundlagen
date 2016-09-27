package A4;

public class Aufgabe416 {
	public static void main (String[] args) {
		long eingabe = 158036522;
		long jahre, tage, stunden, minuten, sekunden;
		jahre = eingabe / 60 / 60 / 24 / 365;
		tage = eingabe / 60 / 60 / 24 % 365;
		stunden = eingabe / 60 / 60 % 24;
		minuten = eingabe / 60 % 60;
		sekunden = eingabe % 60;
		System.out.println(eingabe + " Sekunden entsprechen:");
		System.out.println(jahre + " Jahren,");
		System.out.println(tage + " Tagen,");
		System.out.println(stunden + " Stunden,");
		System.out.println(minuten + " Minuten und");
		System.out.println(sekunden + " Sekunden.");
	}
}