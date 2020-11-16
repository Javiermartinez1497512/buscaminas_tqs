package Controlador;

import static org.junit.Assert.*;

import javax.swing.JMenuItem;

import org.junit.Before;
import org.junit.Test;

import Model.Juego;
import Model.Tablero;

public class ControladorJuegoTest {
	Juego juego;
	ControladorJuegoMock controlador;
	//VistaJuego vistaJuego;
	
	@Before
	public void setUp() throws Exception {
		controlador = new ControladorJuegoMock();
	}

	@Test
	public void testNuevoJuego() {
		juego = new Juego();
		ControladorJuego controladorAux = new ControladorJuego();
		// Nivel Facil
		assertEquals(controladorAux.getNivel(),1);
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
		controladorAux.setNivel(2);
		controladorAux.nuevoJuego();
		assertEquals(controladorAux.getNivel(),2);
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
		controladorAux.setNivel(3);
		controladorAux.nuevoJuego();
		assertEquals(controladorAux.getNivel(),3);
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

}
