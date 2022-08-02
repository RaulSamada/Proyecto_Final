package logica;

import java.util.ArrayList;

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
	
	
	
}
