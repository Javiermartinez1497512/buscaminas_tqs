package Model;

public class Casilla {
  private Boolean abierta;
  private Boolean mina;
  private Integer fila;
  private Integer columna;
  private Boolean marcada;

  public Casilla(Integer _fila, Integer _col ) {
    fila = _fila;
    columna = _col;
    
    abierta = false;
    mina = false;
    marcada = false;
  }

  public boolean getAbierta() {
	  return this.abierta;
  }
  
  public void setAbierta(Boolean _abierta) {
	  this.abierta = _abierta;
  }
	
  public int getColumna() {
	  return this.columna;
  }
	
  public int getFila() {
	  return this.fila;
  }
  
  public boolean getMina() {
	  return this.mina;
  }
  
  public void setMina(Boolean _mina) {
	  this.mina = _mina;
  }
  
  public boolean getMarcada() {
	  return this.marcada;
  }
  
  public void setMarcada(Boolean _marcada) {
	  this.marcada = _marcada;
  }		
  
  public int numVecinos(Integer _filas, Integer _columnas) {
	  return 0;
  }
	
}
