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
}
