package br.com.bitsplease.interfaces.componentes;

import java.awt.Component;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.bitsplease.controllers.MainController;

public abstract class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private HashMap<Object, Object> objetos = new HashMap<>();
	protected JFrame frame;
	protected MainController controlador = new MainController();
	
	public MainPanel() {
		
		frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		construir();
	}
	
	
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

	
	private void construir() {
		
		configurar();
		addComponents();
		addListeners();
	}

	protected abstract void configurar();
	protected abstract void addComponents();
	protected abstract void addListeners();
}