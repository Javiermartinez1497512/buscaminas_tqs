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
    int vecinos = 8; // Por defecto tiene 8 vecions

    if((this.fila-1 < 0) || (this.fila+1 >= _filas)) {
      if((this.columna-1 < 0) || (this.columna+1 >= _columnas)) {
    	  // Esta fuera de los limites por lo tanto nos encontramos en una esquina
    	  vecinos=3; 
      }else {
    	  //Entendemos que se encuentra en uno de los bordes
    	  vecinos = 5; 
      }
    }
    
    if((this.columna-1 < 0) || (this.columna+1 >= _columnas)) {
      if((this.fila-1 < 0) || (this.fila+1 >= _filas)) {
    	  // Esta fuera de los limites por lo tanto nos encontramos en una esquina
    	  vecinos=3;
      }else {
    	//Entendemos que se encuentra en uno de los bordes
    	vecinos = 5;
      }
    }

    return vecinos;
  }
  
  public int[][] getPosicionVecions(Integer _filas, Integer _columnas){
    int[][] posVecinos = null;
    return posVecinos;
  }
	
}
