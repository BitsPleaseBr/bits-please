package interfaces.componentes;

import java.awt.Color;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class EPasswordField extends JPasswordField {

  public EPasswordField() {

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
