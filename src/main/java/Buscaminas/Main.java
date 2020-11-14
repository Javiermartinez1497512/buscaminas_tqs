package Buscaminas;

import Controlador.ControladorJuego;
import Vista.VistaJuego;

public class Main {

	public static void main(String[] args) {
		//Creamos la vista principal VistaJuego
	    VistaJuego vistaJuego = new VistaJuego();
	    //Creamos el controlador del Juego
	    ControladorJuego controladorJuego = new ControladorJuego();
	    
	    //Vinculamos la vista con el controlador y controlador con vista
	    vistaJuego.setControladorJuego(controladorJuego);
	    controladorJuego.setVistaJuego(vistaJuego);

	    //Iniciamos partida
	    vistaJuego.iniciarPartida();
	}

}
