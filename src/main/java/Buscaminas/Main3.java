package Buscaminas;


import Controlador.ControladorJuegoMock3;
import Model.JuegoMock3;
import Model.Tablero;
import Vista.VistaJuego;

public class Main3 {

	public static void main(String[] args) {
		//Creamos la vista principal VistaJuego
	    VistaJuego vistaJuego = new VistaJuego();
	    //Creamos el controlador del Juego
	    ControladorJuegoMock3 controladorJuego = new ControladorJuegoMock3();
	    
	   
	    
	   
	    controladorJuego.nuevoJuego();
	    JuegoMock3 juego = controladorJuego.getJuego();
	    juego.iniciarJuegoConMinas(16	    		, 16);
	    Tablero tablero = juego.getTablero();
	    
	    System.out.println(tablero.getCasilla(0, 0).getMina());
	    
	    
	    //Iniciamos partida
	    
	    vistaJuego.setControladorJuego(controladorJuego);
	    controladorJuego.setVistaJuego(vistaJuego);
	    vistaJuego.iniciarPartida();
	}

}
