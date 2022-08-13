package interfaz;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.TextField;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import utiles.Validador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Company;
import utiles.Validador;

public class Reportes extends JPanel implements ActionListener {

	private JPanel panel;
	///REPORTE 1///
	
	private JPanel panelReporte1;
	private JLabel lblReporte1;
	private JTextField textFieldR1;
	private JButton btnRep1;
	private JLabel lblSalida1;
	private JLabel lblSalidaRep1;	
	
	///REPORTE 2///
	
	private JPanel panelReporte2;
	private JLabel lblReporte2;
	private JTextField textFieldR2;
	private JButton btnRep2;
	private JLabel lblSalida2;
	private JLabel lblTienda;
	private JLabel lblSalidaTRep2;
	private JLabel lblDesde;
	private JLabel lblSalidaFRep2;	
	
	///REPORTE 3///
	
	private JPanel panelReporte3;
	private JTextField textFieldR3;
	private JButton btnRep3;
	
	///REPORTE 4///	
	
	private JPanel panelReporte4;	
	private JLabel lblReporte3;
	private JLabel lblReporte4;	
	private JTextField textFieldR4;	
	private JButton btnRep4;	
	
	/**
	 * Create the panel.
	 */
	
	public Reportes() {
		setBackground(SystemColor.text);
		
		inicializarComponentes();

	}
	
	private void inicializarComponentes(){
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 670, 444);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		
		//////////////////REPORTE 1///////////////////////
		
		panelReporte1 = new JPanel();
		panelReporte1.setBounds(0, 9, 670, 134);
		panel.add(panelReporte1);
		panelReporte1.setLayout(null);
		
		lblReporte1 = new JLabel("Ingrese el nombre del Producto deseado\r\n");
		lblReporte1.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte1.setBounds(10, 30, 305, 25);
		panelReporte1.add(lblReporte1);
		
