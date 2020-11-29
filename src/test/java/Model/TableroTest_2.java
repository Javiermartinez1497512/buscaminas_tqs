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
	
	
	
	
	
	
	
	

}
