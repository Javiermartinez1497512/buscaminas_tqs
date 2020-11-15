package Vista;

import static java.lang.Integer.parseInt;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VistaMensaje extends JDialog {
	private JLabel txtMensaje;
	private JButton bAcceptar;
	private VistaJuego _vistaparent;
	private String mensaje;

	public VistaMensaje(JFrame frame, VistaJuego _vista, String _mensajeAlerta) {
		super(frame);
		_vistaparent = _vista;
		mensaje = _mensajeAlerta;
		mostrar();
	}

	private void mostrar() {
		this.setModal(true);
		this.setTitle("Alerta");
		this.setLayout(new BorderLayout(10, 10));

		JPanel panelDif = new JPanel(new GridLayout(1, 1, 100, 100));
		bAcceptar = new JButton(this.mensaje);
		this.add("South", bAcceptar);
	}

	private void sendData() {
		this.setVisible(false);
		dispose();
	}

}
