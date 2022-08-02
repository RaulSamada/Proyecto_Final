package logica;

import excepciones.NotValidInputException;

public class RAM extends Memoria{
	private String tipoRAM;
	
	public RAM (String marca, String modelo, double precio,double capacidad,String tipoRAM) throws Exception{
		super(marca, modelo, precio, capacidad);
		setTipoRAM(tipoRAM);
	} 
	
	private void setTipoRAM(String tipoRAM) throws NotValidInputException{
		if(tipoRAM.equalsIgnoreCase("ddr") || tipoRAM.equalsIgnoreCase("ddr-2") || tipoRAM.equalsIgnoreCase("ddr-3") || tipoRAM.equalsIgnoreCase("ddr-4"))
			this.tipoRAM = tipoRAM;
		else
			throw new NotValidInputException("No se roconoce el tipo de conexión RAM");
	}
	
	public String getTipoRAM(){return this.tipoRAM;}

}
