package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void testInitBoard() {
		Tablero tablero = new Tablero(9,9);
		
	}

	@Test
	public void testConstructor() {
		Tablero tablero = new Tablero(9,9);
		
		assertTrue(tablero.getNumFilas() == 9);
		assertTrue(tablero.getNumCols() == 9);

	}
}
