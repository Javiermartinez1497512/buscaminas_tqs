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
		// Particiones equivalentes
		
		Casilla casilla1 = tablero.getCasilla(0, 0);
		assertEquals(casilla1.getAbierta(),false);
		assertEquals(casilla1.getMina(),false);	
		
		Casilla casilla2 = tablero.getCasilla(8, 8);
		assertEquals(casilla2.getAbierta(),false);
		assertEquals(casilla2.getMina(),false);	
		
		Casilla casilla3 = tablero.getCasilla(4, 4);
		assertEquals(casilla3.getAbierta(),false);
		assertEquals(casilla3.getMina(),false);	
		
		Casilla casilla4 = tablero.getCasilla(3, 4);
		assertEquals(casilla4.getAbierta(),false);		
		assertEquals(casilla4.getMina(),false);		

		Tablero tableroaux = new Tablero(9,9);
		Casilla casillaaux = tableroaux.getCasilla(0,0);
		assertEquals(casillaaux,null);
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
		
		Casilla casillaSinMina1 = tablero.getCasilla(1,1);
		Casilla casillaSinMina2 = tablero.getCasilla(5,5);
		assertEquals(casillaSinMina1.getMina(),false);
		assertEquals(casillaSinMina2.getMina(),false);
		
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
		//Decision & Condition coverage
		
		// Casilla abierta 
		Casilla casilla2 = tablero.getCasilla(2,2);
		casilla2.setAbierta(true);
		assertEquals(casilla2.getAbierta(),true);
		tablero.abrirCasilla(2,2);	
		
		// Casilla no abierta y marcada
		Casilla casilla3 = tablero.getCasilla(3,3);
		assertEquals(casilla3.getAbierta(),false);
		casilla3.setMarcada(true);
		assertEquals(casilla3.getMarcada(),true);
		tablero.abrirCasilla(3,3);	
		
		//Casilla no abierta no marcada y vecinas
		Casilla casilla = tablero.getCasilla(0,1);
		assertEquals(casilla.getAbierta(),false);
		assertEquals(casilla.getMarcada(),false);
		casilla.setAbierta(true);
		casilla.setMinasVecinas(1);
		assertFalse(casilla.getMinasVecinas()==0);
		tablero.abrirCasilla(0,1);	
		
		//Casilla no abierta no marcada y mina
		Casilla casilla4 = tablero.getCasilla(0,0);
		assertEquals(casilla4.getAbierta(),false);
		assertEquals(casilla4.getMarcada(),false);
		casilla4.setMina(true);
		assertEquals(casilla4.getMina(),true);
		tablero.abrirCasilla(0,0);	
		
		//Casilla no abierta no marcada y sin mina y sin vecinos
		Casilla casilla5 = tablero.getCasilla(0,8);
		assertEquals(casilla5.getAbierta(),false);
		assertEquals(casilla5.getMarcada(),false);
		casilla5.setMina(false);
		casilla5.setMinasVecinas(0);
		assertTrue(casilla5.getMinasVecinas()==0);
		assertEquals(casilla5.getMina(),false);
		tablero.abrirCasilla(0,8);
		casilla5.setAbierta(false);
		
		//Abrir recursivo
		Tablero tableroaux = new Tablero(9,9);
		tableroaux.initBoard();
		Casilla casillaaux = tableroaux.getCasilla(0,1);		
		int [][] posiciones = casillaaux.getPosicionVecinos(tableroaux.getNumFilas(), tableroaux.getNumFilas());
		for (int i = 0; i < posiciones.length; i++) {
    		Casilla auxCasilla = tableroaux.getCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getMarcada(),false);
    		assertEquals(auxCasilla.getMina(),false);
    		tableroaux.abrirCasilla(posiciones[i][0],posiciones[i][1]);
    		assertEquals(auxCasilla.getAbierta(),true);
		}
	}
		
}
