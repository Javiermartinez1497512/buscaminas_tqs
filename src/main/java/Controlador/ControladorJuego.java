package Controlador;

import Model.Juego;
import Vista.VistaJuego;

public class ControladorJuego {
	
	private VistaJuego vistaJuego;
	private Juego juego;
	
	public ControladorJuego() {
		this.juego =  new Juego();
		//Iniciamos el juego con los valores por defecto 9x9 10minas
		juego.iniciarJuego(9, 9); 
	}
	
	public void setVistaJuego(VistaJuego _vista) {
		this.vistaJuego=_vista;
	}
	
	public Juego getJuego() {
		return this.juego;
	}

}
