package utiles;

import java.sql.Date;
import java.util.ArrayList;

import logica.Company;
import logica.Disco;
import logica.Gerente;
import logica.Micro;
import logica.MotherBoard;
import logica.Producto;
import logica.RAM;
import logica.Tienda;
import logica.Trabajador;

public class Generador {
	public static void generarDatos() throws Exception{
		
		
		////////////////Creando presonal//////////////////////
		
		Trabajador	 t1 = new Trabajador("Daniel", "Lopez", "Leyva", "79050251348", "15302", "secundario", 239, "cajero");
		Trabajador	 t2 = new Trabajador("Juan", "Lopez", "Leyva", "83021251348", "15315", "secundario", 239, "almacenero");
		Gerente	 t3 = new Gerente("Federico", "Lopez", "Leyva", "83021251348", "15312", "secundario", 239, "gerente",new Date(118,05,03));
				
		///////////////Contratando personal///////////////////
		ArrayList<Trabajador>plantilla =  new ArrayList<Trabajador>();
		plantilla.add(t1);
		plantilla.add(t2);
		plantilla.add(t3);
		
		
		///////////////Creando Productos/////////////////////
		String s1="zif",s2="bga",s3="pga",s4="lga";
		String r1="ddr",r2="ddr-2",r3="ddr-3",r4="ddr-4";
		String c1="sata",c2="sata-2",c3="sata-3",c4="ide";
		ArrayList<String> conexiones = new ArrayList<String>();
		conexiones.add(c1);
		conexiones.add(c2);
		conexiones.add(c3);
		/*
		 * 
		 * Ponerse ahora a crear productos
		 * 				y
		 * Guardalos en un array
		 * 
		 * */
		
		Producto p1 = new MotherBoard("asus","b-855m", 80, s1, r1, conexiones);
		Producto p2 = new MotherBoard("asus","b-855k", 190, s4, r4, conexiones);
		Producto p3 = new MotherBoard("coirsair","h-500k", 180, s4, r4, conexiones);
		Producto p4 = new MotherBoard("tuf","tuf-2500", 200, s4, r4, conexiones);
		
		Producto p5 = new Disco("Kingston", "k1", 50, 1000, c3);
		Producto p6 = new Disco("Kingston", "k2", 80, 2000, c3);
		
		Producto p7 = new Micro("intel", "i5-4900k", 150, s4, 1.8);
		Producto p8 = new Micro("intel", "i7-4900k", 180, s4, 1.9);
		Producto p9 = new Micro("intel", "i9-9900k", 400, s4, 2.5);
		Producto p10 = new Micro("amd", "ryzen5-5600X", 250, s4, 2.0);
		Producto p11 = new Micro("intel", "pentium-4", 50, s4, 1.2);
		Producto p12 = new Micro("intel", "i5-4900f", 100, s4, 1.8);
		
		Producto p13 = new RAM("Hyperex", "HX421", 50, 4, r4);
		Producto p14 = new RAM("Hyperex", "HX424", 80, 8, r4);
		Producto p15 = new RAM("asus", "X54C", 40, 2, r2);
		
		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		
		productos1.add(p1);
		productos1.add(p2);
		productos1.add(p3);
		productos1.add(p4);
		productos1.add(p5);
		productos1.add(p6);
		productos1.add(p7);
		productos1.add(p8);
		productos1.add(p9);
		productos1.add(p10);
		productos1.add(p11);
		productos1.add(p12);
		productos1.add(p13);
		productos1.add(p14);
		productos1.add(p15);
		
		/*
		 * 
		 * Crea una tienda
		 * Pasale los arrays de trabajadores y de Producto
		 * 
		 * */
		
		Tienda tienda1 = new Tienda("danuvio", "50305", "calle 23 #305", "78302552", t3);
		tienda1.setListaTrab(plantilla);
		tienda1.setListaProd(productos1);	
		
		/*
		 * 
		 * Añade la tienda a la compañia
		 * 
		 * */
		Company.getEmpresa().addTienda(tienda1);
		
		
	}
}
