package logica;

import java.util.ArrayList;

public class Tienda {
	
	private String nombre;
	private String idComp;
	private String direccion;					//pendiente hacer el set de esta funcion
	private String telefono;
	private Gerente jefe;						//Hacer la clase de Gerente
	private	ArrayList<Trabajador> plantilla;	//Hacer la clase de Trabajador
	private ArrayList<Producto>almacen;			
	
	public Tienda(String nombre,String idComp,String direccion,String telefono,Gerente jefe){
		this.plantilla 	= new ArrayList();
		this.almacen 	= new ArrayList();
		
		setNombre(nombre);
		setIDComp(idComp);
		setDireccion();//dentro va direccion
		setTelefono(telefono);
		setGerente(jefe);
	}
	
	public void setNombre(String nombre) throws NullPointerException {
		if(nombre != null && nombre != "")
			this.nombre=nombre;
		else
			throw new NullPointerException("Debe introducir el nombre de la tienda");
	}
	public void setIDComp(String idComp) throws NumberFormatException {
		long control;
		boolean llave = false;		
		
		try{
			control = Long.parseLong(idComp);
			llave = true;
		}		
		catch(Exception e){
			llave = false;
		}		
		finally{
			if(llave && idComp.length() == 5)
				this.idComp = idComp;
			else
				throw new NumberFormatException("Debe ser un n�mero de 5 d�gitos");
		}
	}
	public void setDireccion(){}	//pendiente de hacer
	public void setTelefono(String telefono) throws NumberFormatException {
		long control;
		boolean llave = false;		
		
		try{
			control = Long.parseLong(telefono);
			llave = true;
		}		
		catch(Exception e){
			llave = false;
		}		
		finally{
			if(llave && telefono.length() == 8)
				this.telefono = telefono;
			else
				throw new NumberFormatException("Debe ser un n�mero de 8 d�gitos");
		}
	}
	public void setGerente(Gerente jefe){
		this.jefe = jefe;
	}
	public void setListaTrab(ArrayList<Trabajador>plantilla){
		this.plantilla = plantilla;
	}
	public void addTrabajador(Trabajador e){
		this.plantilla.add(e);
	}
	public void setListaProd(ArrayList<Producto>almacen){
		this.almacen =almacen;
	}
	public void addProducto(Producto e){
		this.almacen.add(e);
	}
	
	public String getNombreTienda(){return nombre;}
	public String getIdComp(){return idComp;}
	public String getDireccion(){return direccion;}
	public String getTelefono(){return telefono;}
	public Gerente getGerente(){return jefe;}
	public ArrayList<Trabajador> getPlantilla(){return plantilla;}
	
}