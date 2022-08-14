package utiles;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	public static void activarBoton(JButton btn, JTextField txt){
		if(!txt.getText().isEmpty())
			btn.setEnabled(true);
		else
			btn.setEnabled(false);
	}
	public static String leerProducto (String producto){
		if(producto.equalsIgnoreCase("micro")||producto.equalsIgnoreCase("procesador")||producto.equalsIgnoreCase("microprocesador")||producto.equalsIgnoreCase("cpu")){
			return "micro";
		}else if(producto.equalsIgnoreCase("motherboard")||producto.equalsIgnoreCase("board")||producto.equalsIgnoreCase("placa")||producto.equalsIgnoreCase("placa base")||producto.equalsIgnoreCase("placabase")){
			return "motherboard";
		}else if(producto.equalsIgnoreCase("ram")||producto.equalsIgnoreCase("memoria ram")){
			return "ram";
		}else if(producto.equalsIgnoreCase("disco")||producto.equalsIgnoreCase("disco duro")||producto.equalsIgnoreCase("almacenamiento")||producto.equalsIgnoreCase("memoria")){
			return "disco";
		}
		return null;
	}
	public static void errorPanel (String msg){
		 JOptionPane.showMessageDialog(null, msg,"ERROR",JOptionPane.ERROR_MESSAGE);
	}
	
}
