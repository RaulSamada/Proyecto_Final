package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.Producto;

public class Recibo extends JDialog {
	private JTable table;
	private DefaultTableModel model;
	private JPanel panel;
	private JLabel lblGracias;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Recibo dialog = new Recibo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	 * Create the dialog.
	 */
	public Recibo(ArrayList<Producto>carrito) {
		setType(Type.UTILITY);
		setTitle("RECIBO");
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		inicializarComponentes(carrito);
		setLocationRelativeTo(null);
		
	}
	private void inicializarComponentes(ArrayList<Producto>carrito){
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 424, 239);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblGracias = new JLabel("Gracias por su compra");
		lblGracias.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		lblGracias.setHorizontalAlignment(SwingConstants.CENTER);
		lblGracias.setBounds(10, 11, 404, 43);
		panel.add(lblGracias);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 404, 165);
		panel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Producto");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Precio");
		llenarTabla(carrito);
		scrollPane.setViewportView(table);
	}
	private void llenarTabla(ArrayList<Producto> carrito) {
		model.setRowCount(0);
		for(Producto producto : carrito){
			Object[] fila = new Object[4];
			fila[0] = producto.getClass().getSimpleName();
			fila[1] = producto.getMarca();
			fila[2] = producto.getModelo();
			fila[3] = producto.getPrecio();
			model.addRow(fila);
		}
	}
}
