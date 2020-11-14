package Model;

import java.util.Random;

public class Juego {
	
	private Tablero tablero;
	private Integer numMinas = 10; //Por defecto el juego incluira 10 minas
	public Juego() {}
	
	public void iniciarJuego(Integer _fila, Integer _columna) {
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
		
		int[][] posiciones = this.posicionesAleatorias();
		tablero.colocarMinas(posiciones);		
	}
	
	public Tablero getTablero() {return this.tablero;}	
	public int getNumMinas() {return this.numMinas;}
	public void setNumMinas(Integer _numMinas) {
		this.numMinas = _numMinas;
	}
	
	
	public int[][] posicionesAleatorias(){
		int[][] posiciones = new int[this.getNumMinas()][2];
		Random r = new Random();
	    
		for (int i = 0; i < posiciones.length; i++) { 		
			posiciones[i][0]=r.nextInt(tablero.getNumFilas());
			posiciones[i][1]=r.nextInt(tablero.getNumCols());
		}

		return posiciones;
	}
 
}
