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
		int filas = 9;
		int columnas = 9;
		
		//Comprovamos esquinas tablero
		Casilla casilla = new Casilla(0,0);
		assertEquals(casilla.numVecinos(filas,columnas),3);
		Casilla casilla1 = new Casilla(0,8);
		assertEquals(casilla1.numVecinos(filas,columnas),3);
		Casilla casilla2 = new Casilla(8,0);
		assertEquals(casilla2.numVecinos(filas,columnas),3);
		Casilla casilla3 = new Casilla(8,8);
		assertEquals(casilla3.numVecinos(filas,columnas),3);
		
		//Comprovamos centros de los laterales
		Casilla casilla4 = new Casilla(4,0);
		assertEquals(casilla4.numVecinos(filas,columnas),5);
		Casilla casilla5 = new Casilla(0,4);
		assertEquals(casilla5.numVecinos(filas,columnas),5);
		Casilla casilla6 = new Casilla(4,8);
		assertEquals(casilla6.numVecinos(filas,columnas),5);
		Casilla casilla7 = new Casilla(8,4);
		assertEquals(casilla7.numVecinos(filas,columnas),5);
		
		//Comprovamos otra posicion del tablero alejada de los bordes
		Casilla casilla8 = new Casilla(4,4);
		assertEquals(casilla8.numVecinos(filas,columnas),8);
		Casilla casilla9 = new Casilla(6,3);
		assertEquals(casilla9.numVecinos(filas,columnas),8);
	}
	
	@Test
	public void testGetPosicionVecinos() {
		//Dimensiones tablero
		int filas = 9;
		int columnas = 9;
		
		//Comprovamos esquinas tablero
		Casilla casilla = new Casilla(0,0);
		int[][] pVecinos = casilla.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados = {{0,1},{1,1},{1,0}};
		assertArrayEquals(pVecinos,vecinosEsperados);	
		Casilla casilla1 = new Casilla(0,8);
		int[][] pVecinos1 = casilla1.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados1 = {{1,8},{1,7},{0,7}};
		assertArrayEquals(pVecinos1,vecinosEsperados1);	
		Casilla casilla2 = new Casilla(8,0);
		int[][] pVecinos2 = casilla2.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados2 = {{7,0},{7,1},{8,1}};
		assertArrayEquals(pVecinos2,vecinosEsperados2);	
		Casilla casilla3 = new Casilla(8,8);
		int[][] pVecinos3 = casilla3.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados3 = {{7,7},{7,8},{8,7}};
		assertArrayEquals(pVecinos3,vecinosEsperados3);	
		
		//Comprovamos centros de los laterales
		Casilla casilla4 = new Casilla(4,0);
		int[][] pVecinos4 = casilla4.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados4 = {{3,0},{3,1},{4,1},{5,1},{5,0}};
		assertArrayEquals(pVecinos4,vecinosEsperados4);	
		Casilla casilla5 = new Casilla(0,4);
		int[][] pVecinos5 = casilla5.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados5 = {{0,5},{1,5},{1,4},{1,3},{0,3}};
		assertArrayEquals(pVecinos5,vecinosEsperados5);
		Casilla casilla6 = new Casilla(4,8);
		int[][] pVecinos6 = casilla6.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados6 = {{3,7},{3,8},{5,8},{5,7},{4,7}};		
		assertArrayEquals(pVecinos6,vecinosEsperados6);
		Casilla casilla7 = new Casilla(8,4);
		int[][] pVecinos7 = casilla7.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados7 = {{7,3},{7,4},{7,5},{8,5},{8,3}};
		assertArrayEquals(pVecinos7,vecinosEsperados7);
		
		//Comprovamos otra posicion del tablero alejada de los bordes
		Casilla casilla8 = new Casilla(4,4);
		int[][] pVecinos8 = casilla8.getPosicionVecions(filas, columnas);
		int[][] vecinosEsperados8 = {{3,3},{3,4},{3,5},{4,5},{5,5},{5,4},{5,3},{4,3}};
		assertArrayEquals(pVecinos8,vecinosEsperados8);
	}
	
}
