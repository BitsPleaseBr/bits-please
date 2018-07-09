package control;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interfaces.Tela;
import interfaces.componentes.MainPanel;

public class MainController {

	public void login(MainPanel pnl) {

		JTextField txtEmail = (JTextField) pnl.getObject("txtEmail");
		JPasswordField txtSenha = (JPasswordField) pnl.getObject("txtSenha");

		if ((txtEmail.getText().matches("^\\S+@[a-zA-Z]+[\\.[a-zA-Z]{2,3}]+$"))
				&& (String.valueOf(txtSenha.getPassword()).matches("^\\w+$"))) {

			System.out.println("pode logar");
		} else {

			System.out.println("E-mail ou senha inválidos.");
		}
	}

}
