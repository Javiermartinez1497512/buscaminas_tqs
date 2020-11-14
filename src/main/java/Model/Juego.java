package Model;

public class Juego {
	
	private Tablero tablero;

	public Juego() {}
	
	public void iniciarJuego(Integer _fila, Integer _columna) {
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
	}
	
	public Tablero getTablero() {return this.tablero;}
}
