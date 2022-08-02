package logica;

import excepciones.NotValidInputException;

public class Disco extends Memoria {
	private String conexion;
	
	public Disco(String marca, String modelo, double precio, double capacidad,String conexion) throws Exception {
		super(marca, modelo, precio, capacidad);
		setConexion(conexion);
	}
	
	private void setConexion(String conexion) throws NotValidInputException{
		if(conexion.equalsIgnoreCase("ide") || conexion.equalsIgnoreCase("sata") || conexion.equalsIgnoreCase("sata-2") || conexion.equalsIgnoreCase("sata-3"))
			this.conexion = conexion;
		else
			throw new NotValidInputException("Tipo de conexi�n del disco no reconocido");
	}
	
	public String getConexion(){return this.conexion;}

}
