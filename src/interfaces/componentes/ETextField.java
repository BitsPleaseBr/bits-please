package interfaces.componentes;

import java.awt.Color;

import javax.swing.JTextField;

public class ETextField extends JTextField {

  private static final long serialVersionUID = 1L;

  public ETextField() {

    config();
  }

  public void erro() {

    setBackground(new Color(200, 150, 150));
  }

  public void limpar() {

    setBackground(Color.WHITE);
  }

  private void config() {

    addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

      @Override
      public void run() {

        limpar();
      }

    }));
  }
}
