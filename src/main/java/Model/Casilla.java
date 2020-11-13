package Model;

public class Casilla {
  private Boolean abierta;
  private Integer fila;
  private Integer columna;

  public Casilla(Integer _fila, Integer _col ) {
    abierta = false;
    fila = _fila;
    columna = _col;
  }

  public boolean getAbierta() {
	  return this.abierta;
  }
	
  public int getColumna() {
	  return this.columna;
  }
	
  public int getFila() {
	  return this.fila;
  }
		
	
}
