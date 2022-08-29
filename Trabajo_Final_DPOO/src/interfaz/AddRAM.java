package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class AddRAM extends JPanel {
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldRAM;
	private JTextField textFieldCapacidad;
	private JTextField textFieldPrecio;
	private JTextField textFieldNombreTienda;

	/**
	 * Create the panel.
	 */
	public AddRAM() {
		setLayout(null);
		
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
		
		JLabel lblTipoRam = new JLabel("Tipo RAM:");
		lblTipoRam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoRam.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblTipoRam.setBounds(10, 95, 98, 31);
		add(lblTipoRam);
		
		textFieldRAM = new JTextField();
		textFieldRAM.setColumns(10);
		textFieldRAM.setBounds(118, 102, 145, 20);
		add(textFieldRAM);
		
		JLabel lblCapacidadgb = new JLabel("Capacidad:\r\n");
		lblCapacidadgb.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacidadgb.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblCapacidadgb.setBounds(10, 137, 98, 31);
		add(lblCapacidadgb);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblPrecio.setBounds(10, 179, 98, 31);
		add(lblPrecio);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setColumns(10);
		textFieldCapacidad.setBounds(118, 144, 145, 20);
		add(textFieldCapacidad);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(118, 186, 145, 20);
		add(textFieldPrecio);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(297, 209, 337, 168);
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
		
		JButton button = new JButton("A\u00F1adir");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(124, 111, 89, 44);
		panel.add(button);
		
		JLabel lblGb = new JLabel("Gb.\r\n");
		lblGb.setHorizontalAlignment(SwingConstants.CENTER);
		lblGb.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblGb.setBounds(266, 137, 31, 31);
		add(lblGb);

	}

}
