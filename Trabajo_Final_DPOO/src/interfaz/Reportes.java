package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Reportes extends JPanel {

	/**
	 * Create the panel.
	 */
	public Reportes() {
		setBackground(SystemColor.text);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 11, 670, 589);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblHola = new JLabel("Hola");
		lblHola.setBounds(173, 215, 324, 14);
		panel.add(lblHola);

	}
}
