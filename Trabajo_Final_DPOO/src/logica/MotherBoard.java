package logica;

import java.util.ArrayList;

import excepciones.NotValidInputException;

public class MotherBoard extends Producto{
	private String socket;
	private String tipoRAM;
	private ArrayList<String> conexiones;
	
	public MotherBoard(String marca, String modelo, double precio,String socket,String tipoRAM, ArrayList<String>conexiones) throws Exception{		
		super(marca, modelo, precio);
		
		this.conexiones = new ArrayList<String>();
		
		setSocket(socket);
		setTipoRAM(tipoRAM);
		setConexiones(conexiones);
	}
	
	public MotherBoard(String marca, String modelo, double precio,String socket,String tipoRAM,String conexion) throws Exception {
		super(marca, modelo, precio);
		this.conexiones = new ArrayList<String>();
		
		setSocket(socket);
		setTipoRAM(tipoRAM);
		addConexion(conexion);
	}

	private void setSocket(String socket) throws NotValidInputException{
		if(socket.equalsIgnoreCase("lga") || socket.equalsIgnoreCase("bga") || socket.equalsIgnoreCase("pga") || socket.equalsIgnoreCase("zif"))
			this.socket = socket;
		else
			throw new NotValidInputException("Socket no reconocido");
	}
	private void setTipoRAM(String tipoRAM) throws NotValidInputException{
		if(tipoRAM.equalsIgnoreCase("ddr") || tipoRAM.equalsIgnoreCase("ddr-2") || tipoRAM.equalsIgnoreCase("ddr-3") || tipoRAM.equalsIgnoreCase("ddr-4"))
			this.tipoRAM = tipoRAM;
		else
			throw new NotValidInputException("No se roconoce el tipo de conexión RAM");
	}
	private void setConexiones(ArrayList<String>conexiones)throws NotValidInputException{
		boolean control = true;
		int contador = 0;
		while(control && contador < conexiones.size()){
			if(!conexiones.get(contador).equalsIgnoreCase("ide") && !conexiones.get(contador).equalsIgnoreCase("sata") && !conexiones.get(contador).equalsIgnoreCase("sata-2") && !conexiones.get(contador).equalsIgnoreCase("sata-3"))
				control = false;
			contador++;			
		}
		if(control)	
			this.conexiones = conexiones;
		else
			throw new NotValidInputException("El elemento " + contador + "no es válido");
	}
	private void addConexion(String conexion)throws NotValidInputException{
		if(conexion.equalsIgnoreCase("ide") ||conexion.equalsIgnoreCase("sata") ||conexion.equalsIgnoreCase("sata-2") ||conexion.equalsIgnoreCase("sata-3"))
			this.conexiones.add(conexion);
		else 
			throw new NotValidInputException("La conexión del disco no es una entrada válida");
	}
	
	public String getSocket (){return this.socket;}
	public String getTipoRAM(){return this.tipoRAM;}
	public ArrayList<String> getConexiones(){return this.conexiones;}
	public String getConexiones(int i){return this.conexiones.get(i);}
}
