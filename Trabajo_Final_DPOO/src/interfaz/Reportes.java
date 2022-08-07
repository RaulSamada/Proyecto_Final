package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Reportes extends JPanel  {

	private JPanel panel;
	private JPanel panelReporte1;
	private JPanel panelReporte2;
	private JPanel panelReporte3;
	private JPanel panelReporte4;
	private JLabel lblReporte1;
	private JTextField textField1;
	private JTextField textField2;
	
	/**
	 * Create the panel.
	 */
	public Reportes() {
		setBackground(SystemColor.text);
		setLayout(null);
		
		inicializarComponentes();

	}
	
	private void inicializarComponentes(){
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 670, 589);
		add(panel);
		panel.setLayout(null);
		
		panelReporte1 = new JPanel();
		panelReporte1.setBounds(0, 9, 670, 134);
		panel.add(panelReporte1);
		panelReporte1.setLayout(null);
		
		lblReporte1 = new JLabel("Ingrese el nombre del Producto deseado\r\n");
		lblReporte1.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte1.setBounds(10, 30, 305, 25);
		panelReporte1.add(lblReporte1);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setBounds(10, 66, 305, 33);
		panelReporte1.add(textField1);
		textField1.setColumns(10);
		
		JButton btnRep1 = new JButton("Buscar");
		btnRep1.setEnabled(false);
		btnRep1.setForeground(SystemColor.text);
		btnRep1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep1.setBackground(SystemColor.textHighlight);
		btnRep1.setBounds(325, 66, 89, 33);
		panelReporte1.add(btnRep1);
		
		JLabel lblSalida1 = new JLabel("La tienda con mayor abasto es:");
		lblSalida1.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblSalida1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida1.setBounds(422, 30, 238, 25);
		panelReporte1.add(lblSalida1);
		
		JLabel lblSalidaRep1 = new JLabel("");
		lblSalidaRep1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaRep1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaRep1.setBounds(422, 66, 238, 33);
		panelReporte1.add(lblSalidaRep1);
		
		panelReporte2 = new JPanel();
		panelReporte2.setBounds(0, 154, 670, 134);
		panel.add(panelReporte2);
		panelReporte2.setLayout(null);
		
		JLabel lblReporte2 = new JLabel("Ingrese el nombre del Gerente");
		lblReporte2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte2.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte2.setBounds(10, 30, 305, 25);
		panelReporte2.add(lblReporte2);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setColumns(10);
		textField2.setBounds(10, 66, 305, 33);
		panelReporte2.add(textField2);
		
		JButton btnRep2 = new JButton("Buscar");
		btnRep2.setForeground(SystemColor.text);
		btnRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep2.setEnabled(false);
		btnRep2.setBackground(SystemColor.textHighlight);
		btnRep2.setBounds(325, 66, 89, 33);
		panelReporte2.add(btnRep2);
		
		JLabel lblSalida2 = new JLabel("Informaci\u00F3n del Gerente:");
		lblSalida2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida2.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblSalida2.setBounds(422, 30, 238, 25);
		panelReporte2.add(lblSalida2);
		
		JLabel lblTienda = new JLabel("Tienda:");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblTienda.setBounds(432, 66, 46, 14);
		panelReporte2.add(lblTienda);
		
		JLabel lblSalidaTRep2 = new JLabel("");
		lblSalidaTRep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaTRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaTRep2.setBounds(488, 66, 172, 14);
		panelReporte2.add(lblSalidaTRep2);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesde.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblDesde.setBounds(432, 85, 46, 14);
		panelReporte2.add(lblDesde);
		
		JLabel lblSalidaFRep2 = new JLabel("");
		lblSalidaFRep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaFRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaFRep2.setBounds(488, 85, 172, 14);
		panelReporte2.add(lblSalidaFRep2);
		
		panelReporte3 = new JPanel();
		panelReporte3.setBounds(0, 299, 670, 134);
		panel.add(panelReporte3);
		panelReporte3.setLayout(null);
		
		panelReporte4 = new JPanel();
		panelReporte4.setBounds(0, 444, 670, 134);
		panel.add(panelReporte4);
		panelReporte4.setLayout(null);
		
	}
}
