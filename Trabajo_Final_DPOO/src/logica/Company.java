package logica;

import java.util.ArrayList;

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
