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

import Controlador.ControladorMensaje;

public class VistaMensaje extends JDialog {
	private JLabel txtMensaje;
	private JButton bAcceptar;
	private VistaJuego _vistaparent;
	private String mensaje;

	private ControladorMensaje controlador;

	public VistaMensaje(JFrame frame, VistaJuego _vista, String _mensajeAlerta) {
		super(frame);
		_vistaparent = _vista;
		mensaje = _mensajeAlerta;
	}

	public void mostrar() {
		this.setModal(true);
		this.setTitle("Alerta");
		this.setLayout(new BorderLayout(10, 10));

		bAcceptar = new JButton(this.mensaje);
		bAcceptar.addMouseListener(this.controlador);
		this.add("South", bAcceptar);
	}

	public void setController(ControladorMensaje _controlador) {
		controlador = _controlador;
	}

}
