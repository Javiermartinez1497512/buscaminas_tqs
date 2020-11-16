package Model;

import java.util.Random;

public class Juego {
	
	protected Tablero tablero;
	private Integer numMinas = 10; //Por defecto el juego incluira 10 minas
	private Integer marcadas = 0; //Por defecto el juego empieza con 0 marcas
	private Boolean minasAbiertas = false; // Por defecto el juego empieza sin minas abiertas
	private Boolean victoria = false; // Por defecto el juego empieza sin victoria

	public Juego() {}
	
	public void iniciarJuego(Integer _fila, Integer _columna) {
		this.tablero = new Tablero(_fila,_columna);
		this.tablero.initBoard();
		
		int[][] posiciones = this.posicionesAleatorias();
		tablero.colocarMinas(posiciones);		
	}
	
	public Tablero getTablero() {return this.tablero;}	
	public int getNumMinas() {return this.numMinas;}
	public void setNumMinas(Integer _numMinas) {this.numMinas = _numMinas;}
	public int getMarcadas() {return this.marcadas;}
	public void setMarcadas(Integer _marcadas) {this.marcadas = _marcadas;}
	public Boolean getMinasAbiertas() {return this.minasAbiertas;}
	public void setMinasAbiertas(Boolean _minaAbierta) {this.minasAbiertas = _minaAbierta;}
	public Boolean getVictoria() {return this.victoria;}
	public void setVictoria(Boolean _victoria) {this.victoria = _victoria;}
	
	public int[][] posicionesAleatorias(){
		int[][] posiciones = new int[this.getNumMinas()][2];
		Random r = new Random();
	    
		for (int i = 0; i < posiciones.length; i++) { 		
			posiciones[i][0]=r.nextInt(tablero.getNumFilas());
			posiciones[i][1]=r.nextInt(tablero.getNumCols());
		}

		return posiciones;
	}
	
	public Boolean marcasDisponibles() {		
		Boolean disponibles = false;
		if(this.getMarcadas() < this.getNumMinas()) {
			disponibles = true;
		}
		
		return disponibles;
	}
	
	public void marcarDesmarcarCasilla(Integer _fila, Integer _columna) {
		Casilla casilla = tablero.getCasilla(_fila, _columna);
		if(casilla.getMarcada()) {
			tablero.desmarcarCasilla(_fila, _columna);
		}else if(this.marcasDisponibles()) {
			tablero.marcarCasilla(_fila,_columna);
		}
	}
	
	public void actualizarMarcas() {
		int numMarcadas = 0;
		for (int i = 0; i < tablero.getNumFilas(); i++) {
			for (int j = 0; j < tablero.getNumCols(); j++) {
				Casilla casilla = tablero.getCasilla(i,j);
				if(casilla.getMarcada()) {
					numMarcadas++;
				}
			}
		}
		
		this.setMarcadas(numMarcadas);
	}
	
	public void abrirCasilla(Integer _fila, Integer _columna) {
		Casilla casilla = tablero.getCasilla(_fila, _columna);
		if(!casilla.getAbierta()) {
			tablero.abrirCasilla(_fila, _columna);
		}
	}
	
	public void actualizarMinasAbiertas() {
		int minaAbiertas = 0;
		for (int i = 0; i < tablero.getNumFilas(); i++) {
			for (int j = 0; j < tablero.getNumCols(); j++) {
				Casilla casilla = tablero.getCasilla(i,j);
				if(casilla.getMina() && casilla.getAbierta()) {
					minaAbiertas++;
				}
			}
		}
		
		this.setMinasAbiertas((minaAbiertas>0)? true : false);
	}
	
	public void actualizarVictoria() {
		int casillasAbiertas = 0;
		int total_casillas = tablero.getNumFilas() * tablero.getNumCols();
		for (int i = 0; i < tablero.getNumFilas(); i++) {
			for (int j = 0; j < tablero.getNumCols(); j++) {
				Casilla casilla = tablero.getCasilla(i,j);
				if(casilla.getAbierta()) {
					casillasAbiertas++;
				}
			}
		}
		
		this.setVictoria((casillasAbiertas == (total_casillas-this.getNumMinas())? true : false));
	}
}
