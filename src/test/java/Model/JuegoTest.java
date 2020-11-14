package Model;

import static org.junit.Assert.*;

import java.util.Random;

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
		assertTrue(juego.getNumMinas() == 10);
		assertTrue(juego.getMarcadas() == 0);

		
		int[][]posiciones = juego.posicionesAleatorias();		
		tablero.colocarMinas(posiciones);
		
		Casilla casilla = tablero.getCasilla(posiciones[0][0],posiciones[0][1]);
		assertTrue(casilla.getMina() == true);
	}
	
	@Test
	public void testPosicionesAleatorias() {		
		
		int[][] posiciones = new int[juego.getNumMinas()][2];
		
		Random r = new Random();		
		for (int i = 0; i < posiciones.length; i++) { 
        		posiciones[i][0]=r.nextInt(tablero.getNumFilas());
        		posiciones[i][1]=r.nextInt(tablero.getNumCols());
        		assertTrue(posiciones[i][0]>=0);
        		assertTrue(posiciones[i][0]<tablero.getNumFilas());
        		assertTrue(posiciones[i][1]<tablero.getNumCols());
        		assertTrue(posiciones[i][1]>=0);
        }
		
	}
	
	@Test
	public void testGetNumMinas() {
		assertTrue(juego.getNumMinas() == 10);
	}
	
	@Test
	public void testSetNumMinas() {
		juego.setNumMinas(5);
		assertTrue(juego.getNumMinas() == 5);
	}
	
	@Test
	public void testMarcasDisponibles() {
		assertTrue(juego.getMarcadas() < juego.getNumMinas());
	}

	@Test
	public void testAbrirCasilla() {
		Casilla casilla = tablero.getCasilla(0,0);
		assertEquals(casilla.getAbierta(),false);
		
		tablero.abrirCasilla(0,0);
	}
	
}