		textFieldR1 = new JTextField();
		textFieldR1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloLetras(e);
				utiles.Validador.activarBoton(btnRep1, textFieldR1);
			}
		});
		textFieldR1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textFieldR1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR1.setBounds(10, 66, 305, 33);
		panelReporte1.add(textFieldR1);
		textFieldR1.setColumns(10);
		
		btnRep1 = new JButton("Buscar");
		btnRep1.setEnabled(false);
		btnRep1.setForeground(SystemColor.text);
		btnRep1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep1.setBackground(SystemColor.textHighlight);
		btnRep1.setBounds(325, 66, 89, 33);
		btnRep1.addActionListener(this);
		panelReporte1.add(btnRep1);
		
		lblSalida1 = new JLabel("La tienda con mayor abasto es:");
		lblSalida1.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblSalida1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida1.setBounds(422, 30, 238, 25);
		panelReporte1.add(lblSalida1);
		
		lblSalidaRep1 = new JLabel("");
		lblSalidaRep1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaRep1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaRep1.setBounds(422, 66, 238, 33);
		panelReporte1.add(lblSalidaRep1);
		
		//////////////////REPORTE 2///////////////////////
		
		panelReporte2 = new JPanel();
		panelReporte2.setBounds(0, 154, 670, 134);
		panel.add(panelReporte2);
		panelReporte2.setLayout(null);
		
		lblReporte2 = new JLabel("Ingrese el nombre del Gerente");
		lblReporte2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte2.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte2.setBounds(10, 30, 305, 25);
		panelReporte2.add(lblReporte2);
		
		textFieldR2 = new JTextField();
		textFieldR2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloLetras(e);
				utiles.Validador.activarBoton(btnRep2, textFieldR2);
			}
		});
		textFieldR2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textFieldR2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR2.setColumns(10);
		textFieldR2.setBounds(10, 66, 305, 33);
		panelReporte2.add(textFieldR2);
		
		btnRep2 = new JButton("Buscar");
		btnRep2.setForeground(SystemColor.text);
		btnRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep2.setEnabled(false);
		btnRep2.setBackground(SystemColor.textHighlight);
		btnRep2.setBounds(325, 66, 89, 33);
		btnRep2.addActionListener(this);
		panelReporte2.add(btnRep2);
		
		lblSalida2 = new JLabel("Informaci\u00F3n del Gerente:");
		lblSalida2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida2.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblSalida2.setBounds(422, 30, 238, 25);
		panelReporte2.add(lblSalida2);
		
		lblTienda = new JLabel("Tienda:");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblTienda.setBounds(432, 66, 46, 14);
		panelReporte2.add(lblTienda);
		
		lblSalidaTRep2 = new JLabel("");
		lblSalidaTRep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaTRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaTRep2.setBounds(488, 66, 172, 14);
		panelReporte2.add(lblSalidaTRep2);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesde.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblDesde.setBounds(432, 85, 46, 14);
		panelReporte2.add(lblDesde);
		
		lblSalidaFRep2 = new JLabel("");
		lblSalidaFRep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaFRep2.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblSalidaFRep2.setBounds(488, 85, 172, 14);
		panelReporte2.add(lblSalidaFRep2);
		
		//////////////////REPORTE 3///////////////////////
		
		panelReporte3 = new JPanel();
		panelReporte3.setBounds(0, 299, 327, 145);
		panel.add(panelReporte3);
		panelReporte3.setLayout(null);
		
		lblReporte3 = new JLabel("Ingrese el nombre de la tienda");
		lblReporte3.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte3.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte3.setBounds(10, 30, 305, 25);
		panelReporte3.add(lblReporte3);
		
		textFieldR3 = new JTextField();
		textFieldR3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloLetras(e);
				utiles.Validador.activarBoton(btnRep3, textFieldR3);
			}
		});
		textFieldR3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR3.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textFieldR3.setColumns(10);
		textFieldR3.setBounds(10, 66, 305, 33);
		panelReporte3.add(textFieldR3);
		
		btnRep3 = new JButton("Buscar");
		btnRep3.setForeground(Color.WHITE);
		btnRep3.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep3.setEnabled(false);
		btnRep3.setBackground(SystemColor.textHighlight);
		btnRep3.setBounds(115, 110, 95, 33);
		btnRep3.addActionListener(this);
		panelReporte3.add(btnRep3);
		
		//////////////////REPORTE 4///////////////////////
		
		panelReporte4 = new JPanel();
		panelReporte4.setBounds(343, 299, 327, 145);
		panel.add(panelReporte4);
		panelReporte4.setLayout(null);
		
		lblReporte4 = new JLabel("Ingrese la marca del producto deseado");
		lblReporte4.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte4.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblReporte4.setBounds(10, 30, 305, 25);
		panelReporte4.add(lblReporte4);
		
		textFieldR4 = new JTextField();
		textFieldR4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				utiles.Validador.soloLetras(e);
				utiles.Validador.activarBoton(btnRep4, textFieldR4);
			}
		});
		textFieldR4.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR4.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		textFieldR4.setColumns(10);
		textFieldR4.setBounds(10, 66, 305, 33);
		panelReporte4.add(textFieldR4);
		
		btnRep4 = new JButton("Buscar");
		btnRep4.setForeground(Color.WHITE);
		btnRep4.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		btnRep4.setEnabled(false);
		btnRep4.setBackground(SystemColor.textHighlight);
		btnRep4.setBounds(115, 110, 94, 33);
		btnRep4.addActionListener(this);
		panelReporte4.add(btnRep4);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(btnRep1 == e.getSource()){
			if(utiles.Validador.leerProducto(textFieldR1.getText()) != null){
				lblSalidaRep1.setText(Company.getEmpresa().tiendaMasProducto(utiles.Validador.leerProducto(textFieldR1.getText())).getNombreTienda());	
			}else{
				JOptionPane.showMessageDialog(null, "El producto " + textFieldR1.getText() + " no es válido");
			}
		}else if(btnRep2 == e.getSource()){
			
		}else if(btnRep3 == e.getSource()){
			
		}else if(btnRep4 == e.getSource()){}
			
	}
}
