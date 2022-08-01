package logica;

import excepciones.NoPriceException;
import excepciones.NotLongEnoughException;
import excepciones.NotValidIndexException;

public class Trabajador {
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String ci;
	private String id;
	private String grado; //NIVEL ESCOLAR
	private double salario;
	private String cargo;
	
	public Trabajador(String nombre,String apellidoP,String apellidoM,String ci,String id,String grado,double salario,String cargo) throws Exception{
		
		setNombre(nombre);
		setApellidos(apellidoP, apellidoM);
		setCI(ci);
		setID(id);
		setGrado(grado);
		setSalario(salario);
		setCargo(cargo);
		
	}

	public void setNombre(String nombre) throws NullPointerException {
		if(nombre != null && nombre != "")
			this.nombre=nombre;
		else
			throw new NullPointerException("Debe introducir el nombre de la tienda");
	}
	public void setApellidos(String apellidoP, String apellidoM) throws NullPointerException {
		if(apellidoP != null && apellidoP != "" && apellidoM != null && apellidoM != ""){
			this.apellidoP=apellidoP;
			this.apellidoM=apellidoM;
		}else
			throw new NullPointerException("Debe introducir los dos apellidos");
	}
	public void setCI(String ci) throws Exception {
		boolean control = true;
		int i = 0;
		if(ci.length() == 11){
			while(control && i<ci.length())
				if(!Character.isDigit(ci.charAt(i)))
					control = false;
			if(control)
				this.ci = ci;
			else
				throw new NumberFormatException ("Número de identidad inválido");
		}else
			throw new NotLongEnoughException ("No el número de identidad debe tener 11 caracteres");
	}
	public void setID(String id) throws Exception {
		boolean control = true;
		int i = 0;
		if(id.length() == 5){
			while(control && i<id.length())
				if(!Character.isDigit(id.charAt(i)))
					control = false;
			if(control)
				this.id = id;
			else
				throw new NumberFormatException ("Número de identidad inválido");
		}else
			throw new NotLongEnoughException ("No el número de identidad debe tener 5 caracteres");
	}
	public void setGrado(String grado) throws NotValidIndexException {
		if(grado.equalsIgnoreCase("Secundario") ||	grado.equalsIgnoreCase("Bachiller")	||	grado.equalsIgnoreCase("Superior") )
			this.grado = grado;
		else
			throw new NotValidIndexException ("No es un grado válido");
	}
	public void setSalario(double salario) throws NoPriceException {
		if(salario > 0)
			this.salario = salario;
		else
			throw new NoPriceException("El salario debe ser superior a cero");
	}
	public void setCargo(String cargo) throws NotValidIndexException {
		if(cargo.equalsIgnoreCase("almacenero") || cargo.equalsIgnoreCase("cajero") || cargo.equalsIgnoreCase("contador") || cargo.equalsIgnoreCase("gerente"))
			this.cargo = cargo;
		else
			throw new NotValidIndexException("Cargo no válido");
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public String getApellidoP(){
		return apellidoP;
	}
	public String getApellidoM(){return apellidoM;}
	public String getCI(){return ci;}
	public String getID(){return id;}
	public String getGrado(){return grado;}
	public double getSalario(){return salario;}
	public String getCargo(){return cargo;}
	
}
