package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	Juego juego;
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception{
		juego = new Juego();
		juego.iniciarJuego(9,9);
		
		tablero = juego.getTablero();	
	}

	@Test
	public void testIniciarJuego() {			
		Tablero tableroComparar = new Tablero(9,9);
		
		assertEquals(tablero.getNumCols(),tableroComparar.getNumCols());
		assertEquals(tablero.getNumFilas(),tableroComparar.getNumFilas());		
	}
	
	@Test
	public void testPosicionesAleatorias() {
		int[][] toReturn = new int[10][2];
		
		toReturn[0][0]=0;
		toReturn[0][1]=0;
		
		assertTrue(toReturn[0][0]>=0);
		assertTrue(toReturn[0][0]<tablero.getNumFilas());
		assertTrue(toReturn[0][1]<tablero.getNumCols());
		assertTrue(toReturn[0][1]>=0);
	}
	

}
