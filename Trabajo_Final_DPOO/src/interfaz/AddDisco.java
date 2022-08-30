package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import logica.Company;
import logica.Disco;
import logica.RAM;

public class AddDisco extends JPanel implements ActionListener {
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldConexion;
	private JTextField textFieldCapacidad;
	private JTextField textFieldPrecio;
	private JTextField textFieldNombreTienda;
	private JButton btnAñadir;
	private ArrayList<JTextField>textos;

	/**
	 * Create the panel.
	 */
	public AddDisco() {
		setLayout(null);
		
		inicializarComponentes();

	}
	private void inicializarComponentes(){
		
		textos = new ArrayList<JTextField>();
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblMarca.setBounds(10, 11, 98, 31);
		add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(118, 18, 145, 20);
		add(textFieldMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblModelo.setBounds(10, 53, 98, 31);
		add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(118, 60, 145, 20);
		add(textFieldModelo);
		
		JLabel lblConexion = new JLabel("Conexi\u00F3n:");
		lblConexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConexion.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblConexion.setBounds(10, 95, 98, 31);
		add(lblConexion);
		
		textFieldConexion = new JTextField();
		textFieldConexion.setColumns(10);
		textFieldConexion.setBounds(118, 102, 145, 20);
		add(textFieldConexion);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacidad.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblCapacidad.setBounds(10, 137, 98, 31);
		add(lblCapacidad);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloNumeros(e);
			}
		});
		textFieldCapacidad.setColumns(10);
		textFieldCapacidad.setBounds(118, 144, 145, 20);
		add(textFieldCapacidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblPrecio.setBounds(10, 179, 98, 31);
		add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloNumeros(e);
			}
		});
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(118, 186, 145, 20);
		add(textFieldPrecio);
		
		JLabel label = new JLabel("Gb.\r\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		label.setBounds(273, 137, 31, 31);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(297, 209, 337, 168);
		add(panel);
		
		JLabel label_1 = new JLabel("Introduzca el nombre de la Tienda que recibe:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		label_1.setBounds(10, 11, 317, 44);
		panel.add(label_1);
		
		textFieldNombreTienda = new JTextField();
		textFieldNombreTienda.setColumns(10);
		textFieldNombreTienda.setBounds(10, 66, 317, 34);
		panel.add(textFieldNombreTienda);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setForeground(Color.WHITE);
		btnAñadir.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnAñadir.setBackground(SystemColor.textHighlight);
		btnAñadir.setBounds(124, 111, 89, 44);
		btnAñadir.addActionListener(this);
		panel.add(btnAñadir);
		
		textos.add(textFieldMarca);
		textos.add(textFieldModelo);
		textos.add(textFieldConexion);
		textos.add(textFieldCapacidad);
		textos.add(textFieldPrecio);
		textos.add(textFieldNombreTienda);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(btnAñadir == e.getSource()){
			if(utiles.Validador.enviar(textos)){
				String marca = textos.get(0).getText();
				String modelo = textos.get(1).getText();
				String conexion = textos.get(2).getText();
				double capacidad = Double.parseDouble(textos.get(3).getText());
				double precio = Double.parseDouble(textos.get(4).getText());
				String tienda = textos.get(5).getText();
					
				try {
					Disco producto = new Disco(marca, modelo, precio, capacidad, conexion);
					Company.getEmpresa().getTienda(tienda).addProducto(producto);
					utiles.Validador.successPanel("Producto añadido correctamente");
					limpiarEdit();
				} catch (Exception e1) {
					utiles.Validador.errorPanel(e1.getMessage());
				}
				
			}else
				utiles.Validador.errorPanel("Faltan campos por llenar");
		}
		
	}
	private void limpiarEdit(){
		for(JTextField txt : textos){
			txt.setText("");
		}
	}
}
