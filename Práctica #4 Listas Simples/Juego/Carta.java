package Juego;

public class Carta implements Comparable<Carta> {
	private int valor;
	private String palo;

	public Carta(int valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	@Override
	public int compareTo(Carta other) {
		return Integer.compare(this.valor, other.valor);
	}

	@Override
	public String toString() {
		if (valor < 11)	return "[" + valor + ", " + palo + "]";

		return switch(valor) {
		case 11 -> "[J, " + palo + "]";
		case 12 -> "[Q, " + palo + "]";
		case 13 -> "[K, " + palo + "]";
		case 14 -> "[A, " + palo + "]";
		default -> null;
		};
	}
}

