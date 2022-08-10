package utiles;

import java.sql.Date;
import java.util.ArrayList;

import logica.Gerente;
import logica.Trabajador;

public class Generador {
	public static void generarDatos(){
		
		
		////////////////Creando presonal//////////////////////
		Trabajador t1=null, t2=null, t3=null;
		try {
			 t1 = new Trabajador("Daniel", "Lopez", "Leyva", "79050251348", "15302", "secundario", 239, "cajero");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			 t2 = new Trabajador("Juan", "Lopez", "Leyva", "83021251348", "15315", "secundario", 239, "almacenero");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		try {
			 t3 = new Gerente("Federico", "Lopez", "Leyva", "83021251348", "15312", "secundario", 239, "gerente",new Date(118,05,03));
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
		
		
		///////////////Contratando personal///////////////////
		ArrayList<Trabajador>plantilla =  new ArrayList<Trabajador>();
		plantilla.add(t1);
		plantilla.add(t2);
		plantilla.add(t3);
		
		
		///////////////Creando Productos/////////////////////
		String s1="zif",s2="bga",s3="pga",s4="lga";
		String r1="ddr",r2="ddr-2",r3="ddr-3",r4="ddr4";
		/*
		 * 
		 * Ponerse ahora a crear productos
		 * 				y
		 * Guardalos en un array
		 * 
		 * */
		
		
		
		/*
		 * 
		 * Crea una tienda
		 * Pasale los arrays de trabajadores y de Producto
		 * 
		 * */
		
		
		
		/*
		 * 
		 * Añade la tienda a la compañia
		 * 
		 * */
		
		
	}
}
