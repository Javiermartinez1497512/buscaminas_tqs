package Controlador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Juego;
import Model.Tablero;

public class ControladorJuegoTest {
	Juego juego;
	ControladorJuego controlador;
	
	@Before
	public void setUp() throws Exception {
		controlador = new ControladorJuego();
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


}
