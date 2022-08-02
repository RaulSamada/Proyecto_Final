package logica;

import excepciones.NotValidInputException;

public class Memoria extends Producto{
	private double capacidad;
	
	public Memoria(String marca, String modelo, double precio,double capacidad) throws Exception{
		super(marca, modelo, precio);
		setCapacidad(capacidad);
	}
	
	public void setCapacidad(double capacidad) throws NotValidInputException{
		if(capacidad > 0)
			this.capacidad = capacidad;
		else
			throw new NotValidInputException("La capacidad de la memoria debe ser mayor que cero");
	}
	
	public double getCapacidad(){return this.capacidad;}

}
