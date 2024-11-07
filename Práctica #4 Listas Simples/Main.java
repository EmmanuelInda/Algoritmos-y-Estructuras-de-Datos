import Graphics.Window;
import LinkedList.LinkedList;
import Juego.*;

public class Main {
	public static void main(String[] args) {
		//Window window = new Window();

		Juego juego = new Juego();

		juego.iniciar();
		juego.printStatus();
	}
}
