package Buscaminas;


import Controlador.ControladorJuegoMock2;
import Model.JuegoMock;
import Model.JuegoMock2;
import Model.Tablero;
import Vista.VistaJuego;

public class Main2 {

	public static void main(String[] args) {
		//Creamos la vista principal VistaJuego
	    VistaJuego vistaJuego = new VistaJuego();
	    //Creamos el controlador del Juego
	    ControladorJuegoMock2 controladorJuego = new ControladorJuegoMock2();
	    
	   
	    
	   
	    controladorJuego.nuevoJuego();
	    JuegoMock2 juego = controladorJuego.getJuego();
	    juego.iniciarJuegoConMinas(9, 9);
	    Tablero tablero = juego.getTablero();
	    
	    System.out.println(tablero.getCasilla(0, 0).getMina());
	    
	    
	    //Iniciamos partida
	    
	    vistaJuego.setControladorJuego(controladorJuego);
	    controladorJuego.setVistaJuego(vistaJuego);
	    vistaJuego.iniciarPartida();
	}

}
