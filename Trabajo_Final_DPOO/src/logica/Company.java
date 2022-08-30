package logica;

import java.util.ArrayList;

import excepciones.NonStock;
import excepciones.NotValidInputException;

public class Company {
	private ArrayList<Tienda>tiendas;
	private static Company empresa;
	
	public Company(){
		tiendas = new ArrayList<Tienda>();
	}
	
	public static Company getEmpresa(){
		if(empresa == null)
			empresa = new Company();

		return empresa;
	}	
	public void addTienda(Tienda e){
		this.tiendas.add(e);
	}
	public ArrayList<Tienda> getTienda (){
		return this.tiendas; 
	}
	public  ArrayList<Producto> filtrarPorComponente (String prod) throws NonStock{
		ArrayList<Producto>devolver = new ArrayList<Producto>();
		for (Tienda tienda : tiendas)
			for(Producto producto : tienda.getProducto())
				if(producto.getClass().getSimpleName().equalsIgnoreCase(prod))
					devolver.add(producto);
					
		if(devolver.size()>0)
			return devolver;
		else
			throw new NonStock("No hay "+prod+" en stock");
	}
	public Producto comprarProducto (String producto, String marca, String modelo, double precio){
		Producto devolver = null;
		for(int i = 0; i < tiendas.size() && devolver == null; i++)
			devolver = tiendas.get(i).getProductoSelect(producto, marca, modelo, precio);
		return devolver;
	}
	public Tienda getTienda(String nombre) throws NotValidInputException{
		for (Tienda tienda : tiendas){
			if(tienda.getNombreTienda().equalsIgnoreCase(nombre))
				return tienda;
		}
		throw new NotValidInputException("No existe la tienda "+nombre);
	}

		
	public ArrayList<Producto> microCompatible (MotherBoard board)throws NonStock{
		ArrayList<Producto>devolver = new ArrayList<Producto>();
		for(Tienda tienda : tiendas){
			if(tienda.listaMicro() != null)
				for(Micro micro :  tienda.listaMicro())				
					if(board.getSocket().equalsIgnoreCase(micro.getSocket()))
						devolver.add(micro);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay Microprocesadores compatibles con la Motherboard");
	}
	public ArrayList<Producto> ramCompatible (MotherBoard board)throws NonStock{
		ArrayList<Producto>devolver = new ArrayList<Producto>();
		for(Tienda tienda : tiendas){
			if(tienda.listaRAM()!= null)
				for(RAM ram :  tienda.listaRAM())
					if(board.getTipoRAM().equalsIgnoreCase(ram.getTipoRAM()))
						devolver.add(ram);
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay Memorias RAM compatibles con la Motherboard");
	}
	public ArrayList<Producto> discoCompatible (MotherBoard board)throws NonStock{
		ArrayList<Producto>devolver = new ArrayList<Producto>();
		for(Tienda tienda : tiendas){
			boolean control = false;
			if(tienda.listaDisco()!= null)
				for(Disco disco : tienda.listaDisco()){
					control = false;
					for(int i = 0; i < board.getConexiones().size() && !control;i++)
						if(board.getConexiones(i).equalsIgnoreCase(disco.getConexion())){
							devolver.add(disco);
							control = true;
						}
				}	
		}
		if(devolver.size() > 0)
			return devolver;
		else
			throw new NonStock("No hay Discos Duros compatibles con la Motherboard");
	}
	
	
	
	//REPORTES
	
	//REPORTE 1:
	public Tienda tiendaMasProducto(String producto){
		Tienda eleccion = null;
		int contador = 0;
		int temporal = 0;
		
		for(Tienda tienda : tiendas){
			contador = 0;
			for(Producto prod : tienda.getProducto()){
				if(producto.equalsIgnoreCase(prod.getClass().getSimpleName()))
					contador++;
			}
			if(contador > temporal){
				temporal = contador;
				eleccion = tienda;
			}
		}
		
		return eleccion;
	}
	//REPORTE 2:
	public ArrayList<String> infoGerente (String gerente) throws NotValidInputException{
		ArrayList<String> devolver = new ArrayList<String>();
		for(Tienda tienda : tiendas){
			if(tienda.getGerente().getNombre().equalsIgnoreCase(gerente)){
				devolver.add(tienda.getNombreTienda());
				devolver.add(tienda.getGerente().getFecha().toString());
			}
		}
		if(devolver.size() != 0)
			return devolver;
		else
			throw new NotValidInputException("No se registra ningún gerente de nombre: " + gerente);
	}
	//REPORTE 3:
	public ArrayList<Trabajador> infoTienda(String nombreTienda) throws NotValidInputException{
		ArrayList<Trabajador> devolver = new ArrayList<Trabajador>();
		
		for(Tienda tienda : tiendas)
			if(tienda.getNombreTienda().equalsIgnoreCase(nombreTienda))
				for(Trabajador trabajador : tienda.getPlantilla())
					devolver.add(trabajador);
			
		if(devolver.size() != 0)
			return devolver;
		else
			throw new NotValidInputException("La tienda " + nombreTienda + " no es reconocida");
	} 
	//REPORTE 4:
	public ArrayList<ArrayList<String>> buscarProductoMarca(String marca) throws NotValidInputException{
		ArrayList<ArrayList<String>> eleccion = new ArrayList<ArrayList<String>>();
		
		for(Tienda tienda : tiendas){
			if(tienda.buscarMarca(marca) != null)
				eleccion.add(tienda.buscarMarca(marca));
		}
		if(eleccion.size() > 0)
			return eleccion;
		else 
			throw new NotValidInputException("No hay productos de la marca: " + marca);
	}
	
}
