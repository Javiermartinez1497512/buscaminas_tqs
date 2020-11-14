package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void testIniciarJuego() {
		Juego juego = new Juego();
		juego.iniciarJuego(9,9);
		
		Tablero tablero = juego.getTablero();		
		Tablero tableroComparar = new Tablero(9,9);
		
		assertEquals(tablero.getNumCols(),tableroComparar.getNumCols());
		assertEquals(tablero.getNumFilas(),tableroComparar.getNumFilas());		
	}

}
