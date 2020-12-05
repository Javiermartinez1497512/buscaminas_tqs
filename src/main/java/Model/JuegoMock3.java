package Model;

public class JuegoMock3 extends Juego{
	public JuegoMock3() {
		super();
	}
	
	public int[][] posicionesAleatoriasTablero() {
		int posiciones[][] = new int[40][2];
		
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
		
		posiciones[10][0] = 8;
		posiciones[10][1] = 8;
		
		posiciones[11][0] = 8;
		posiciones[11][1] = 9;
		
		posiciones[12][0] = 9;
		posiciones[12][1] = 9;
		
		posiciones[13][0] = 9;
		posiciones[13][1] = 10;
		
		posiciones[14][0] = 10;
		posiciones[14][1] = 10;
		
		posiciones[15][0] = 10;
		posiciones[15][1] = 11;
		
		posiciones[16][0] = 11;
		posiciones[16][1] = 11;
		
		posiciones[17][0] = 11;
		posiciones[17][1] = 12;

		posiciones[18][0] = 12;
		posiciones[18][1] = 12;
		
		posiciones[19][0] = 12;
		posiciones[19][1] = 13;
		
		posiciones[20][0] = 13;
		posiciones[20][1] = 13;
		
		posiciones[21][0] = 13;
		posiciones[21][1] = 14;
		
		posiciones[22][0] = 14;
		posiciones[22][1] = 14;
		
		posiciones[23][0] = 14;
		posiciones[23][1] = 15;
		
		posiciones[24][0] = 15;
		posiciones[24][1] = 15;
		
		posiciones[25][0] = 12;
		posiciones[25][1] = 10;
		
		posiciones[26][0] = 11;
		posiciones[26][1] = 9;
		
		posiciones[27][0] = 10;
		posiciones[27][1] = 8;

		posiciones[28][0] = 5;
		posiciones[28][1] = 9;
	
		posiciones[29][0] = 8;
		posiciones[29][1] = 12;
		
		posiciones[30][0] = 13;
		posiciones[30][1] = 15;
		
		posiciones[31][0] = 15;
		posiciones[31][1] = 0;
		
		posiciones[32][0] = 0;
		posiciones[32][1] = 8;
		
		posiciones[33][0] = 4;
		posiciones[33][1] = 10;
		
		posiciones[34][0] = 5;
		posiciones[34][1] = 11;
		
		posiciones[35][0] = 10;
		posiciones[35][1] = 3;
		
		posiciones[36][0] = 12;
		posiciones[36][1] = 7;
		
		posiciones[37][0] = 5;
		posiciones[37][1] = 15;

		posiciones[38][0] = 0;
		posiciones[38][1] = 14;
		
		posiciones[39][0] = 7;
		posiciones[39][1] = 10;
		

		

		
		return posiciones;
	}
	public void iniciarJuegoSinMinas(Integer _fila, Integer _columna) {
		this.setNumMinas(0);
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
	}
	public void iniciarJuegoConMinas(Integer _fila, Integer _columna) {
		this.setNumMinas(40);
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
		System.out.println("Aqui llegamos");
		int [][]posiciones = this.posicionesAleatoriasTablero();
		
		for (int i = 0; i<posiciones.length; i++) {
			for (int j = 0; j<posiciones[i].length; j++) {
				System.out.println(posiciones[i][j]);
			}
		}
		this.tablero.colocarMinas(posiciones);
	}
}
