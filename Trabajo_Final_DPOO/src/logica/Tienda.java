package logica;

import java.util.ArrayList;

public class Tienda {
	
	private String nombre;
	private String idComp;
	private String direccion;					
	private String telefono;
	private Gerente jefe;						
	private	ArrayList<Trabajador> plantilla;	
	private ArrayList<Producto>almacen;			
	
	public Tienda(String nombre,String idComp,String direccion,String telefono,Gerente jefe){
		this.plantilla 	= new ArrayList();
		this.almacen 	= new ArrayList();
		
		setNombre(nombre);
		setIDComp(idComp);
		setDireccion(direccion);
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
			llave = true;
			control = Long.parseLong(idComp);
		}		
		catch(Exception e){
			llave = false;
		}		
		finally{
			if(llave && idComp.length() == 5)
				this.idComp = idComp;
			else
				throw new NumberFormatException("Debe ser un número de 5 dígitos");
		}
	}
	public void setDireccion(String direccion) throws NullPointerException{
		if(!direccion.isEmpty())
			this.direccion = direccion;
		else 
			throw new NullPointerException("No ha introducido la direccion");
	}	
	public void setTelefono(String telefono) throws NumberFormatException {
		long control;
		boolean llave = false;		
		
		try{

			llave = true;
			control = Long.parseLong(telefono);
		}		
		catch(Exception e){
			llave = false;
		}		
		finally{
			if(llave && telefono.length() == 8)
				this.telefono = telefono;
			else
				throw new NumberFormatException("Debe ser un número de 8 dígitos");
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
	public ArrayList<Producto> getProducto(){return almacen;}
	
	//AYUDAS
	public ArrayList<String> buscarMarca(String marca){
		ArrayList<String> lista = new ArrayList<String>();
		boolean control = false;
		
		for(Producto producto : almacen){
			if(producto.getMarca().equalsIgnoreCase(marca)){
				if(!control){
					lista.add(getNombreTienda());
					control = true;
				}
				lista.add(producto.getClass().getSimpleName());
				lista.add(producto.getModelo());
			}
		}
		
		if(lista.size()>0)
			return lista;
		else
			return null;
	}
	
}
