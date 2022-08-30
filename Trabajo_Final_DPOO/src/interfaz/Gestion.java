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
		panelAbastecer.setBounds(10, 189, 669, 130);
		add(panelAbastecer);
		panelAbastecer.setLayout(null);
		
		lblAbastecer = new JLabel("A\u00F1adir nuevos Componentes :");
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
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(btnAddComp == e.getSource()){
			AddComp ventana = new AddComp();
			ventana.setVisible(true);
		}
		
	}
	
}
