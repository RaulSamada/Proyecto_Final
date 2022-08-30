package utiles;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.NonStock;
import logica.Disco;
import logica.Micro;
import logica.MotherBoard;
import logica.Producto;
import logica.RAM;

	public abstract class  Validador {
	public static void soloLetras(KeyEvent e){
		char c = e.getKeyChar();
		if(c < 65 || c == 91 || c == 92 || c == 93 || c == 94 || c == 95 || c == 96 || c > 122)
			e.consume();
	}
	public static void soloNumeros(KeyEvent e){
		char c = e.getKeyChar();
		if(c < 48 || c > 57)
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
	public static void successPanel (String msg){
		 JOptionPane.showMessageDialog(null, msg);
	}
	public static boolean seleccionTabla (int row){
			return row >= 0? true : false;
	}
	public static boolean enCarrito (ArrayList<Producto> carrito, Producto compra){
		if(carrito.size()>0){
			for(Producto producto : carrito){
				if(producto == compra)
					return true;
			}
		}
			return false;
	}
	public static boolean enviar(ArrayList<JTextField> textos){
		boolean t = false;
		for(JTextField text : textos){
			t = false;
			if(!text.getText().isEmpty())
				t = true;
		}
		return t;
	}
	
	public static void actualizarPrecio(ArrayList<Producto> carrito,JLabel lblPrecioSalida) {
		lblPrecioSalida.setText("");
		if(carrito.size() > 0){
			double total=0;
			for(Producto producto : carrito){
				total += producto.getPrecio();
				lblPrecioSalida.setText(String.valueOf(total));
			}
		}
		
	}

}
