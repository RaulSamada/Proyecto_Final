package logica;

import excepciones.NotValidInputException;

public class Micro extends Producto{
	private String socket;
	private double velocidad;
	
	public Micro (String marca, String modelo, double precio,String socket, double velocidad) throws Exception{
		super(marca, modelo, precio);
		setSocket(socket);
		setVelocidad(velocidad);
	}
	
	private void setSocket(String socket) throws NotValidInputException{
		if(socket.equalsIgnoreCase("lga") || socket.equalsIgnoreCase("bga") || socket.equalsIgnoreCase("pga") || socket.equalsIgnoreCase("zif"))
			this.socket = socket;
		else
			throw new NotValidInputException("Socket no reconocido");
	}
	private void setVelocidad(double velocidad) throws NotValidInputException{
		if(velocidad > 0)
			this.velocidad = velocidad;
		else
			throw new NotValidInputException("La velocidad del microprocesador debe ser mayor que cero");
	}
	
	public String getSocket(){return this.socket;}
	public double getVelocidad(){return this.velocidad;}

}
