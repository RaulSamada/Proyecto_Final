package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal extends JFrame implements ActionListener {

	private JPanel PanelPrincipal;
	private JPanel panelVentanas;
	private JPanel panelBotones;
	private JPanel panelTitulo;
	private JButton btnComprarComponenes;
	private JButton btnArmarPc;
	private JButton btnGestion;
	private JButton btnReportes;
	private JLabel lblTitulo;
	

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	
	
	public Principal() {
		
		
		setTitle("PRINCIPAL");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarComponentes();
		setLocationRelativeTo(null);
		setResizable(false);
			
	}
	
	public void inicializarComponentes (){
		
		setBounds(100, 100, 950, 650);
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBackground(Color.WHITE);
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		panelVentanas = new JPanel();
		panelVentanas.setBackground(Color.WHITE);
		panelVentanas.setBounds(245, 111, 689, 500);
		PanelPrincipal.add(panelVentanas);
		panelVentanas.setLayout(null);
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(SystemColor.textHighlight);
		panelTitulo.setBounds(255, 0, 669, 100);
		PanelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		lblTitulo = new JLabel("");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 649, 78);
		panelTitulo.add(lblTitulo);
		
		panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.textHighlight);
		panelBotones.setBounds(0, 0, 245, 611);
		PanelPrincipal.add(panelBotones);
		panelBotones.setLayout(null);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setForeground(SystemColor.text);
		btnReportes.setBackground(SystemColor.textHighlight);
		btnReportes.setBounds(0, 48, 244, 44);
		btnReportes.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnReportes.addActionListener(this);
		panelBotones.add(btnReportes);
		
		btnGestion = new JButton("Gesti\u00F3n");
		btnGestion.setForeground(SystemColor.text);
		btnGestion.setBackground(SystemColor.textHighlight);
		btnGestion.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnGestion.setBounds(0, 103, 244, 44);
		btnGestion.addActionListener(this);
		panelBotones.add(btnGestion);
		
		btnArmarPc = new JButton("Armar PC");
		btnArmarPc.setForeground(SystemColor.text);
		btnArmarPc.setBackground(SystemColor.textHighlight);
		btnArmarPc.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnArmarPc.setBounds(0, 158, 244, 44);
		btnArmarPc.addActionListener(this);
		panelBotones.add(btnArmarPc);
		
		btnComprarComponenes = new JButton("Comprar Componenes\r\n");
		btnComprarComponenes.setForeground(SystemColor.text);
		btnComprarComponenes.setBackground(SystemColor.textHighlight);
		btnComprarComponenes.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		btnComprarComponenes.setBounds(0, 213, 244, 44);
		btnComprarComponenes.addActionListener(this);
		panelBotones.add(btnComprarComponenes);
		
				
		
	}
 

	public void actionPerformed(ActionEvent e) {
		JPanel ventana;
		String titulo;
		
		if(btnReportes == e.getSource()){
			ventana = new Reportes ();
			titulo = "REPORTES";
			cambiarContenido(ventana, titulo);
		}else if(btnGestion == e.getSource()){
			
		}else if(btnArmarPc == e.getSource()){
			ventana = new ArmarPC();
			titulo = "ARMAR PC";
			cambiarContenido(ventana, titulo);
		}else if(btnComprarComponenes == e.getSource()){
			ventana = new ComprarComp();
			titulo = "COMPRAR COMPONENTES";
			cambiarContenido(ventana, titulo);
		}
			
	}
	
	private void cambiarContenido(JPanel ventana, String titulo){
		lblTitulo.setText(titulo);
		
		ventana.setSize(689, 500);
		ventana.setLocation(0, 0);
		
		panelVentanas.removeAll();
		panelVentanas.add(ventana, BorderLayout.CENTER);
		panelVentanas.revalidate();
		panelVentanas.repaint();
	}
}
