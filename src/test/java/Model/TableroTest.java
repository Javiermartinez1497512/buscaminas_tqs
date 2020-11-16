package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableroTest {
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception{
		tablero = new Tablero(9,9);
		tablero.initBoard();
	}

	@Test
	public void testInitBoard() {
		
		Casilla casilla1 = tablero.getCasilla(0, 0);
		assertTrue(casilla1.getAbierta() == false);
		assertTrue(casilla1.getMina() == false);	
		
		Casilla casilla2 = tablero.getCasilla(8, 8);
		assertTrue(casilla2.getAbierta() == false);
		assertTrue(casilla2.getMina() == false);	
		
		Casilla casilla3 = tablero.getCasilla(4, 4);
		assertTrue(casilla3.getAbierta() == false);
		assertTrue(casilla3.getMina() == false);	
		
		Casilla casilla4 = tablero.getCasilla(3, 4);
		assertTrue(casilla4.getAbierta() == false);		
		assertTrue(casilla4.getMina() == false);	
	}

	@Test
	public void testConstructor() {	
		assertTrue(tablero.getNumFilas() == 9);
		assertTrue(tablero.getNumCols() == 9);
	}
	
	@Test
	public void testColocarMinas() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		
		tablero.colocarMinas(posiciones);
		
		for (int i = 0; i < posiciones.length; i++) {
    		Casilla auxCasilla = tablero.getCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getMina(),true);
        }
	}
	
	@Test
	public void testContarMinasVecinas() {
		JuegoMock juegoMock = new JuegoMock();
		int [][] posiciones = juegoMock.posicionesAleatoriasTablero();
		
		tablero.colocarMinas(posiciones);
		
		Casilla casilla1 = tablero.getCasilla(1,0);
		assertEquals(casilla1.getMinasVecinas(),2);
		
		Casilla casilla2 = tablero.getCasilla(3,4);
		assertEquals(casilla2.getMinasVecinas(),3);
		
		Casilla casilla3 = tablero.getCasilla(7,4);
		assertEquals(casilla3.getMinasVecinas(),1);
		
		Casilla casilla4 = tablero.getCasilla(8,0);
		assertEquals(casilla4.getMinasVecinas(),0);
	}	

	@Test
	public void testMarcarCasilla() {
		tablero.marcarCasilla(1,1);
		Casilla casilla = tablero.getCasilla(1,1);
		assertEquals(casilla.getMarcada(),true);
		
		Casilla casilla2 = tablero.getCasilla(2,2);
		assertEquals(casilla2.getMarcada(),false);
	}
	
	@Test
	public void testDesmarcarCasilla() {
		tablero.desmarcarCasilla(1,1);
		Casilla casilla = tablero.getCasilla(1,1);
		assertEquals(casilla.getMarcada(),false);
		
		Casilla casilla2 = tablero.getCasilla(2,2);
		assertEquals(casilla2.getMarcada(),false);
	}
	
	@Test
	public void testAbrirCasilla() {
		//Casilla no abierta no marcada
		Casilla casilla = new Casilla(1,1);
		assertEquals(casilla.getAbierta(),false);
		assertEquals(casilla.getMarcada(),false);
		casilla.setAbierta(true);
		tablero.abrirCasilla(1,1);
		assertEquals(casilla.getAbierta(),true);
		
		// Casilla abierta 
		Casilla casilla2 = new Casilla(2,2);
		casilla2.setAbierta(true);
		assertEquals(casilla2.getAbierta(),true);
		tablero.abrirCasilla(2,2);	
		
		// Casilla no abierta y marcada
		Casilla casilla3 = new Casilla(3,3);
		assertEquals(casilla3.getAbierta(),false);
		casilla3.setMarcada(true);
		assertEquals(casilla3.getMarcada(),true);
		tablero.abrirCasilla(3,3);	
		
		int [][] posiciones = casilla.getPosicionVecinos(tablero.getNumFilas(), tablero.getNumFilas());
		for (int i = 0; i < posiciones.length; i++) {
    		Casilla auxCasilla = tablero.getCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getMarcada(),false);
    		assertEquals(auxCasilla.getMina(),false);
    		tablero.abrirCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getAbierta(),true);
		}		
	}
		
}
