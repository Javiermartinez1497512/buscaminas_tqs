package Controlador;

import javax.swing.JMenuItem;

import Model.JuegoMock;

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
	
	public void crearNivel(JMenuItem _menu) {
		JMenuItem menu = _menu;
		if(menu.getText()=="Facil") {
			this.setNivel(1);
		}else if(menu.getText()=="Medio"){
			this.setNivel(2);
		}else if(menu.getText()=="Dificil") {
			this.setNivel(3);
		}
	}
	
	public JuegoMock getJuego() {return this.juego;}
}
