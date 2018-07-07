package interfaces.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.MainController;
import control.MainValidator;

public abstract class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private HashMap<Object, Object> objetos = new HashMap<>();
	protected JFrame frame;
	protected MainController controlador = new MainController();
	protected MainValidator validador = new MainValidator();
	
	
	public Component add(Component comp, String key) {
		
		addObject(key, comp);
		
		return super.add(comp);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(Object key) {
		
		return (T) objetos.get(key);
	}
	
	public void addObject(Object key, Object value) {
		
		objetos.put(key, value);
	}
	
	
	public void construir() {
		
		frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		setBackground(new Color(221, 233, 232));
		
		configurar();
		addComponents();
		addListeners();
		
		frame.revalidate();
	}
	

	public static void setFonte(JComponent[] componente, Font font) {
		
		for (JComponent comp : componente) {
			
			comp.setFont(font);
		}
	}

	public static void centralizar(JComponent comp, JPanel pane) {

		int compWidth = comp.getWidth();
		int compY = comp.getY();
		int paneWidth = pane.getWidth();

		comp.setLocation(paneWidth / 2 - compWidth / 2, compY);
	}
	
	protected MainPanel getThis() {
		
		return this;
	}

	protected abstract void configurar();
	protected abstract void addComponents();
	protected abstract void addListeners();
}