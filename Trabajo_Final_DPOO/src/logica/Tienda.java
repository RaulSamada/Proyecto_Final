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
				throw new NumberFormatException("Debe ser un n?mero de 5 d?gitos");
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
				throw new NumberFormatException("Debe ser un n?mero de 8 d?gitos");
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
	public Producto getProductoSelect (String producto, String marca, String modelo, double precio){
		Producto devolver = null;
		for(Producto elemento : almacen){
			if (producto.equalsIgnoreCase(elemento.getClass().getSimpleName()) && marca.equalsIgnoreCase(elemento.getMarca()) && modelo.equalsIgnoreCase(elemento.getModelo()) && precio == elemento.getPrecio()){
				devolver = elemento;
			}
		}
		return devolver;
	}
	public ArrayList<Micro> listaMicro(){
		ArrayList<Micro>devolver = new ArrayList<Micro>();
		for(Producto producto : almacen){
			if(producto.getClass().getSimpleName().equalsIgnoreCase("micro"))
				devolver.add((Micro) producto);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			return null;
	}
	public ArrayList<Disco> listaDisco(){
		ArrayList<Disco>devolver = new ArrayList<Disco>();
		for(Producto producto : almacen){
			if(producto.getClass().getSimpleName().equalsIgnoreCase("disco"))
				devolver.add((Disco) producto);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			return null;
	}
	public ArrayList<RAM> listaRAM(){
		ArrayList<RAM>devolver = new ArrayList<RAM>();
		for(Producto producto : almacen){
			if(producto.getClass().getSimpleName().equalsIgnoreCase("RAM"))
				devolver.add((RAM) producto);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			return null;
	}
	
}
