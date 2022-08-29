package utiles;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
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
	public static ArrayList<Micro> microCompatible(MotherBoard board,ArrayList<Micro> lista)throws NonStock{
		ArrayList<Micro>devolver = new ArrayList<Micro>();
		for(Micro micro : lista){
			if(board.getSocket().equals(micro.getSocket()))
				devolver.add(micro);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay Microprocesadores compatibles con la Motherboard");
	}
	public static ArrayList<RAM> ramCompatible(MotherBoard board,ArrayList<RAM> lista)throws NonStock{
		ArrayList<RAM>devolver = new ArrayList<RAM>();
		for(RAM ram : lista){
			if(board.getTipoRAM().equalsIgnoreCase(ram.getTipoRAM()))
				devolver.add(ram);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay memorias RAM compatibles con la Motherboard");
	}
	public static ArrayList<Disco> discoCompatible(MotherBoard board,ArrayList<Disco> lista)throws NonStock{
		ArrayList<Disco>devolver = new ArrayList<Disco>();
		boolean control = false;
		for(Disco disco : lista){
			control = false;
			for(int i = 0; i < board.getConexiones().size() && !control;i++)
				if(board.getConexiones(i).equalsIgnoreCase(disco.getConexion())){
					devolver.add(disco);
					control = true;
				}
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay Discos Duros compatibles con la Motherboard");
	}
}
