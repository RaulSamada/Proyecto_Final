package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.Trabajador;

public class Reporte4 extends JDialog {
	private JScrollPane cont ;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			Reporte4 dialog = new Reporte4();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Reporte4(ArrayList<ArrayList<String>> array) {
		setType(Type.UTILITY);
		setTitle("Reporte 4");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		inicializarComponentes(array);
		setLocationRelativeTo(null);
		setResizable(false);	
	}
	private void inicializarComponentes(ArrayList<ArrayList<String>> array){
		cont= new JScrollPane();
		cont.setBounds(10, 11, 424, 212);
		getContentPane().add(cont);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Tienda");
		model.addColumn("Producto");
		model.addColumn("Modelo");
		llenarTabla(array);
		cont.setViewportView(table);
		setBounds(100, 100, 450, 300);
	}
	private void llenarTabla(ArrayList<ArrayList<String>> array){
		model.setRowCount(0);
		for(int i = 0; i < array.size();i++){
			for(int n = 1; n < array.get(i).size(); n+=2){
				Object[] fila = new Object[3];
				fila[0] = array.get(i).get(0);
				fila[1] = array.get(i).get(n);
				fila[2] = array.get(i).get(n+1);
				model.addRow(fila);
			}
		}
	}
}
