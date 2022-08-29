package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddComp extends JDialog {

	private JPanel panel;
	private JLabel lblSeleccione;
	private JComboBox comboBox;
	private JPanel panelContenedor;
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			AddComp dialog = new AddComp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 * Create the dialog.
	 */
	
	public AddComp() {
		getContentPane().setBackground(SystemColor.text);
		setResizable(false);
		setBounds(100, 100, 690, 500);
		getContentPane().setLayout(null);
		{
			inicializarComponentes();
		}
		
		setLocationRelativeTo(null);
	}
	private void inicializarComponentes(){
		
		panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 11, 664, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblSeleccione = new JLabel("Seleccione el producto que desea a\u00F1adir:");
		lblSeleccione.setFont(new Font("Roboto Black", Font.PLAIN, 15));
		lblSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccione.setBounds(10, 11, 323, 28);
		panel.add(lblSeleccione);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Motherboard"){
					AddBoard ventana = new AddBoard();
					cambiarPanel(ventana);
				}else if(comboBox.getSelectedItem()=="Microprocesador"){
					AddMicro ventana = new AddMicro();
					cambiarPanel(ventana);
				}else if(comboBox.getSelectedItem()=="RAM"){
					
				}else if(comboBox.getSelectedItem()=="Disco"){
					
				}else if(comboBox.getSelectedItem()==""){
					panel = new JPanel();
					panel.setBackground(SystemColor.text);
					panel.setBounds(10, 50, 644, 388);
					cambiarPanel(panel);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Motherboard", "Microprocesador", "RAM", "Disco"}));
		comboBox.setBounds(343, 16, 214, 20);
		panel.add(comboBox);
		
		panelContenedor = new JPanel();
		panelContenedor.setBackground(SystemColor.text);
		panelContenedor.setBounds(10, 50, 644, 388);
		panel.add(panelContenedor);
		panelContenedor.setLayout(null);
		
	}
	private void cambiarPanel(JPanel ventana){
		ventana.setSize(644, 388);
		ventana.setLocation(0, 0);
		
		panelContenedor.removeAll();
		panelContenedor.add(ventana, BorderLayout.CENTER);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}
}
