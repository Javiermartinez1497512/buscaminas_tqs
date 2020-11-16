package Model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	JuegoMock juego;
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception{
		juego = new JuegoMock();
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
		
		int [][] posiciones = juego.posicionesAleatoriasTablero();
		tablero.colocarMinas(posiciones);
		
		Casilla casilla = tablero.getCasilla(posiciones[0][0],posiciones[0][1]);
		assertTrue(casilla.getMina() == true);
	}
	
	@Test
	public void testPosicionesAleatorias() {		
		
		int [][] posiciones = juego.posicionesAleatoriasTablero();
		for (int i = 0; i < posiciones.length; i++) { 
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
		//Marcadas menor a minas
		juego.setMarcadas(0);
		juego.marcasDisponibles();
		assertTrue(juego.getMarcadas() < juego.getNumMinas());
		
		//Marcadas mayor o igual a minas
		juego.setMarcadas(10);
		juego.marcasDisponibles();
		assertTrue(juego.getMarcadas() >= juego.getNumMinas());
	}

	@Test
	public void testAbrirCasilla() {
		Casilla casilla = tablero.getCasilla(0,0);
		assertEquals(casilla.getAbierta(),false);
		
		juego.abrirCasilla(0,0);
	}
	
	
	@Test
	public void testMarcarDesmarcarCasilla() {
		//Caso para desmarcar
		Casilla casilla = tablero.getCasilla(0,0);
		casilla.setMarcada(true);
		assertEquals(casilla.getMarcada(),true);
		juego.marcarDesmarcarCasilla(0,0);
		assertEquals(casilla.getMarcada(),false);
		
		//Caso para marcar (marcas disponibles && !marcada)
		Casilla casilla2 = tablero.getCasilla(2,2);
		juego.setMarcadas(0);
		assertEquals(juego.marcasDisponibles(),true);
		casilla2.setMarcada(false);
		assertEquals(casilla2.getMarcada(),false);
		juego.marcarDesmarcarCasilla(2, 2);
		assertEquals(casilla2.getMarcada(),true);
		
		//Caso para marcar (marcas no disponibles && !marcada)
		Casilla casilla3 = tablero.getCasilla(3,3);
		juego.setMarcadas(10);
		assertEquals(juego.marcasDisponibles(),false);
		casilla3.setMarcada(false);
		assertEquals(casilla3.getMarcada(),false);
		juego.marcarDesmarcarCasilla(3, 3);
		assertEquals(casilla3.getMarcada(),false);
		
		//Caso para marcar (marcas disponibles && marcada)
		Casilla casilla4 = tablero.getCasilla(4,4);
		juego.setMarcadas(0);
		assertEquals(juego.marcasDisponibles(),true);
		casilla4.setMarcada(true);
		assertEquals(casilla4.getMarcada(),true);
		juego.marcarDesmarcarCasilla(4, 4);
		assertEquals(casilla4.getMarcada(),false);
		
		//Caso para marcar (marcas no disponibles && marcada)
		Casilla casilla5 = tablero.getCasilla(5,5);
		juego.setMarcadas(10);
		assertEquals(juego.marcasDisponibles(),false);
		casilla5.setMarcada(true);
		assertEquals(casilla5.getMarcada(),true);
		juego.marcarDesmarcarCasilla(5, 5);
	}
	
	@Test
	public void testActualizarMarcas() {
		juego.actualizarMarcas();
		assertTrue(juego.getMarcadas() == 0);
		tablero.marcarCasilla(0,0);
		tablero.marcarCasilla(5,5);	
		juego.actualizarMarcas();
		assertTrue(juego.getMarcadas() == 2);
	}
	
	@Test
	public void testActualizarMinasAbiertas() {
		juego.actualizarMinasAbiertas();
		assertTrue(juego.getMinasAbiertas() == false);
		
		Casilla casilla1 = tablero.getCasilla(0,0);
		casilla1.setMina(true);
		casilla1.setAbierta(true);
		
		juego.actualizarMinasAbiertas();
		assertTrue(juego.getMinasAbiertas() == true);	
	}
	
	@Test
	public void testActualizarVictoria() {
		
		JuegoMock juegoMock = new JuegoMock();
		juegoMock.iniciarJuegoSinMinas(9,9);
		juego.actualizarVictoria();
	
		for (int i = 0; i < tablero.getNumCols(); i++) {
			for (int j = 0; j < tablero.getNumFilas(); j++) {
				Casilla auxCasilla = tablero.getCasilla(i,j);
				if(!auxCasilla.getMina()) {
					juego.abrirCasilla(i,j);
				}
			}
		}
		juego.actualizarVictoria();
		assertEquals(juego.getVictoria(),true);	

	}
	
	
	
}
