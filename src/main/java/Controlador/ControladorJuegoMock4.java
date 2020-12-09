package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import Model.Juego;
import Model.JuegoMock4;
import Vista.VistaJuego;

public class ControladorJuegoMock4 extends ControladorJuego{
	
	private VistaJuego vistaJuego;
	private JuegoMock4 juego;
	private int nivel = 1;
	public ControladorJuegoMock4() {
		this.juego =  new JuegoMock4();

	}
	
	public void nuevoJuego() {
		this.juego =  new JuegoMock4();
		Integer filas=32;
		Integer columnas=32;
		Integer minas=99;


		juego.setNumMinas(minas);
		//juego.iniciarJuegoSinMinas(filas, columnas);
		juego.iniciarJuego(filas, columnas);
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
	
	public JuegoMock4 getJuego() {return this.juego;}
	
	public void setNivel(Integer _nivel) {
		this.nivel=_nivel;
	}
	public int getNivel() {
		return this.nivel;
	}
	
	
	@Override
  	public void mouseClicked(MouseEvent e) {
		JButton selectedBtn = (JButton) e.getSource();

		int fila = selectedBtn.getX() / 32;
		int columna = selectedBtn.getY() / 32;
		
		if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON3 ) {
			this.accionRealizar(fila, columna, e.getButton());
		}
		
		this.actualizarJuego();
    }

	
	public void accionRealizar(int fila, int columna, int accion) {
		if (accion == MouseEvent.BUTTON1) {
			juego.abrirCasilla(fila, columna);
		} else if (accion == MouseEvent.BUTTON3) {
			juego.marcarDesmarcarCasilla(fila, columna);
		}
	}
	
	public void setVistaJuego(VistaJuego _vista) {
		this.vistaJuego=_vista;
	}
	
	
	public void actualizarJuego() {
		juego.actualizarMarcas();
		juego.actualizarMinasAbiertas();
		juego.actualizarVictoria();
		vistaJuego.actualizarVistaTablero();
	}
	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem menu = (JMenuItem) arg0.getSource();
		crearNivel(menu);
	}
	
}
