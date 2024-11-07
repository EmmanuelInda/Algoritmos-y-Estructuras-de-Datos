package Juego;

import LinkedList.LinkedList;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	//private Mesa mesa;
	private int rondaActual;
	private int limiteRondas;

	public Juego() {
		jugador1 = new Jugador("Jugador 1");
		jugador2 = new Jugador("Jugador 2");
	}

	public void iniciar() {
		repartirCartas();
	}

	public void jugarRonda() {
	}

	public void determinarGanador() {
	}

	private void repartirCartas() {
		String[] palos = {"Pica", "Corazon", "Trebol", "Diamante"};
		LinkedList<Carta> mazo = new LinkedList<>();

		for (String palo : palos) {
			for (int valor = 2; valor <= 14; ++valor) {
				mazo.insertLast(new Carta(valor, palo));
			}
		}

		mazo.shuffle();

		for (int i = 0; i < 52; ++i) {
			if (i % 2 == 0)
				jugador1.tomarCarta(mazo.deleteFirst());
			else
				jugador2.tomarCarta(mazo.deleteFirst());
		}
	}

	public void printStatus() {
		System.out.println(jugador1.getNombre() + ":\n" + jugador1 + "\n");
		System.out.println(jugador2.getNombre() + ":\n" + jugador2 + "\n");
	}
}

