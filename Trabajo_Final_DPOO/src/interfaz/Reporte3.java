package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Trabajador;

import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Reporte3 extends JDialog {
	
	private JScrollPane cont ;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			Reporte3 dialog = new Reporte3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Reporte3(ArrayList<Trabajador> array) {
		setType(Type.UTILITY);
		setTitle("Reporte 3");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		inicializarComponentes(array);
		setLocationRelativeTo(null);
		setResizable(false);		
	}
	
	private void inicializarComponentes(ArrayList<Trabajador> array){
		cont= new JScrollPane();
		cont.setBounds(10, 11, 424, 212);
		getContentPane().add(cont);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("No.");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Cargo");
		llenarTabla(array);
		cont.setViewportView(table);
		setBounds(100, 100, 450, 300);
	}
	
	private void llenarTabla(ArrayList<Trabajador> array){
		model.setRowCount(0);
		for(Trabajador trabajador : array){
			Object[] fila = new Object[4];
			fila[0] = trabajador.getID();
			fila[1] = trabajador.getNombre();
			fila[2] = trabajador.getApellidoP();
			fila[3] = trabajador.getCargo();
			model.addRow(fila);
		}
	}
}
