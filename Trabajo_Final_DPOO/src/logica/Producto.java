package logica;
import excepciones.NoPriceException;

public abstract class Producto {
	private String marca;
	private String modelo;
	private double precio;
	
	public Producto(String marca, String modelo, double precio) throws Exception {
		setMarca(marca);
		setModelo(modelo);
		setPrecio(precio);
	}
	
	public void setMarca(String marca) throws NullPointerException{
		if(marca != null && marca != "")
			this.marca=marca;
		else
			throw new NullPointerException("Debe introducir el nombre de la marca");
	}
	public void setModelo(String modelo) throws NullPointerException{
		if(modelo != null && modelo != "")
			this.modelo = modelo;
		else
			throw new NullPointerException("Debe introducir el nombre del modelo");
	}
	public void setPrecio(double precio) throws NoPriceException{
		if(precio > 0)
			this.precio = precio;
		else
			throw new NoPriceException ("El precio debe ser un valor positivo");
	}
	
	public String getMarca(){return marca;}
	public String getModelo(){return modelo;}
	public double getPrecio(){return precio;}

}
