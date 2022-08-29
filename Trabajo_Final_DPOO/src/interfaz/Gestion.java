package interfaz;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Gestion extends JPanel implements ActionListener{
	
	private JPanel panelAbastecer;
	private JLabel lblAbastecer;
	private JButton btnAddComp;
	private JPanel panelContratar;
	private JLabel lblContratar;
	private JButton btnContratar;
	private JPanel panelAddTienda;
	private JLabel lblAddTienda;
	private JButton btnAddTienda;
	

	/**
	 * Create the panel.
	 */
	public Gestion() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		inicializarComponentes();

	}
	
	private void inicializarComponentes(){
		
		panelAbastecer = new JPanel();
		panelAbastecer.setBackground(SystemColor.windowBorder);
		panelAbastecer.setBounds(10, 11, 669, 130);
		add(panelAbastecer);
		panelAbastecer.setLayout(null);
		
		lblAbastecer = new JLabel("Para a\u00F1adir nuevos Componentes :");
		lblAbastecer.setForeground(SystemColor.text);
		lblAbastecer.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblAbastecer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbastecer.setBounds(10, 11, 401, 108);
		panelAbastecer.add(lblAbastecer);
		
		btnAddComp = new JButton("A\u00F1adir");
		btnAddComp.setBackground(SystemColor.textHighlight);
		btnAddComp.setForeground(SystemColor.text);
		btnAddComp.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnAddComp.setBounds(421, 41, 143, 51);
		btnAddComp.addActionListener(this);
		panelAbastecer.add(btnAddComp);
		
		panelContratar = new JPanel();
		panelContratar.setBackground(SystemColor.textInactiveText);
		panelContratar.setBounds(10, 188, 669, 130);
		add(panelContratar);
		panelContratar.setLayout(null);
		
		lblContratar = new JLabel("Para contratar Personal:");
		lblContratar.setHorizontalAlignment(SwingConstants.CENTER);
		lblContratar.setForeground(Color.WHITE);
		lblContratar.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblContratar.setBounds(10, 11, 401, 108);
		panelContratar.add(lblContratar);
		
		btnContratar = new JButton("Contratar");
		btnContratar.setForeground(Color.WHITE);
		btnContratar.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnContratar.setBackground(SystemColor.textHighlight);
		btnContratar.setBounds(421, 37, 143, 51);
		btnContratar.addActionListener(this);
		panelContratar.add(btnContratar);
		
		panelAddTienda = new JPanel();
		panelAddTienda.setBackground(SystemColor.textInactiveText);
		panelAddTienda.setBounds(10, 360, 669, 130);
		add(panelAddTienda);
		panelAddTienda.setLayout(null);
		
		lblAddTienda = new JLabel("Para a\u00F1adir una tienda a la empresa:");
		lblAddTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTienda.setForeground(Color.WHITE);
		lblAddTienda.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblAddTienda.setBounds(10, 11, 401, 108);
		panelAddTienda.add(lblAddTienda);
		
		btnAddTienda = new JButton("A\u00F1adir");
		btnAddTienda.setForeground(Color.WHITE);
		btnAddTienda.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnAddTienda.setBackground(SystemColor.textHighlight);
		btnAddTienda.setBounds(421, 38, 143, 51);
		btnAddTienda.addActionListener(this);
		panelAddTienda.add(btnAddTienda);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(btnAddComp == e.getSource()){
			AddComp ventana = new AddComp();
			ventana.setVisible(true);
		}else if(btnContratar == e.getSource()){
			
		}else if(btnAddTienda == e.getSource()){
			
		}
		
	}
	
}
