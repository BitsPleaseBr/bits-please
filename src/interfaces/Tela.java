package interfaces;

import java.util.ArrayList;

import javax.swing.JFrame;

import interfaces.componentes.LblMouseListener;
import interfaces.componentes.Popup;
import interfaces.telas.TelaInicio;

public class Tela extends JFrame {	

	private static final long serialVersionUID = 1L;

	private ArrayList<Popup> popups = new ArrayList<>();
	
	
	public static void main(String[] args) {

		new Tela();
	}

	public Tela() {

		//Configurando a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1238, 700);
		setLocationRelativeTo(null);

		addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

			@Override
			public void run() {
				
				disposePopups();
			}
			
			
		}));
		
		TelaInicio inicio = new TelaInicio();
		setContentPane(inicio);
		inicio.construir();
		
		setVisible(true);
	}
	
	public Tela addPopup(Popup popup) {
		
		popups.add(popup);
		
		return this;
	}
	
	
	private void disposePopups() {
		
		for (Popup popup : popups) {
			
			popup.dispose();
			popup = null;
		}
	}
}