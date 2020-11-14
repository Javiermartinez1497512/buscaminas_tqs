package Model;

public class Tablero {
	
	private Integer numFilas = 9;
	private Integer numCols = 9;
	private Casilla [][] casillas; 


  public Tablero(Integer _numFilas, Integer _numCols) {
	  numFilas = _numFilas;
	  numCols = _numCols;
	  casillas = new Casilla[_numFilas][_numCols];
  }
  public void initBoard() {
    for (int i = 0; i < numFilas; i++) {
      for (int j = 0; j < numCols; j++) {
        Casilla box = new Casilla(i,j);
        casillas[i][j] = box;
      }
    }
  }
  
  public void colocarMinas(int[][] _posicionesMinas){
	  for (int i = 0; i < _posicionesMinas.length; i++) { 
      		int fila = _posicionesMinas[i][0];
      		int columna = _posicionesMinas[i][1];
		    casillas[fila][columna].setMina(true);
	  }
  }
  
  public int getNumFilas() {
	return this.numFilas;
  }
  
  public int getNumCols() {
	return this.numCols;
  }
  
  public Casilla getCasilla(Integer _fila, Integer _columna) {
	return this.casillas[_fila][_columna];
  }
  
  public void marcarCasilla(int numRows, int numCols){
    Casilla casilla = this.casillas[numRows][numCols];
    casilla.setMarcada(true);
  }
  public void desmarcarCasilla(int numRows, int numCols){
    Casilla casilla = this.casillas[numRows][numCols];
    casilla.setMarcada(false);
  }
  
  public void abrirCasilla(Integer _fila, Integer _columna) {
	  Casilla casilla = this.casillas[_fila][_columna];
	  if(!casilla.getAbierta()) {
		  if(!casilla.getMarcada()) {
			  casilla.setAbierta(true);
		  }		  
	  }	  
  }
}

