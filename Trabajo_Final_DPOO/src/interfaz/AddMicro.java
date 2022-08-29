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
import logica.Micro;
import logica.MotherBoard;

public class AddMicro extends JPanel implements ActionListener {
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldSocket;
	private JTextField textFieldNombreTienda;
	private JTextField textFieldVelocidad;
	private JButton btnAñadir;
	private ArrayList<JTextField>textos;
	private JTextField textFieldPrecio;

	/**
	 * Create the panel.
	 */
	public AddMicro() {
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
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setHorizontalAlignment(SwingConstants.CENTER);
		lblSocket.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblSocket.setBounds(10, 95, 98, 31);
		add(lblSocket);
		
		textFieldSocket = new JTextField();
		textFieldSocket.setColumns(10);
		textFieldSocket.setBounds(118, 102, 145, 20);
		add(textFieldSocket);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(297, 11, 337, 168);
		add(panel);
		
		JLabel lblNombreTienda = new JLabel("Introduzca el nombre de la Tienda que recibe:");
		lblNombreTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTienda.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		lblNombreTienda.setBounds(10, 11, 317, 44);
		panel.add(lblNombreTienda);
		
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
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblVelocidad.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblVelocidad.setBounds(10, 137, 98, 31);
		add(lblVelocidad);
		
		textFieldVelocidad = new JTextField();
		textFieldVelocidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloNumeros(e);
			}
		});
		textFieldVelocidad.setColumns(10);
		textFieldVelocidad.setBounds(118, 144, 145, 20);
		add(textFieldVelocidad);
		
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
		
		textos.add(textFieldMarca);
		textos.add(textFieldModelo);
		textos.add(textFieldSocket);
		textos.add(textFieldVelocidad);
		textos.add(textFieldPrecio);
		textos.add(textFieldNombreTienda);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(btnAñadir == e.getSource()){
			if(utiles.Validador.enviar(textos)){
				String marca = textos.get(0).getText();
				String modelo = textos.get(1).getText();
				String socket = textos.get(2).getText();
				double velocidad = Double.parseDouble(textos.get(3).getText());
				double precio = Double.parseDouble(textos.get(4).getText());
				String tienda = textos.get(5).getText();
					
				try {
					Micro producto = new Micro(marca, modelo, precio, socket, velocidad);
					Company.getEmpresa().getTienda(tienda).addProducto(producto);
				} catch (Exception e1) {
					utiles.Validador.errorPanel(e1.getMessage());
				}
				
			}else
				utiles.Validador.errorPanel("Faltan campos por llenar");
		}
		
	}

}
