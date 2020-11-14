package Controlador;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Model.Juego;
import Vista.VistaJuego;

public class ControladorJuego implements MouseListener{
	
	private VistaJuego vistaJuego;
	private Juego juego;
	
	public ControladorJuego() {
		this.juego =  new Juego();
		//Iniciamos el juego con los valores por defecto 9x9 10minas
		juego.iniciarJuego(9, 9); 
	}
	
	public void setVistaJuego(VistaJuego _vista) {
		this.vistaJuego=_vista;
	}
	
	public Juego getJuego() {
		return this.juego;
	}
	
	@Override
  	public void mouseClicked(MouseEvent e) {
		JButton selectedBtn = (JButton) e.getSource();

		int fila = selectedBtn.getX() / 32;
		int columna = selectedBtn.getY() / 32;

		if (e.getButton() == MouseEvent.BUTTON1) {
			System.out.println("Abrir casilla");
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Marcar casilla");
		}
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

}
