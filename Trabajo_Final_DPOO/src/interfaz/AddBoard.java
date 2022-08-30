package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Company;
import logica.MotherBoard;

public class AddBoard extends JPanel implements ActionListener{
	private ArrayList<JTextField>textos;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldSocket;
	private JTextField textFieldRAM;
	private JTextField textFieldConexion;
	private JLabel lblPrecio;
	private JTextField textFieldPrecio;
	private JPanel panel;
	private JLabel lblTienda;
	private JTextField textFieldTienda;
	private JButton btnAñadir;

	/**
	 * Create the panel.
	 */
	public AddBoard() {
		setLayout(null);
		
		textos = new ArrayList<JTextField>();
		
		iniicializarComponenetes();
		

	}
	private void iniicializarComponenetes(){
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblMarca.setBounds(10, 11, 98, 31);
		add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblModelo.setBounds(10, 53, 98, 31);
		add(lblModelo);
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setHorizontalAlignment(SwingConstants.CENTER);
		lblSocket.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblSocket.setBounds(10, 95, 98, 31);
		add(lblSocket);
		
		JLabel lblRAM = new JLabel("RAM:");
		lblRAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblRAM.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblRAM.setBounds(10, 137, 98, 31);
		add(lblRAM);
		
		JLabel lblConexiones = new JLabel("Conexi\u00F3n:");
		lblConexiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConexiones.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblConexiones.setBounds(10, 179, 98, 31);
		add(lblConexiones);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(118, 18, 145, 20);
		add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(118, 60, 145, 20);
		add(textFieldModelo);
		
		textFieldSocket = new JTextField();
		textFieldSocket.setColumns(10);
		textFieldSocket.setBounds(118, 102, 145, 20);
		add(textFieldSocket);
		
		textFieldRAM = new JTextField();
		textFieldRAM.setColumns(10);
		textFieldRAM.setBounds(118, 144, 145, 20);
		add(textFieldRAM);
		
		textFieldConexion = new JTextField();
		textFieldConexion.setColumns(10);
		textFieldConexion.setBounds(118, 186, 145, 20);
		add(textFieldConexion);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblPrecio.setBounds(10, 221, 98, 31);
		add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloNumeros(e);
			}
		});
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(118, 228, 145, 20);
		add(textFieldPrecio);
		
		panel = new JPanel();
		panel.setBounds(297, 42, 337, 168);
		add(panel);
		panel.setLayout(null);
		
		lblTienda = new JLabel("Introduzca el nombre de la Tienda que recibe:");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		lblTienda.setBounds(10, 11, 317, 44);
		panel.add(lblTienda);
		
		textFieldTienda = new JTextField();
		textFieldTienda.setBounds(10, 66, 317, 34);
		panel.add(textFieldTienda);
		textFieldTienda.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setForeground(SystemColor.text);
		btnAñadir.setBackground(SystemColor.textHighlight);
		btnAñadir.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnAñadir.setBounds(124, 111, 89, 44);
		btnAñadir.addActionListener(this);
		panel.add(btnAñadir);
		
		textos.add(textFieldMarca);
		textos.add(textFieldModelo);
		textos.add(textFieldRAM);
		textos.add(textFieldConexion);
		textos.add(textFieldPrecio);
		textos.add(textFieldTienda);
		textos.add(textFieldSocket);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(btnAñadir == e.getSource()){
			if(utiles.Validador.enviar(textos)){
				String marca = textos.get(0).getText();
				String modelo = textos.get(1).getText();
				String ram = textos.get(2).getText();
				String conexion = textos.get(3).getText();
				double precio = Double.parseDouble(textos.get(4).getText());
				String tienda = textos.get(5).getText();
				String socket = textos.get(6).getText();
				
				try {
					MotherBoard producto = new MotherBoard(marca, modelo, precio, socket, ram, conexion);
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
