package control;

import javax.swing.JComponent;

import interfaces.componentes.EPasswordField;
import interfaces.componentes.ETextField;
import interfaces.componentes.MainPanel;

public class MainValidator {

	public boolean validarInfoUser(MainPanel pnl) {

		boolean retorno = true;

		JComponent[] componentes = { pnl.getObject("txtNome"), pnl.getObject("txtSobrenome"),
				pnl.getObject("txtDataNasc"), pnl.getObject("txtCPF"),
				pnl.getObject("txtTelefone"), pnl.getObject("txtEmail"), pnl.getObject("txtSenha") };

		// Obtém as informações inseridas
		String nome = ((ETextField) componentes[0]).getText();
		String sobrenome = ((ETextField) componentes[1]).getText();
		String dataNasc = ((ETextField) componentes[2]).getText();
		String CPF = ((ETextField) componentes[3]).getText();
		String Telefone = ((ETextField) componentes[4]).getText();
		String email = ((ETextField) componentes[5]).getText();
		String senha = String.valueOf(((EPasswordField) componentes[6]).getPassword());

		for (JComponent comp : componentes) {

			try {

				((ETextField) comp).limpar();
			} catch (Exception e) {

				((EPasswordField) comp).limpar();
			}
		}

		// Verifica se o nome inserido é válido
		if (!nome.matches("^[a-zA-Z]+$")) {

			((ETextField) componentes[0]).erro();
			retorno = false;
		}

		// Verifica se o sobrenome inserido é válido
		if (!sobrenome.matches("^[a-zA-Z]+$")) {

			((ETextField) componentes[1]).erro();
			retorno = false;
		}

		// Verifica se a data de nascimento inserida é válida
		if (!dataNasc.matches("^\\d{2}/\\d{2}/\\d{4}$")) {

			((ETextField) componentes[2]).erro();
			retorno = false;
		}

		// Verifica se o cpf inserido é válido
		if (!CPF.matches("^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")) {

			((ETextField) componentes[3]).erro();
			retorno = false;
		}

		// Verifica se o telefone inserido é válido
		if (!Telefone.matches("^\\d{4,5}-\\d{4}$")) {

			((ETextField) componentes[4]).erro();
			retorno = false;
		}

		// Verifica se o email inserido é válido
		if (!email.matches("^\\S+@[a-zA-Z]+[\\.[a-zA-Z]{2,3}]+$")) {

			((ETextField) componentes[5]).erro();
			retorno = false;
		}

		// Verifica se a senha inserida é válida
		if (!senha.matches("^\\w+$")) {

			((EPasswordField) componentes[6]).erro();
			retorno = false;
		}

		return retorno;
	}
}