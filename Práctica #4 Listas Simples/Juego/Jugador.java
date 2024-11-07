package Juego;

import LinkedList.LinkedList;

public class Jugador {
	private String nombre;
	private LinkedList<Carta> monton;

	public Jugador() {
		this("Nameless");
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
		monton = new LinkedList<>();
	}

	public Carta ponerCarta() {
		return monton.deleteLast();
	}

	public void tomarCarta(Carta c) {
		monton.insertLast(c);
	}

	public int cantidadCartas() {
		return monton.size();
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		int cantidadCartas = cantidadCartas();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cantidadCartas; ++i) {
			Carta c = monton.get(i);
			sb.append(c.toString());
			if (i != cantidadCartas - 1) sb.append(" ");
		}

		return sb.toString();
	}
}

