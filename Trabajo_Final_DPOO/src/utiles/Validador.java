package utiles;

import java.awt.event.KeyEvent;

	public abstract class  Validador {
	public static void soloLetras(KeyEvent e){
		char c = e.getKeyChar();
		if(c < 65 || c == 91 || c == 92 || c == 93 || c == 94 || c == 95 || c == 96 || c > 122)
			e.consume();
	}
	public static void soloNumeros(KeyEvent e){
		char c = e.getKeyChar();
		if(c < 0 || c > 9)
			e.consume();
	}
	
}
