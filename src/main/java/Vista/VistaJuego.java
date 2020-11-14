package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Controlador.ControladorJuego;
import Model.Juego;
import Model.Tablero;

public class VistaJuego extends JPanel {
	
	private ControladorJuego controladorJuego;
	
	//Varibales interfaz visual
	private JFrame ventana = new JFrame("BUSCAMINAS");
	private JPanel paneltablero;
	private JButton[][] tablero;
	
	public VistaJuego() {}
	
	public void iniciarPartida() {
		//Recuperamos Juego creado en controlador
		Juego juegoActual = controladorJuego.getJuego();
		//Recuperamos Tablero de juego para obtener las dimensiones
		Tablero tableroActual = juegoActual.getTablero();
		
		//Creamos el layout para introducir la matriz con las casillas
	    this.setLayout(new BorderLayout());
	    paneltablero = new JPanel(new GridLayout(tableroActual.getNumFilas(),tableroActual.getNumCols()));
	    this.add(paneltablero);

	    //Creamos la matriz de JButton que nos permetira interacctuar
	    tablero = new JButton[tableroActual.getNumFilas()][tableroActual.getNumCols()];
	    for(int x =0; x<tableroActual.getNumFilas() ; x++){
	      for (int y=0; y<tableroActual.getNumCols(); y++){
	        tablero[x][y] = new JButton();
	        tablero[x][y].setName("Casilla");
	        tablero[x][y].setPreferredSize(new Dimension(32,32));
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
		this.controladorJuego=_controlador;
	}
	public ControladorJuego getControladorJuego() {
		return this.controladorJuego;
	}
}
