package logica;

import java.util.ArrayList;

import excepciones.NotValidInputException;

public class PC {
	private MotherBoard placa;
	private Micro procesador;
	private RAM ram;
	private ArrayList<Disco> almacenamiento;
	
	public PC (MotherBoard placa,Micro procesador,RAM ram,Disco almacenamiento) throws Exception{
		this.almacenamiento = new ArrayList<Disco>();
		setPlaca(placa);
		setMicro(procesador);
		setRAM(ram);
		setDisco(almacenamiento);
	}	
	public PC (MotherBoard placa,Micro procesador,RAM ram,ArrayList<Disco> almacenamiento) throws Exception{
		this.almacenamiento = new ArrayList<Disco>();
		setPlaca(placa);
		setMicro(procesador);
		setRAM(ram);
		setDisco(almacenamiento);
	}
	
	public void setPlaca(MotherBoard placa) throws NullPointerException{
		if(placa != null)
			this.placa = placa;
		else
			throw new NullPointerException("Falta la placa base");
	}
	public void setMicro(Micro procesador) throws Exception{
		if(procesador != null){
			if(procesador.getSocket().equalsIgnoreCase(this.placa.getSocket()))
				this.procesador =  procesador;
			else
				throw new NotValidInputException("El procesador no es compatible con la placa");
		}else
			throw new NullPointerException("Falta el microprocesador");
	}
	public void setRAM(RAM ram) throws Exception{
		if(ram != null){
			if(ram.getTipoRAM().equalsIgnoreCase(this.placa.getTipoRAM()))
				this.ram = ram;
			else
				throw new NotValidInputException("La memoria RAM elegida no es compatible");
		}else
			throw new NullPointerException("Falta la RAM");		
	}
	public void setDisco(Disco almacenamiento) throws Exception{
		boolean control = false;
		int contador = 0;
		if(almacenamiento != null){
			
			while(!control && contador < this.placa.getConexiones().size()){
				if(almacenamiento.getConexion().equalsIgnoreCase(this.placa.getConexiones(contador)))
						control = true;
				contador ++;
			}
			
			if(control)
				this.almacenamiento.add(almacenamiento);
			else
				throw new NotValidInputException("La conexion del disco no es compatible con la placa base");
			
		}else
			throw new NullPointerException("Falta el almacenamiento");
	}
	public void setDisco(ArrayList<Disco> almacenamiento) throws Exception{
		boolean control = false;
		boolean validArray = true;
		int contador = 0;
		int i = 0; 
		if(almacenamiento != null){
			
			for(i= 0; i < almacenamiento.size() && validArray;i++){
				control = false;
				
				while(!control && contador<this.placa.getConexiones().size())
					if(almacenamiento.get(i).getConexion().equalsIgnoreCase(this.placa.getConexiones(contador)))
						control = true;
					
					if(control)
						validArray = true;
					else
						validArray = false;
			}
			
			if(validArray)
				this.almacenamiento = almacenamiento;
			else
				throw new NotValidInputException("La conexion del disco "+ i + " no es compatible con la placa base");
			
		}else
			throw new NullPointerException("Falta el almacenamiento");
	}
	
	public MotherBoard getPlaca(){return this.placa;}
	public Micro getMicro(){return this.procesador;}
	public RAM getRAM(){return this.ram;}
	public ArrayList<Disco> getDiscos(){return this.almacenamiento;}
	public Disco getDisco(int i) throws IndexOutOfBoundsException{
		if(i<almacenamiento.size())
			return this.almacenamiento.get(i);
		else
			throw new IndexOutOfBoundsException("No hay elemento en ese índice");
	}
	
	public double getPrecioPC(){
		double precioDiscos = 0;
		for(int i = 0; i < almacenamiento.size();i++)
			precioDiscos += almacenamiento.get(i).getPrecio();
		
		return placa.getPrecio()+procesador.getPrecio()+ram.getPrecio()+precioDiscos;
	}
}
