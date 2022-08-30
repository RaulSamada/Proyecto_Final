package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTable;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logica.Company;
import logica.Producto;

public class Carrito extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JButton btnCancelar;
	private JButton btnQuitar;
	private ArrayList<Producto>lista;
	private JLabel nuevo;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			Carrito dialog = new Carrito();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	 * Create the dialog.
	 */
	public Carrito(ArrayList<Producto> compra,JLabel entrada){
		setType(Type.UTILITY);
		setTitle("CARRITO");
		setBounds(100, 100, 450, 315);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lista = new ArrayList<Producto>();
		
		inicializarComponentes(compra,entrada);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	private void inicializarComponentes(ArrayList<Producto> compra, JLabel entrada){
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 203);
		contentPanel.add(scrollPane);
		
		lista = compra;
		nuevo = entrada;
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Producto");
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Precio");
		llenarTabla(lista);
		scrollPane.setViewportView(table);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(SystemColor.text);
		btnCancelar.setBackground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Roboto Black", Font.PLAIN, 10));
		btnCancelar.setBounds(335, 225, 89, 36);
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);
		
		btnQuitar = new JButton("QUITAR");
		btnQuitar.setForeground(Color.WHITE);
		btnQuitar.setFont(new Font("Roboto Black", Font.PLAIN, 10));
		btnQuitar.setBackground(new Color(220, 20, 60));
		btnQuitar.setBounds(236, 225, 89, 36);
		btnQuitar.addActionListener(this);
		contentPanel.add(btnQuitar);
		
		compra = lista;
		entrada = nuevo;
	}
	
	private void llenarTabla(ArrayList<Producto> compra){
		model.setRowCount(0);
		for(Producto producto : compra){
			Object[] fila = new Object[4];
			fila[0] = producto.getClass().getSimpleName();
			fila[1] = producto.getMarca();
			fila[2] = producto.getModelo();
			fila[3] = producto.getPrecio();
			model.addRow(fila);
		}
	}	
	private void limpiarTabla (){
		model.setRowCount(0);
	}
	public void actionPerformed(ActionEvent e) {
		if(btnCancelar == e.getSource()){
			utiles.Validador.actualizarPrecio(lista, nuevo);
			this.dispose();
		}else if(btnQuitar == e.getSource()){
				int seleccion = table.getSelectedRow();			
				if(utiles.Validador.seleccionTabla(seleccion)){
					lista.remove(seleccion);
					limpiarTabla();
					llenarTabla(lista);

			}
		}
	}
	
	
}
