package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasillaTest {

	@Test
	public void testConstructor() {
		Casilla casilla = new Casilla(0,0);
		
		assertTrue(casilla.getFila() == 0);
		assertTrue(casilla.getColumna() == 0);
		assertTrue(casilla.getAbierta() == false);
		assertTrue(casilla.getMina() == false);
		assertTrue(casilla.getMarcada() == false);		
	}
	
	@Test
	public void testNumVecinos() {
		//Dimensiones tablero
		int maxfila = 9;
		int maxcolumna = 9;
		
		//Comprovamos esquinas tablero
		Casilla casilla = new Casilla(0,0);
		assertEquals(casilla.numVecinos(maxfila,maxcolumna),3);
		Casilla casilla1 = new Casilla(0,8);
		assertEquals(casilla1.numVecinos(maxfila,maxcolumna),3);
		Casilla casilla2 = new Casilla(8,0);
		assertEquals(casilla2.numVecinos(maxfila,maxcolumna),3);
		Casilla casilla3 = new Casilla(8,8);
		assertEquals(casilla3.numVecinos(maxfila,maxcolumna),3);
		
		//Comprovamos centros de los laterales
		Casilla casilla4 = new Casilla(4,0);
		assertEquals(casilla4.numVecinos(maxfila,maxcolumna),5);
		Casilla casilla5 = new Casilla(0,4);
		assertEquals(casilla5.numVecinos(maxfila,maxcolumna),5);
		Casilla casilla6 = new Casilla(4,8);
		assertEquals(casilla6.numVecinos(maxfila,maxcolumna),5);
		Casilla casilla7 = new Casilla(8,4);
		assertEquals(casilla7.numVecinos(maxfila,maxcolumna),5);
		
		//Comprovamos otra posicion del tablero alejada de los bordes
		Casilla casilla8 = new Casilla(4,4);
		assertEquals(casilla8.numVecinos(maxfila,maxcolumna),8);
		Casilla casilla9 = new Casilla(6,3);
		assertEquals(casilla9.numVecinos(maxfila,maxcolumna),8);
	}
}
