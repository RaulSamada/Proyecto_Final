package interfaz;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import excepciones.NonStock;
import logica.Company;
import logica.Disco;
import logica.Micro;
import logica.MotherBoard;
import logica.PC;
import logica.Producto;
import logica.RAM;
import logica.Tienda;

public class ArmarPC extends JPanel implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblPrecio;
	private JLabel lblSalidaPrecio;
	private JButton btnAnnadir;
	private JButton btnPagar;
	private JButton btnReset;
	private ArrayList<Producto>componentes;
	private PC computadora;
	

	/**
	 * Create the panel.
	 */
	public ArmarPC() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		inicializarComponentes();

	}
	public void inicializarComponentes(){
		computadora = new PC();
		componentes = new ArrayList<Producto>();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 669, 314);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Producto");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Precio");
		try {
			llenarTabla(Company.getEmpresa().filtrarPorComponente("motherboard"));
		} catch (NonStock ex) {
			utiles.Validador.errorPanel("No tenemos absto en estos momentos para armar una PC");
		}
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(466, 336, 213, 153);
		add(panel);
		panel.setLayout(null);
		
		lblPrecio = new JLabel("Pecio del equipo:");
		lblPrecio.setForeground(SystemColor.text);
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		lblPrecio.setBounds(0, 0, 213, 49);
		panel.add(lblPrecio);
		
		lblSalidaPrecio = new JLabel("");
		lblSalidaPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaPrecio.setForeground(Color.WHITE);
		lblSalidaPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		lblSalidaPrecio.setBounds(0, 60, 213, 82);
		panel.add(lblSalidaPrecio);
		
		btnAnnadir = new JButton("A\u00F1adir");
		btnAnnadir.setForeground(SystemColor.text);
		btnAnnadir.setBackground(SystemColor.textHighlight);
		btnAnnadir.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnAnnadir.setBounds(10, 336, 129, 41);
		btnAnnadir.addActionListener(this);
		add(btnAnnadir);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setForeground(SystemColor.text);
		btnPagar.setBackground(new Color(46, 139, 87));
		btnPagar.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnPagar.setEnabled(false);
		btnPagar.setBounds(288, 336, 129, 41);
		btnPagar.addActionListener(this);
		add(btnPagar);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnReset.setForeground(SystemColor.text);
		btnReset.setBackground(new Color(178, 34, 34));
		btnReset.setBounds(149, 336, 129, 41);
		btnReset.addActionListener(this);
		add(btnReset);
	}
	
	private void llenarTabla(ArrayList<Producto> productos){
		model.setRowCount(0);
		for(Producto producto : productos){
			Object[] fila = new Object[4];
			fila[0] = producto.getClass().getSimpleName();
			fila[1] = producto.getMarca();
			fila[2] = producto.getModelo();
			fila[3] = producto.getPrecio();
			model.addRow(fila);
		}
	}	
	private void limpiarTabla (){
		model.setRowCount(0);
	}
	public void actionPerformed(ActionEvent e) {
		if(btnAnnadir == e.getSource()){
			seleccionarProducto();
			if(componentes.size()== 1){
				limpiarTabla();
				try {
					llenarTabla(Company.getEmpresa().microCompatible((MotherBoard) componentes.get(0)));
				} catch (NonStock e1) {
					utiles.Validador.errorPanel("No tenemos microprocesadores compatibles");
				}
			}else if(componentes.size()== 2){
				limpiarTabla();
				try {
					llenarTabla(Company.getEmpresa().ramCompatible((MotherBoard) componentes.get(0)));
				} catch (NonStock e1) {
					utiles.Validador.errorPanel("No tenemos memorias RAM compatibles");
				}
			}else if(componentes.size()== 3){
				limpiarTabla();
				try {
					llenarTabla(Company.getEmpresa().discoCompatible((MotherBoard) componentes.get(0)));//AQUI NO ESTA RECONOCIENDO EL SIZE DE LAS CONEXIONES
					btnPagar.setEnabled(true);
				} catch (NonStock e1) {
					utiles.Validador.errorPanel("No tenemos discos duros compatibles");
				}
			}
		}else if(btnReset == e.getSource()){
			try {
				llenarTabla(Company.getEmpresa().filtrarPorComponente("motherboard"));
			} catch (NonStock ex) {
				utiles.Validador.errorPanel("No tenemos absto en estos momentos para armar una PC");
			}
			componentes.clear();
		}else if(btnPagar == e.getSource()){
			computadora.setPlaca((MotherBoard) componentes.get(0));
			try {
				computadora.setMicro((Micro) componentes.get(1));
			} catch (Exception e1) {
				utiles.Validador.errorPanel(e1.getMessage());
			}
			try {
				computadora.setRAM((RAM) componentes.get(2));
			} catch (Exception e1) {
				utiles.Validador.errorPanel(e1.getMessage());
			}
			try {
				computadora.setDisco((Disco) componentes.get(3));
			} catch (Exception e1) {
				utiles.Validador.errorPanel(e1.getMessage());
			}
			Recibo recibo = new Recibo(componentes);
			recibo.setVisible(true);
			btnPagar.setEnabled(false);
			btnReset.doClick();
		}
		
	}
	private void seleccionarProducto(){
		int seleccion = table.getSelectedRow();			
		if(utiles.Validador.seleccionTabla(seleccion)){
			String producto = table.getValueAt(seleccion, 0).toString();
			String marca	= table.getValueAt(seleccion, 1).toString();
			String modelo	= table.getValueAt(seleccion, 2).toString();
			double precio	= Double.parseDouble(table.getValueAt(seleccion, 3).toString());
			if(!utiles.Validador.enCarrito(componentes, Company.getEmpresa().comprarProducto(producto, marca, modelo, precio)))
				componentes.add(Company.getEmpresa().comprarProducto(producto, marca, modelo, precio));
			else
				utiles.Validador.errorPanel("El elemento ya ha sido añadido al carrito");
		}
	}
}
	
