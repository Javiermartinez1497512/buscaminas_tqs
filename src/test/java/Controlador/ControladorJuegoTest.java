package Controlador;

import static org.junit.Assert.*;

import javax.swing.JMenuItem;

import org.junit.Before;
import org.junit.Test;

import Model.Juego;
import Model.Tablero;
import Vista.VistaJuego;

public class ControladorJuegoTest {
	Juego juego;
	ControladorJuego controlador;
	VistaJuego vistaJuego;
	
	@Before
	public void setUp() throws Exception {
		controlador = new ControladorJuego();
		vistaJuego = new VistaJuego();
		controlador.setVistaJuego(vistaJuego);
		vistaJuego.setControladorJuego(controlador);
		vistaJuego.iniciarPartida();
	}

	@Test
	public void testNuevoJuego() {
		juego = new Juego();
		
		// Nivel Facil
		assertTrue(controlador.getNivel()==1);
		int filas = 9;
		int columnas = 9;
		int minas = 10;
		juego.setNumMinas(minas);
		assertEquals(juego.getNumMinas(),minas);
		juego.iniciarJuego(filas, columnas);
		Tablero tablero1 = juego.getTablero();
		assertEquals(tablero1.getNumFilas(),filas);
		assertEquals(tablero1.getNumCols(),columnas);
		
		// Nivel Medio
		controlador.setNivel(2);
		controlador.nuevoJuego();
		assertTrue(controlador.getNivel()==2);
		filas = 16;
		columnas = 16;
		minas = 40;
		juego.setNumMinas(minas);
		assertEquals(juego.getNumMinas(),minas);
		juego.iniciarJuego(filas, columnas);
		Tablero tablero2 = juego.getTablero();
		assertEquals(tablero2.getNumFilas(),filas);
		assertEquals(tablero2.getNumCols(),columnas);
		
		// Nivel Dificil
		controlador.setNivel(3);
		controlador.nuevoJuego();
		assertTrue(controlador.getNivel()==3);
		filas = 22;
		columnas = 22;
		minas = 99;
		juego.setNumMinas(minas);
		assertEquals(juego.getNumMinas(),minas);
		juego.iniciarJuego(filas, columnas);
		Tablero tablero3 = juego.getTablero();
		assertEquals(tablero3.getNumFilas(),filas);
		assertEquals(tablero3.getNumCols(),columnas);		
	}
	
	@Test
	public void testCrearNivel() {
		JMenuItem menuF = new JMenuItem("Facil");
		controlador.crearNivel(menuF);
		assertEquals(menuF.getText(),"Facil");
		
		JMenuItem menuM = new JMenuItem("Medio");
		controlador.crearNivel(menuM);
		assertEquals(menuM.getText(),"Medio");
		
		JMenuItem menuD = new JMenuItem("Dificil");
		controlador.crearNivel(menuD);
		assertEquals(menuD.getText(),"Dificil");
	}

	/*public void testAccionRealizar() {
		
		ControladorJuegoMock controlMock = new ControladorJuegoMock();
		controlMock.nuevoJuego();
		JuegoMock juegoMock = controlMock.getJuego();
		
		int fila = 0;
		int columna = 0;
		int accion = 1;
		Tablero tablero = juegoMock.getTablero();
		//Acción de abrir casilla
		Casilla casilla = tablero.getCasilla(fila,columna);
		controlMock.accionRealizar(fila, columna, accion);
		assertEquals(casilla.getAbierta(),true);
		
		fila = 5;
		columna = 5;
		accion = 1;
		controlMock.accionRealizar(fila, columna, accion);
		Casilla casilla2 = tablero.getCasilla(fila,columna);
		assertEquals(casilla2.getMarcada(),true);
		controlMock.accionRealizar(fila, columna, accion);
		assertEquals(casilla2.getMarcada(),false);


		
	}*/

}
