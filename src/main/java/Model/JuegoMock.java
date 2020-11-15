package Model;

public class JuegoMock extends Juego{
	public JuegoMock() {
		super();
	}
	
	public int[][] posicionesAleatoriasTablero() {
		int posiciones[][] = new int[10][2];
		
		posiciones[0][0] = 0;
		posiciones[0][1] = 0;
		
		posiciones[1][0] = 0;
		posiciones[1][1] = 1;
		
		posiciones[2][0] = 1;
		posiciones[2][1] = 2;
		
		posiciones[3][0] = 4;
		posiciones[3][1] = 4;
		
		posiciones[4][0] = 6;
		posiciones[4][1] = 4;
		
		posiciones[5][0] = 2;
		posiciones[5][1] = 3;
		
		posiciones[6][0] = 7;
		posiciones[6][1] = 7;
		
		posiciones[7][0] = 3;
		posiciones[7][1] = 5;
		
		posiciones[8][0] = 8;
		posiciones[8][1] = 8;

		posiciones[9][0] = 6;
		posiciones[9][1] = 7;
		
		return posiciones;
	}
	public void iniciarJuegoSinMinas(Integer _fila, Integer _columna) {
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
	}
}
