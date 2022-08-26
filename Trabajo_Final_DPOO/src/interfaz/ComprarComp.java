package interfaz;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import excepciones.NonStock;

import java.awt.SystemColor;
import java.util.ArrayList;

import logica.Company;
import logica.Producto;
import logica.Tienda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComprarComp extends JPanel implements ActionListener{
	private JTable table;
	private DefaultTableModel model;
	private JComboBox comboBox;
	private JButton btnPagar;
	private JButton btnVerCarrito;
	private JButton btnAnnadir;
	private JLabel lblFiltrarPor;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblPrecio;
	private JLabel lblPrecioSalida;
	private ArrayList<Producto>carrito;

	/**
	 * Create the panel.
	 */
	public ComprarComp() {
		setBackground(Color.WHITE);
		carrito = new ArrayList<Producto>();
		inicializarComponentes();
	}
	
	private void inicializarComponentes(){
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 388, 478);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Producto");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Precio");
		llenarTabla(Company.getEmpresa().getTienda());
		scrollPane.setViewportView(table);
		
		lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblFiltrarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrarPor.setBounds(408, 12, 271, 34);
		add(lblFiltrarPor);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem() == "Precio"){
					limpiarTabla ();
				}else if(comboBox.getSelectedItem() == "Motherboard"){
					limpiarTabla ();
					try {
						llenarTablaProd(Company.getEmpresa().filtrarPorComponente("Motherboard"));
					} catch (NonStock ex) {
						utiles.Validador.errorPanel(ex.getMessage());
					}
				}else if(comboBox.getSelectedItem() == "Microprocesador"){
					limpiarTabla ();
					try {
						llenarTablaProd(Company.getEmpresa().filtrarPorComponente("micro"));
					} catch (NonStock ex) {
						utiles.Validador.errorPanel(ex.getMessage());
					}
				}else if(comboBox.getSelectedItem() == "Disco"){
					limpiarTabla ();
					try {
						llenarTablaProd(Company.getEmpresa().filtrarPorComponente("disco"));
					} catch (NonStock ex) {
						utiles.Validador.errorPanel(ex.getMessage());
					}
				}else if(comboBox.getSelectedItem() == "RAM"){
					limpiarTabla ();
					try {
						llenarTablaProd(Company.getEmpresa().filtrarPorComponente("ram"));
					} catch (NonStock ex) {
						utiles.Validador.errorPanel(ex.getMessage());
					}
				}else if(comboBox.getSelectedItem() == ""){
					limpiarTabla ();
					llenarTabla(Company.getEmpresa().getTienda());
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Precio", "Motherboard", "Microprocesador", "Disco", "RAM"}));
		comboBox.setBounds(408, 62, 271, 34);
		add(comboBox);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBackground(SystemColor.textHighlight);
		btnPagar.setForeground(SystemColor.text);
		btnPagar.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		btnPagar.setBounds(472, 296, 144, 34);
		add(btnPagar);
		
		btnVerCarrito = new JButton("Ver Carrito");
		btnVerCarrito.setForeground(Color.WHITE);
		btnVerCarrito.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		btnVerCarrito.setBackground(SystemColor.textHighlight);
		btnVerCarrito.setBounds(554, 251, 125, 34);
		btnVerCarrito.addActionListener(this);
		add(btnVerCarrito);
		
		btnAnnadir = new JButton("A\u00F1adir");
		btnAnnadir.setForeground(Color.WHITE);
		btnAnnadir.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		btnAnnadir.setBackground(SystemColor.textHighlight);
		btnAnnadir.setBounds(408, 251, 125, 34);
		btnAnnadir.addActionListener(this);
		add(btnAnnadir);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(408, 341, 271, 148);
		add(panel);
		panel.setLayout(null);
		
		lblPrecio = new JLabel("Precio de la compra:");
		lblPrecio.setForeground(SystemColor.text);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(0, 0, 271, 36);
		panel.add(lblPrecio);
		
		lblPrecioSalida = new JLabel("");
		lblPrecioSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioSalida.setForeground(SystemColor.text);
		lblPrecioSalida.setFont(new Font("Roboto Black", Font.PLAIN, 54));
		lblPrecioSalida.setBounds(0, 47, 271, 101);
		panel.add(lblPrecioSalida);
	}

	private void llenarTabla(ArrayList<Tienda> tiendas) {
		
		for(Tienda tienda : tiendas){
			llenarTablaProd(tienda.getProducto());
			}		
	}
	private void llenarTablaProd(ArrayList<Producto> productos){
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
			int seleccion = table.getSelectedRow();			
			if(utiles.Validador.seleccionTabla(seleccion)){
				String producto = table.getValueAt(seleccion, 0).toString();
				String marca	= table.getValueAt(seleccion, 1).toString();
				String modelo	= table.getValueAt(seleccion, 2).toString();
				double precio	= Double.parseDouble(table.getValueAt(seleccion, 3).toString());
				carrito.add(Company.getEmpresa().comprarProducto(producto, marca, modelo, precio));
			}else
				utiles.Validador.errorPanel("No ha seleccionado un elemento de la tabla");
		}else if(btnVerCarrito == e.getSource()){
			if(carrito.size() != 0){
				Carrito mostrar = new Carrito(carrito);
				mostrar.setVisible(true);
			}else
				utiles.Validador.errorPanel("No ha añadido ningun elemento al carrito");
		}
	}
	
}
