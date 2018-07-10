package interfaces.componentes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public interface ScreenConfiguration {

  // Diretório onde as imagens ficam
  public String imageDir = "src//Interfaces//img//";

  public Color corBackgroundCampo = new Color(247, 247, 247);

  // Fontes usadas nas telas
  public Font fonteTitulos = new Font("Gregorian", Font.PLAIN, 23);
  public Font fonteTituloTxt = new Font("Gregorian", Font.PLAIN, 20);
  public Font fonteTituloTxtLogin = new Font("Gregorian", Font.PLAIN, 15);

  public default void setFonte(JComponent[] componente, Font font) {

    for (JComponent comp : componente) {

      comp.setFont(font);
    }
  }

  public default void centralizar(JComponent comp, Container pane) {

    int compWidth = comp.getWidth();
    int compY = comp.getY();
    int paneWidth = pane.getWidth();

    comp.setLocation(paneWidth / 2 - compWidth / 2, compY);
  }

  public default ImageIcon getIcon(String icon) {

    return new ImageIcon(imageDir + icon + ".png");
  }
}
