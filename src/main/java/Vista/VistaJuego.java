package Vista;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import Controlador.ControladorJuego;
import Controlador.ControladorMensaje;
import Model.Casilla;
import Model.Juego;
import Model.Tablero;

public class VistaJuego extends JPanel {

	private ControladorJuego controladorJuego;

	// Varibales interfaz visual
	private JFrame ventana = new JFrame("BUSCAMINAS");
	private JPanel paneltablero;
	private JButton[][] tablero;

	public VistaJuego() {
	}

	public void iniciarPartida() {
		// Recuperamos Juego creado en controlador
		Juego juegoActual = controladorJuego.getJuego();
		// Recuperamos Tablero de juego para obtener las dimensiones
		Tablero tableroActual = juegoActual.getTablero();

		// Creamos el layout para introducir la matriz con las casillas
		this.setLayout(new BorderLayout());
		paneltablero = new JPanel(new GridLayout(tableroActual.getNumFilas(), tableroActual.getNumCols()));
		this.add(paneltablero);

		// Creamos la matriz de JButton que nos permetira interacctuar
		tablero = new JButton[tableroActual.getNumFilas()][tableroActual.getNumCols()];
		for (int x = 0; x < tableroActual.getNumFilas(); x++) {
			for (int y = 0; y < tableroActual.getNumCols(); y++) {
				tablero[x][y] = new JButton();
				tablero[x][y].setName("Casilla");
				tablero[x][y].setPreferredSize(new Dimension(32, 32));
				tablero[x][y].addMouseListener((MouseListener) this.getControladorJuego());
				paneltablero.add(tablero[x][y]);
			}
		}

		ventana.setContentPane(this);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
	}

	public void setControladorJuego(ControladorJuego _controlador) {
		this.controladorJuego = _controlador;
	}

	public ControladorJuego getControladorJuego() {
		return this.controladorJuego;
	}

	public void actualizarVistaTablero() {
		Juego juegoActual = controladorJuego.getJuego();
		Tablero tableroActual = juegoActual.getTablero();
	
		for (int x = 0; x < tableroActual.getNumFilas(); x++) {
			for (int y = 0; y < tableroActual.getNumCols(); y++) {
				Casilla _casilla = tableroActual.getCasilla(y, x);
				// Reset de la casilla
				tablero[x][y].setBackground(new JButton().getBackground());
				tablero[x][y].setText("");
				tablero[x][y].setFont(new Font("Tahoma", Font.BOLD, 14));
				tablero[x][y].setMargin(new Insets(0, 0, 0, 0));

				if (!_casilla.getAbierta()) {
					if (_casilla.getMarcada()) {
						tablero[x][y].setBackground(new java.awt.Color(96, 150, 244));
						tablero[x][y].setText("?");
					}
				} else {
					if (_casilla.getMina()) {
						tablero[x][y].setBackground(new java.awt.Color(245, 90, 59));
						tablero[x][y].setText("X");

					} else {
						tablero[x][y].setBackground(new java.awt.Color(152, 214, 87));
						if(_casilla.getMinasVecinas()!= 0) {
							tablero[x][y].setText(""+_casilla.getMinasVecinas());
						}

					}
				}
			}
		}
		
		if (juegoActual.getMinasAbiertas()) {
			VistaMensaje alerta = new VistaMensaje(ventana, this, "Has perdido!");
			ControladorMensaje controlador = new ControladorMensaje(this,alerta);
			alerta.setController(controlador);
			alerta.mostrar();
			alerta.addWindowListener(controlador);
			alerta.pack();
			alerta.setVisible(true);
		}else if(juegoActual.getVictoria()) {
			VistaMensaje alerta = new VistaMensaje(ventana, this, "Has Ganado!");
			ControladorMensaje controlador = new ControladorMensaje(this,alerta);
			alerta.setController(controlador);
			alerta.mostrar();
			alerta.addWindowListener(controlador);
			alerta.pack();
			alerta.setVisible(true);
		} 
		
	}

	public void resetTablero() {
		controladorJuego.nuevoJuego();
		this.remove(paneltablero);
		this.revalidate();
		this.repaint();
	}
}
