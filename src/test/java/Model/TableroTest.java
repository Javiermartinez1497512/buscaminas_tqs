package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void testInitBoard() {
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		
		Casilla casilla1 = tablero.getCasilla(0, 0);
		assertTrue(casilla1.getAbierta() == false);
		
		Casilla casilla2 = tablero.getCasilla(8, 8);
		assertTrue(casilla2.getAbierta() == false);
		
		Casilla casilla3 = tablero.getCasilla(4, 4);
		assertTrue(casilla3.getAbierta() == false);
		
		Casilla casilla4 = tablero.getCasilla(3, 4);
		assertTrue(casilla4.getAbierta() == false);		
	}

	@Test
	public void testConstructor() {
		Tablero tablero = new Tablero(9,9);
		
		assertTrue(tablero.getNumFilas() == 9);
		assertTrue(tablero.getNumCols() == 9);
	}
	
	@Test
	public void testInicializarMinas() {
		Tablero tablero = new Tablero(9,9);
		tablero.initBoard();
		
		Casilla casilla1 = tablero.getCasilla(0, 0);
		assertTrue(casilla1.getMina() == false);	
	}
}
