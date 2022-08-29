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
import java.awt.SystemColor;

public class AddBoard extends JPanel {
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldSocket;
	private JTable table;
	private JTextField textFieldTienda;
	private JTextField textFieldPrecio;
	private JComboBox comboBoxC;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JButton btnEnviar;
	private JButton btnAddCon;

	/**
	 * Create the panel.
	 */
	public AddBoard() {
		setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblMarca.setBounds(10, 11, 98, 31);
		add(lblMarca);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(118, 11, 169, 31);
		add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblModelo.setBounds(10, 53, 98, 31);
		add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(118, 53, 169, 31);
		add(textFieldModelo);
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setHorizontalAlignment(SwingConstants.CENTER);
		lblSocket.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblSocket.setBounds(10, 95, 98, 31);
		add(lblSocket);
		
		textFieldSocket = new JTextField();
		textFieldSocket.setColumns(10);
		textFieldSocket.setBounds(118, 95, 169, 31);
		add(textFieldSocket);
		
		JLabel lblRAM = new JLabel("RAM:");
		lblRAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblRAM.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblRAM.setBounds(10, 137, 98, 31);
		add(lblRAM);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "DDR", "DDR-2", "DDR-3", "DDR-4"}));
		comboBox.setBounds(118, 137, 169, 31);
		add(comboBox);
		
		JLabel lblConexiones = new JLabel("Conexiones:");
		lblConexiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConexiones.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblConexiones.setBounds(10, 179, 98, 31);
		add(lblConexiones);
		
		comboBoxC = new JComboBox();
		comboBoxC.setModel(new DefaultComboBoxModel(new String[] {"", "IDE", "SATA", "SATA-2", "SATA-3"}));
		comboBoxC.setBounds(118, 179, 169, 31);
		add(comboBoxC);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 40, 287, 204);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblConexAdded = new JLabel("Conexiones A\u00F1adidas:");
		lblConexAdded.setHorizontalAlignment(SwingConstants.CENTER);
		lblConexAdded.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblConexAdded.setBounds(347, 11, 287, 31);
		add(lblConexAdded);
		
		btnAddCon = new JButton("A\u00F1adir");
		btnAddCon.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnAddCon.setBounds(198, 221, 89, 23);
		add(btnAddCon);
		
		JPanel panel = new JPanel();
		panel.setBounds(347, 255, 287, 120);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreTienda = new JLabel("Introduzca el nombre de la Tienda:");
		lblNombreTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTienda.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblNombreTienda.setBounds(10, 11, 267, 26);
		panel.add(lblNombreTienda);
		
		textFieldTienda = new JTextField();
		textFieldTienda.setBounds(10, 48, 267, 26);
		panel.add(textFieldTienda);
		textFieldTienda.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(SystemColor.text);
		btnEnviar.setBackground(SystemColor.textHighlight);
		btnEnviar.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnEnviar.setEnabled(false);
		btnEnviar.setBounds(99, 86, 89, 23);
		panel.add(btnEnviar);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblPrecio.setBounds(10, 344, 98, 31);
		add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(118, 344, 169, 31);
		add(textFieldPrecio);

	}
}
