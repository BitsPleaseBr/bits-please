package Interfaces;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LblMouseListener implements MouseListener {

	public static final int CLICK = 1, ENTER = 2, EXIT = 3, PRESS = 4, RELEASE = 5;
	
	private Runnable runnable;
	private int acao;
	
	public LblMouseListener(int acao, Runnable runnable) {
		
		this.acao = acao;
		this.runnable = runnable;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (acao == CLICK) {
			
			runnable.run();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (acao == ENTER) {
			
			runnable.run();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (acao == EXIT) {
			
			runnable.run();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (acao == PRESS) {
			
			runnable.run();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (acao == RELEASE) {
			
			runnable.run();
		}
	}
}
