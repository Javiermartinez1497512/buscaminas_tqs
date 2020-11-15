package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import Model.Juego;
import Vista.VistaJuego;

public class ControladorJuego implements MouseListener, ActionListener{
	
	private VistaJuego vistaJuego;
	private Juego juego;
	private Integer nivel=1; //Por defecto nivel Facil
	
	public ControladorJuego() {
		this.nuevoJuego();
	}
	
	public void setVistaJuego(VistaJuego _vista) {
		this.vistaJuego=_vista;
	}
	
	public Juego getJuego() {
		return this.juego;
	}
	
	public void nuevoJuego() {
		this.juego =  new Juego();
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
		juego.iniciarJuego(filas, columnas); 
		
	}
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
		//System.out.println("Click casilla: "+fila+","+columna);
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			//System.out.println("Abrir casilla");
			juego.abrirCasilla(fila, columna);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			//System.out.println("Marcar casilla");
			juego.marcarDesmarcarCasilla(fila, columna);
		}
		
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
		if(menu.getText()=="Facil") {
			this.setNivel(1);
		}else if(menu.getText()=="Medio"){
			this.setNivel(2);
		}else if(menu.getText()=="Dificil") {
			this.setNivel(3);
		}
		
		vistaJuego.resetTablero();
		vistaJuego.iniciarPartida();
	}

}
