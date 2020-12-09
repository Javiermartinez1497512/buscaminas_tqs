package Buscaminas;


import Controlador.ControladorJuegoMock3;
import Controlador.ControladorJuegoMock4;
import Model.JuegoMock3;
import Model.JuegoMock4;
import Model.Tablero;
import Vista.VistaJuego;

public class Main4 {

	public static void main(String[] args) {
		//Creamos la vista principal VistaJuego
	    VistaJuego vistaJuego = new VistaJuego();
	    //Creamos el controlador del Juego
	    ControladorJuegoMock4 controladorJuego = new ControladorJuegoMock4();
	    
	   
	    
	   
	    controladorJuego.nuevoJuego();
	    JuegoMock4 juego = controladorJuego.getJuego();
	    juego.iniciarJuegoConMinas(32, 32);
	    Tablero tablero = juego.getTablero();
	    
	    System.out.println(tablero.getCasilla(0, 0).getMina());
	    
	    
	    //Iniciamos partida
	    
	    vistaJuego.setControladorJuego(controladorJuego);
	    controladorJuego.setVistaJuego(vistaJuego);
	    vistaJuego.iniciarPartida();
	}

}
