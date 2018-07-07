package interfaces.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import interfaces.Tela;
import interfaces.componentes.EPasswordField;
import interfaces.componentes.ETextField;
import interfaces.componentes.MainPanel;

public class TelaConfirmarCadastro extends MainPanel {

	
	String email, senha;
	
	
	public TelaConfirmarCadastro(MainPanel pnl) {
		
		ETextField txtEmail = pnl.getObject("txtEmail");
		EPasswordField txtSenha = pnl.getObject("txtSenha");
		
		this.email = txtEmail.getText();
		this.senha = String.valueOf(txtSenha.getPassword());
	}
	
	@Override
	protected void configurar() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addComponents() {

		// Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBackground(Tela.corBackgroundCampo);
		campo.setBounds(381, 132, 475, 355);

		// Configurando cabecalho
		JLabel lblCabecalho = new JLabel("<html><center>Confirme os dados abaixo<br>por favor</center></html>");
		lblCabecalho.setFont(Tela.fonteTitulos);
		lblCabecalho.setLocation(0, 25);
		lblCabecalho.setSize(lblCabecalho.getPreferredSize());
		centralizar(lblCabecalho, this);

		// Configurando componentes
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(35, 115, 100, 25);

		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(35, 150, 405, 30);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(35, 210, 125, 25);

		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds(35, 245, 405, 30);

		JButton btnProximo = new JButton("Confirmar");
		btnProximo.setBounds(0, 300, 150, 35);
		centralizar(btnProximo, campo);

		// Adicionando listener para quando o botao Confirmar for clickado verificar se
		// o email e senha
		// informados correspondem com os do cadastro e voltar para a tela de login
		btnProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if ((txtEmail.getText().equals(email)) && (String.valueOf(txtSenha.getPassword()).equals(senha))) {

					TelaLogin tela = new TelaLogin();
					frame.setContentPane(tela);
					tela.construir();

					System.out.println("Foi enviado um e-mail de verificação. Por favor, confirme seu e-mail.");;
				} else {

					System.out.println("Voce preencheu algo errado.");;
				}
			}
		});

		add(lblCabecalho);
		add(lblEmail);
		add(txtEmail);
		add(lblSenha);
		add(txtSenha);
		add(btnProximo);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

}
