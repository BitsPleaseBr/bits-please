package interfaces.componentes;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.JDialog;

import control.MainController;
import control.MainValidator;

public abstract class Popup extends JDialog implements ScreenConfiguration {

  private static final long serialVersionUID = 1L;

  private HashMap<Object, Object> objetos = new HashMap<>();
  protected MainController controlador = new MainController();
  protected MainValidator validador = new MainValidator();

  public Popup() {

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

  public void construir() {

    setBackground(new Color(221, 233, 232));

    configurar();
    addComponents();
    addListeners();

    setVisible(true);
  }

  protected Popup getThis() {

    return this;
  }

  protected abstract void configurar();

  protected abstract void addComponents();

  protected abstract void addListeners();
}
