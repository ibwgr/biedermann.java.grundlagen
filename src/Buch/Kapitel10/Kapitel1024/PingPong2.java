package Buch.Kapitel10.Kapitel1024;

import Prog1Tools.IOTools;

/** Ein einfaches Programm, dass das Verhalten beim Fangen von
 Exceptions testet, die in einer verwandtschaftlichen
 Beziehung stehen. */
public class PingPong2 {

  /** Wirft einen PingException */
  public static void Ping() throws PingException {
    System.out.println("Ping aufgerufen!");
    throw new PingException();
  }

  /** Wirft einen PongException */
  public static void Pong() throws PongException {
    System.out.println("Pong aufgerufen!");
    throw new PongException();
  }

  /** Wirft einen PingPongException */
  public static void PingPong() throws PingPongException {
    System.out.println("PingPong aufgerufen!");
    throw new PingPongException();
  }

  /** Fragt den Benutzer, welche Exception ausgeloest werden
   soll, und ruft die entsprechende Methode auf. */
  public static void Hauptprogramm()
    throws PingException, PongException, PingPongException {
    System.out.println("1 = Ping");
    System.out.println("2 = Pong");
    System.out.println("3 = PingPong");
    System.out.println("");
    int choice= IOTools.readInteger("Ihre Wahl:");
    switch(choice) {
      case 1: Ping()    ;break;
      case 2: Pong()    ;break;
      case 3: PingPong();break;
      default:System.out.println("Eingabefehler!");
    }
  }

  /** Hauptprogramm. */
  public static void main(String[] args) {
    try {
      Hauptprogramm();
    }
    catch (PingPongException ex) {
      System.out.println("PingPongException aufgetreten");
    }
  }

}
