package Model;

import static org.junit.Assert.*;

import javax.swing.JMenuItem;

import org.junit.Test;

import Controlador.ControladorJuegoMock;

public class Escenarios {
	
	/* ESCENARIO 1 - Crear partida con nivel fácil */
	@Test
	public void escenario1() {
		ControladorJuegoMock controlador = new ControladorJuegoMock();
		JMenuItem menu = new JMenuItem("Facil");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),1);	
		
		controlador.setNivel(0);
		
		menu = new JMenuItem("facil");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),1);	
	}
	
	/* ESCENARIO 2 - Crear partida con nivel Medio */
	@Test
	public void escenario2() {
		ControladorJuegoMock controlador = new ControladorJuegoMock();
		JMenuItem menu = new JMenuItem("Medio");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),2);
		
		controlador.setNivel(0);
		
		menu = new JMenuItem("medio");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),2);	
	}
	
	/* ESCENARIO 3 - Crear partida con nivel dificil */
	@Test
	public void escenario3() {
		ControladorJuegoMock controlador = new ControladorJuegoMock();
		JMenuItem menu = new JMenuItem("Dificil");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),3);	
		
		controlador.setNivel(0);
		
		menu = new JMenuItem("dificil");
		controlador.crearNivel(menu);
		assertEquals(controlador.getNivel(),3);	
	}
	
	
	/* ESCENARIO 4 - MARCAR UNA CASILLA */
	@Test
	public void escenario4() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		//Caso 1 - Marcamos casilla cerrada y dentro del rango del tablero.
		tablero.marcarCasilla(1, 1);
		assertTrue(tablero.getCasilla(1, 1).getMarcada());
		
		//Caso 2 - Marcar casilla abierta.
		tablero.abrirCasilla(2, 2);
		tablero.marcarCasilla(2, 2);
		assertFalse(tablero.getCasilla(2, 2).getMarcada());
		
		//Caso 3 - Marcar casilla ya marcada.
		tablero.marcarCasilla(3, 3);
		tablero.marcarCasilla(3, 3);
		assertTrue(tablero.getCasilla(3, 3).getMarcada());
		
		//Caso 4 - Marcar casilla fuera del rango del tablero.
		tablero.marcarCasilla(10, 10);
		assertFalse(tablero.getCasilla(10, 10).getMarcada());
	}
	
	/* ESCENARIO 2 - ABRIR UNA CASILLA */
	@Test
	public void escenario5() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		//Caso 1 - Abrir casilla cerrada y que se encuentre dentro del rango del tablero.
		tablero.abrirCasilla(1, 1);
		assertTrue(tablero.getCasilla(1, 1).getAbierta());
		
		//Caso 2 - Abrir casilla ya abierta.
		tablero.abrirCasilla(2, 2);
		tablero.abrirCasilla(2, 2);
		assertTrue(tablero.getCasilla(2, 2).getAbierta());
		
		//Caso 3 - Abrir casilla marcada.
		tablero.marcarCasilla(3, 3);
		tablero.abrirCasilla(3, 3);
		assertFalse(tablero.getCasilla(3, 3).getAbierta());
		
		//Caso 4 - Abrir casilla fuera del rango del tablero.
		tablero.abrirCasilla(10, 10);
		assertFalse(tablero.getCasilla(10, 10).getAbierta());
	}
	
	
	/* ESCENARIO 6 - Ganar la partida abriendo las casillas*/
	@Test
	public void Escenario6() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		juegoMock.iniciarJuego(9, 9);
		Tablero tablero = juegoMock.getTablero();
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		juegoMock.actualizarVictoria();
		assertFalse(juegoMock.getVictoria());
		
		tablero.abrirCasilla(0, 2);
		tablero.abrirCasilla(0, 3);
		tablero.abrirCasilla(0, 4);
		tablero.abrirCasilla(0, 5);
		tablero.abrirCasilla(0, 6);
		tablero.abrirCasilla(0, 7);
		tablero.abrirCasilla(0, 8);
		
		tablero.abrirCasilla(1, 0);
		tablero.abrirCasilla(1, 1);
		tablero.abrirCasilla(1, 3);
		tablero.abrirCasilla(1, 4);
		tablero.abrirCasilla(1, 5);
		tablero.abrirCasilla(1, 6);
		tablero.abrirCasilla(1, 7);
		tablero.abrirCasilla(1, 8);

		tablero.abrirCasilla(2, 0);
		tablero.abrirCasilla(2, 1);
		tablero.abrirCasilla(2, 2);
		tablero.abrirCasilla(2, 4);
		tablero.abrirCasilla(2, 5);
		tablero.abrirCasilla(2, 6);
		tablero.abrirCasilla(2, 7);
		tablero.abrirCasilla(2, 8);
		
		tablero.abrirCasilla(3, 0);
		tablero.abrirCasilla(3, 1);
		tablero.abrirCasilla(3, 2);
		tablero.abrirCasilla(3, 3);
		tablero.abrirCasilla(3, 4);
		tablero.abrirCasilla(3, 6);
		tablero.abrirCasilla(3, 7);
		tablero.abrirCasilla(3, 8);
		
		tablero.abrirCasilla(4, 0);
		tablero.abrirCasilla(4, 1);
		tablero.abrirCasilla(4, 2);
		tablero.abrirCasilla(4, 3);
		tablero.abrirCasilla(4, 5);
		tablero.abrirCasilla(4, 6);
		tablero.abrirCasilla(4, 7);
		tablero.abrirCasilla(4, 8);
		
		tablero.abrirCasilla(5, 0);
		tablero.abrirCasilla(5, 1);
		tablero.abrirCasilla(5, 2);
		tablero.abrirCasilla(5, 3);
		tablero.abrirCasilla(5, 4);
		tablero.abrirCasilla(5, 5);
		tablero.abrirCasilla(5, 6);
		tablero.abrirCasilla(5, 7);
		tablero.abrirCasilla(5, 8);
		
		juegoMock.actualizarVictoria();
		assertFalse(juegoMock.getVictoria());
		
		tablero.abrirCasilla(6, 0);
		tablero.abrirCasilla(6, 1);
		tablero.abrirCasilla(6, 2);
		tablero.abrirCasilla(6, 3);
		tablero.abrirCasilla(6, 5);
		tablero.abrirCasilla(6, 6);
		tablero.abrirCasilla(6, 8);
		
		tablero.abrirCasilla(7, 0);
		tablero.abrirCasilla(7, 1);
		tablero.abrirCasilla(7, 2);
		tablero.abrirCasilla(7, 3);
		tablero.abrirCasilla(7, 4);
		tablero.abrirCasilla(7, 5);
		tablero.abrirCasilla(7, 6);
		tablero.abrirCasilla(7, 8);
		
		tablero.abrirCasilla(8, 0);
		tablero.abrirCasilla(8, 1);
		tablero.abrirCasilla(8, 2);
		tablero.abrirCasilla(8, 3);
		tablero.abrirCasilla(8, 4);
		tablero.abrirCasilla(8, 5);
		tablero.abrirCasilla(8, 6);
		tablero.abrirCasilla(8, 7);
		
		juegoMock.actualizarVictoria();
		assertTrue(juegoMock.getVictoria());
	}
	
	/* ESCENARIO 7 - Ganar la partida marcando las casillas con mina */
	@Test
	public void escenario7() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		juegoMock.iniciarJuego(9, 9);
		Tablero tablero = juegoMock.getTablero();
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		juegoMock.actualizarVictoria();
		assertFalse(juegoMock.getVictoria());
		
		tablero.marcarCasilla(0, 0);
		tablero.marcarCasilla(0, 1);
		tablero.marcarCasilla(1, 2);
		tablero.marcarCasilla(2, 3);
		
		juegoMock.actualizarVictoria();
		assertFalse(juegoMock.getVictoria());
		
		tablero.marcarCasilla(3, 5);
		tablero.marcarCasilla(4, 4);
		tablero.marcarCasilla(6, 4);
		tablero.marcarCasilla(6, 7);
		tablero.marcarCasilla(7, 7);
		tablero.marcarCasilla(8, 8);
		
		juegoMock.actualizarVictoria();
		assertTrue(juegoMock.getVictoria());
	}
	
	/* ESCENARIO 8 - Perder la partida */
	@Test
	public void escenario8() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		juegoMock.iniciarJuego(9, 9);
		Tablero tablero = juegoMock.getTablero();
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		tablero.abrirCasilla(0, 0);
		juegoMock.actualizarMinasAbiertas();
		assertTrue(juegoMock.getMinasAbiertas());
	}
	
	
	
	
	/* Exploratory - Ataque 1 */
	@Test
	public void Ataque1() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		tablero.abrirCasilla(2, B);
			
	}
	
	/* Exploratory - Ataque 3 */
	@Test
	public void Ataque3() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		tablero.abrirCasilla(null, null);
			
	}
}