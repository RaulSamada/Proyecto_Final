package logica;

import java.sql.Date;

public class Gerente extends Trabajador{
	public Date fecha;
	
	public Gerente(String nombre,String apellidoP,String apellidoM,String ci,String id,String grado,double salario,String cargo,Date fecha) throws Exception{
		super(nombre, apellidoP, apellidoM, ci, id, grado, salario, cargo);
		setFecha(fecha);		
	}
	
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	
	public Date getFecha(){return fecha;}

}
