package programa;

import utiles.Generador;
import interfaz.Principal;

public class Main {

	public static void main(String[] args) {
	
		try {
			utiles.Generador.generarDatos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Principal ventana = new Principal();
		ventana.setVisible(true);

	}

}
