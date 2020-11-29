package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest_2 {
	/* ESCENARIO 1 - MARCAR UNA CASILLA */
	@Test
	public void escenario1() {
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
	public void escenario2() {
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
		
		//Caso 3 - Abrir casilla ya marcada.
		tablero.marcarCasilla(3, 3);
		tablero.abrirCasilla(3, 3);
		assertFalse(tablero.getCasilla(3, 3).getAbierta());
		
		//Caso 4 - Abrir casilla fuera del rango del tablero.
		tablero.abrirCasilla(10, 10);
		assertFalse(tablero.getCasilla(10, 10).getAbierta());
	}	
	
	@Test
	public void Ataque1() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		tablero.colocarMinas(posiciones);
		
		tablero.abrirCasilla(2, B);
			
	}
	
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