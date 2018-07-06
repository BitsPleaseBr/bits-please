package br.com.bitsplease.interfaces.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.bitsplease.interfaces.Tela;
import br.com.bitsplease.interfaces.componentes.EPasswordField;
import br.com.bitsplease.interfaces.componentes.ETextField;
import br.com.bitsplease.interfaces.componentes.LblMouseListener;
import br.com.bitsplease.interfaces.componentes.MainPanel;

public class PanelLogin extends MainPanel {

	@Override
	protected void configurar() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addComponents() {

		// Obtendo icone da logo
		ImageIcon logo = ((Tela) this.frame).getIcon("logo");

		// Configurando label da logo
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());

		// Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(410, logo.getIconHeight() + 100, 415, 255);
		campo.setBackground(Tela.corBackgroundCampo);

		// Configurando componentes
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(0, 25, 415, 25);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(Tela.fonteTitulos);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(Tela.fonteTituloTxtLogin);
		lblEmail.setSize(lblEmail.getPreferredSize());
		lblEmail.setLocation(50, 77);

		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(115, 75, 250, 30);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(Tela.fonteTituloTxtLogin);
		lblSenha.setSize(lblSenha.getPreferredSize());
		lblSenha.setLocation(50, 127);

		EPasswordField txtSenha = new EPasswordField();
		txtSenha.setBounds(115, 125, 250, 30);

		JLabel lblEsqueciSenha = new JLabel("Esqueci minha senha");
		lblEsqueciSenha.setLocation(125, 160);
		lblEsqueciSenha.setSize(lblEsqueciSenha.getPreferredSize());

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(55, 200, 150, 30);

		JLabel lblCadastrar = new JLabel("Novo? Cadastrar-se já");
		lblCadastrar.setLocation(230, 207);
		lblCadastrar.setSize(lblCadastrar.getPreferredSize());

		add(lblLogin);
		add(lblCadastrar, "lblCadastrar");
		add(lblEsqueciSenha, "lblEsqueciSenha");
		add(lblEmail);
		add(txtEmail);
		add(lblSenha);
		add(txtSenha);
		add(btnEntrar, "btnEntrar");
	}

	@Override
	protected void addListeners() {

		// Adicionando listener para quando o label de Cadastrar for clickado abrir a
		// tela de cadastro do usuário
		((JLabel) getObject("lblCadastrar"))
				.addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

					@Override
					public void run() {

						preCadastroPaciente();
					}
				}));

		// Adicionando listener para quando o label de Esqueci Minha Senha for clickado
		// abrir o popup de Esqueci Minha Senha
		((JLabel) getObject("lblEsqueciSenha"))
				.addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

					@Override
					public void run() {

						popupEsqueciSenha();
					}
				}));

		// Adicionando listener para quando o botao Entrar for clickado verificar se o
		// email e senha sao válidos e logar
		((JButton) getObject("btnEntrar")).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				controlador.login();
			}
		});
	}
}