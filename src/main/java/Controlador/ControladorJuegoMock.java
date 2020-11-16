package Controlador;

import Model.Juego;
import Model.JuegoMock;
import Model.Tablero;

public class ControladorJuegoMock extends ControladorJuego{
	
	private JuegoMock juego;
	private int nivel = 1;
	public ControladorJuegoMock() {
		this.juego =  new JuegoMock();

	}
	
	public void nuevoJuego() {
		this.juego =  new JuegoMock();
		Integer filas=9;
		Integer columnas=9;
		Integer minas=10;
		if(this.nivel==2) {
			filas=16;
			columnas=16;
			minas=40;
		}else if(this.nivel==3) {
			filas=22;
			columnas=22;
			minas=99;
		}

		juego.setNumMinas(minas);
		juego.iniciarJuegoSinMinas(filas, columnas); 
	}
	
	public JuegoMock getJuego() {return this.juego;}
}
