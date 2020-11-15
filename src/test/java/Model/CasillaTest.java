package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CasillaTest {
	Casilla casilla;
	Casilla casilla1;
	Casilla casilla2;
	Casilla casilla3;
	Casilla casilla4;
	Casilla casilla5;
	Casilla casilla6;
	Casilla casilla7;
	Casilla casilla8;
	Casilla casilla9;


	@Before
	public void setUp() throws Exception{

		casilla = new Casilla(0,0);
		casilla1 = new Casilla(0,8);
		casilla2 = new Casilla(8,0);
		casilla3 = new Casilla(8,8);
		casilla4 = new Casilla(4,0);
		casilla5 = new Casilla(0,4);
		casilla6 = new Casilla(4,8);
		casilla7 = new Casilla(8,4);
		casilla8 = new Casilla(4,4);
		casilla9 = new Casilla(6,3);
	}
	@Test
	public void testConstructor() {
		
		assertTrue(casilla.getFila() == 0);
		assertTrue(casilla.getColumna() == 0);
		assertTrue(casilla.getAbierta() == false);
		assertTrue(casilla.getMina() == false);
		assertTrue(casilla.getMarcada() == false);
		assertTrue(casilla.getMinasVecinas() == 0);		
	}
	
	@Test
	public void testNumVecinos() {
		//Dimensiones tablero
		int filas = 9;
		int columnas = 9;
		
		//Comprovamos esquinas tablero
		assertEquals(casilla.numVecinos(filas,columnas),3);
		assertEquals(casilla1.numVecinos(filas,columnas),3);
		assertEquals(casilla2.numVecinos(filas,columnas),3);
		assertEquals(casilla3.numVecinos(filas,columnas),3);
		
		//Comprovamos centros de los laterales
		assertEquals(casilla4.numVecinos(filas,columnas),5);
		assertEquals(casilla5.numVecinos(filas,columnas),5);
		assertEquals(casilla6.numVecinos(filas,columnas),5);
		assertEquals(casilla7.numVecinos(filas,columnas),5);
		
		//Comprovamos otra posicion del tablero alejada de los bordes
		assertEquals(casilla8.numVecinos(filas,columnas),8);
		assertEquals(casilla9.numVecinos(filas,columnas),8);
	}
	
	@Test
	public void testGetPosicionVecinos() {
		//Dimensiones tablero
		int filas = 9;
		int columnas = 9;
		
		//Comprovamos esquinas tablero
		int[][] pVecinos = casilla.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados = {{0,1},{1,1},{1,0}};
		assertArrayEquals(pVecinos,vecinosEsperados);	
		int[][] pVecinos1 = casilla1.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados1 = {{1,8},{1,7},{0,7}};
		assertArrayEquals(pVecinos1,vecinosEsperados1);	
		int[][] pVecinos2 = casilla2.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados2 = {{7,0},{7,1},{8,1}};
		assertArrayEquals(pVecinos2,vecinosEsperados2);	
		int[][] pVecinos3 = casilla3.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados3 = {{7,7},{7,8},{8,7}};
		assertArrayEquals(pVecinos3,vecinosEsperados3);	
		
		//Comprovamos centros de los laterales
		int[][] pVecinos4 = casilla4.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados4 = {{3,0},{3,1},{4,1},{5,1},{5,0}};
		assertArrayEquals(pVecinos4,vecinosEsperados4);	
		int[][] pVecinos5 = casilla5.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados5 = {{0,5},{1,5},{1,4},{1,3},{0,3}};
		assertArrayEquals(pVecinos5,vecinosEsperados5);
		int[][] pVecinos6 = casilla6.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados6 = {{3,7},{3,8},{5,8},{5,7},{4,7}};		
		assertArrayEquals(pVecinos6,vecinosEsperados6);
		int[][] pVecinos7 = casilla7.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados7 = {{7,3},{7,4},{7,5},{8,5},{8,3}};
		assertArrayEquals(pVecinos7,vecinosEsperados7);
		
		//Comprovamos otra posicion del tablero alejada de los bordes
		int[][] pVecinos8 = casilla8.getPosicionVecinos(filas, columnas);
		int[][] vecinosEsperados8 = {{3,3},{3,4},{3,5},{4,5},{5,5},{5,4},{5,3},{4,3}};
		assertArrayEquals(pVecinos8,vecinosEsperados8);
	}
	
	@Test
	public void testSetMina() {
		assertTrue(casilla.getMina() == false);
		casilla.setMina(true);
		assertTrue(casilla.getMina() == true);
		casilla.setMina(false);
		assertTrue(casilla.getMina() == false);
	}
	
	@Test
	public void testSetAbierta() {
		assertTrue(casilla.getAbierta() == false);
		casilla.setAbierta(true);
		assertTrue(casilla.getAbierta() == true);
		casilla.setAbierta(false);
		assertTrue(casilla.getAbierta() == false);
	}
	
	@Test
	public void testSetMarcada() {
		assertTrue(casilla.getMarcada() == false);
		casilla.setMarcada(true);
		assertTrue(casilla.getMarcada() == true);
		casilla.setMarcada(false);
		assertTrue(casilla.getMarcada() == false);
	}
	
	@Test
	public void testSetMinasVecinas() {
		assertEquals(casilla.getMinasVecinas(),0);
		casilla.setMinasVecinas(5);
		assertEquals(casilla.getMinasVecinas(),5);
	}

	
	
	
	
}
