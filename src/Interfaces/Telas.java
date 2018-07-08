package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Telas {

	private JFrame frmMain = new JFrame();
	private JPanel popup = new JPanel();
	private JLabel lblLogo;

	//Diretório onde as imagens ficam
	private String imageDir = "src//Interfaces//img//";

	private Color corBackgroundCampo = new Color(247, 247, 247);

	//Fontes usadas nas telas
	private Font fonteTitulos = new Font("Gregorian", Font.PLAIN, 23);
	private Font fonteTituloTxt = new Font("Gregorian", Font.PLAIN, 20);
	private Font fonteTituloTxtLogin = new Font("Gregorian", Font.PLAIN, 15);
	
	public static void main(String[] args) {

		new Telas();
	}

	public Telas() {

		//Configurando a janela
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setSize(1238, 700);
		frmMain.setLocationRelativeTo(null);
		frmMain.setLayout(null);
		frmMain.getContentPane().setBackground(new Color(221, 233, 232));

		//Configurando o popup
		popup.setBounds(346, 50, 545, 250);
		popup.setBackground(corBackgroundCampo);

		inicio();

		frmMain.setVisible(true);
	}

	
	private void inicio() {

		//Obtendo icone da logo
		ImageIcon logo = getIcon("logo");

		//Configurando label da logo
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());

		//Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(410, logo.getIconHeight() + 100, 415, 255);
		campo.setBackground(corBackgroundCampo);
		campo.setLayout(null);

		//Configurando botoes
		JButton btnProfissional = new JButton("Profissional");
		btnProfissional.setBounds(50, 50, 315, 50);

		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.setBounds(50, 150, 315, 50);

		btnPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				login();
			}
		});

		campo.add(btnProfissional);
		campo.add(btnPaciente);

		setLayout(new JComponent[] { lblLogo, campo});
	}

	private void login() {

		//Obtendo icone da logo
		ImageIcon logo = getIcon("logo");

		//Configurando label da logo
		lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());

		//Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(410, logo.getIconHeight() + 100, 415, 255);
		campo.setBackground(corBackgroundCampo);

		//Configurando componentes
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(0, 25, 415, 25);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(fonteTitulos);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(fonteTituloTxtLogin);
		lblEmail.setSize(lblEmail.getPreferredSize());
		lblEmail.setLocation(50, 77);
		
		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(115, 75, 250, 30);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(fonteTituloTxtLogin);
		lblSenha.setSize(lblSenha.getPreferredSize());
		lblSenha.setLocation(50, 127);
		
		EPasswordField txtSenha = new EPasswordField();
		txtSenha.setBounds(115, 125, 250, 30);
		
		JLabel lblEsqueciSenha = new JLabel("Esqueci minha senha");
		lblEsqueciSenha.setLocation(125, 160);
		lblEsqueciSenha.setSize(lblEsqueciSenha.getPreferredSize());

		//Adicionando listener para quando o label de Esqueci Minha Senha for clickado abrir o popup de Esqueci Minha Senha
		lblEsqueciSenha.addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

			@Override
			public void run() {

				popupEsqueciSenha();
			}
		}));

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(55, 200, 150, 30);
		
		//Adicionando listener para quando o botao Entrar for clickado verificar se o email e senha sao válidos e logar
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Verifica se o email e a senha sao válidos
				if ((txtEmail.getText().matches("^\\S+@[a-zA-Z]+[\\.[a-zA-Z]{2,3}]+$")) && (String.valueOf(txtSenha.getPassword()).matches("^\\w+$"))) {
					
					System.out.println("pode logar");
				} else {
					
					mensagem("E-mail ou senha inválidos.");
				}
			}
		});
		
		JLabel lblCadastrar = new JLabel("Novo? Cadastrar-se já");
		lblCadastrar.setLocation(230, 207);
		lblCadastrar.setSize(lblCadastrar.getPreferredSize());
		
		//Adicionando listener para quando o label de Cadastrar for clickado abrir a tela de cadastro do usuário
		lblCadastrar.addMouseListener(new LblMouseListener(LblMouseListener.CLICK, new Runnable() {

			@Override
			public void run() {

				preCadastroPaciente();
			}
		}));
		
		campo.add(lblLogin);
		campo.add(lblCadastrar);
		campo.add(lblEsqueciSenha);
		campo.add(lblEmail);
		campo.add(txtEmail);
		campo.add(lblSenha);
		campo.add(txtSenha);
		campo.add(btnEntrar);

		setLayout(new JComponent[] { lblLogo, campo });
	}

	private void preCadastroPaciente() {

		int larguraCampo = frmMain.getWidth() - 563;

		//Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(280, 75, larguraCampo, frmMain.getHeight() - 200);
		campo.setBackground(corBackgroundCampo);

		//Configurando cabeçalho
		JLabel lblCabeçalho = new JLabel("<html><center>Para poder concluir o cadastro informe<br>os dados abaixo por favor.</center></html>");
		lblCabeçalho.setFont(new Font("Georgean", Font.BOLD, 23));
		lblCabeçalho.setBounds(120, 25, larguraCampo, 70);

		//Calculando coordenadas das colunas e linhas para padronizar a tela
		int distColunas = 35;
		int distLinhas = 35;
		int distLblTxt = 10;

		int widthCampos = 175;
		int widthCamposLargos = (widthCampos * 3 + distColunas * 2) / 2 - distColunas / 2;
		int alturaCampos = 30;

		int coluna1 = 35;
		int coluna2 = coluna1 + widthCampos + distColunas;
		int coluna3 = coluna2 + widthCampos + distColunas;
		int coluna4 = coluna1 + widthCamposLargos + distColunas;

		int linha1Lbl = 120;
		int linha1Txt = linha1Lbl + alturaCampos + distLblTxt;

		int linha2Lbl = linha1Txt + alturaCampos + distLinhas;
		int linha2Txt = linha2Lbl + alturaCampos + distLblTxt;

		int linha3Lbl = linha2Txt + alturaCampos + distLinhas;
		int linha3Txt = linha3Lbl + alturaCampos + distLblTxt;

		int linha4 = linha3Txt + alturaCampos + distLinhas;

		//Configurando componentes
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(coluna1, linha1Lbl, 100, alturaCampos);

		ETextField txtNome = new ETextField();
		txtNome.setBounds(coluna1, linha1Txt, widthCamposLargos, alturaCampos);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(coluna4, linha1Lbl, 125, alturaCampos);

		ETextField txtSobrenome = new ETextField();
		txtSobrenome.setBounds(coluna4, linha1Txt, widthCamposLargos, alturaCampos);

		JLabel lblDataNasc = new JLabel("Data de Nascimento:");
		lblDataNasc.setBounds(coluna1, linha2Lbl, 200, alturaCampos);

		ETextField txtDataNasc = new ETextField();
		txtDataNasc.setBounds(coluna1, linha2Txt, widthCampos, alturaCampos);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(coluna2, linha2Lbl, 100, alturaCampos);

		ETextField txtCPF = new ETextField();
		txtCPF.setBounds(coluna2, linha2Txt, widthCampos, alturaCampos);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(coluna3, linha2Lbl, 100, alturaCampos);

		ETextField txtTelefone = new ETextField();
		txtTelefone.setBounds(coluna3, linha2Txt, widthCampos, alturaCampos);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(coluna1, linha3Lbl, 125, alturaCampos);

		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(coluna1, linha3Txt, widthCamposLargos, alturaCampos);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(coluna4, linha3Lbl, 125, alturaCampos);

		EPasswordField txtSenha = new EPasswordField();
		txtSenha.setBounds(coluna4, linha3Txt, widthCamposLargos, alturaCampos);

		JButton btnProximo = new JButton("Próximo");
		btnProximo.setBounds(larguraCampo / 2 - 60, linha4, 120, 35);

		//Adicionando listener para quando o botao Próximo for clickado verificar se os campos foram preenchidos corretamente e seguir para a próxima tela
		btnProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (validarInfoUser(new JComponent[] {txtNome, txtSobrenome, txtDataNasc, txtCPF, txtTelefone, txtEmail, txtSenha})) {
					
					confirmarCadastro(txtEmail.getText(), String.valueOf(txtSenha.getPassword()));
				} else {
					
					mensagem("Voce preencheu algum(s) campo(s) errado.");
				}
			}
		});

		campo.add(lblCabeçalho);
		campo.add(lblNome);
		campo.add(txtNome);
		campo.add(lblSobrenome);
		campo.add(txtSobrenome);
		campo.add(lblDataNasc);
		campo.add(txtDataNasc);
		campo.add(lblCPF);
		campo.add(txtCPF);
		campo.add(lblTelefone);
		campo.add(txtTelefone);
		campo.add(lblEmail);
		campo.add(txtEmail);
		campo.add(lblSenha);
		campo.add(txtSenha);
		campo.add(btnProximo);

		setFonte(new JComponent[] { lblNome, txtNome, lblSobrenome, txtSobrenome, lblDataNasc, txtDataNasc, lblCPF,
				txtCPF, lblTelefone, txtTelefone, lblEmail, txtEmail, lblSenha, txtSenha, btnProximo }, fonteTituloTxt);
		setLayout(new JComponent[] { campo });
	}

	private void confirmarCadastro(String email, String senha) {

		//Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBackground(corBackgroundCampo);
		campo.setBounds(381, 132, 475, 355);

		//Configurando cabeçalho
		JLabel lblCabeçalho = new JLabel("<html><center>Confirme os dados abaixo<br>por favor</center></html>");
		lblCabeçalho.setFont(fonteTitulos);
		lblCabeçalho.setLocation(0, 25);
		lblCabeçalho.setSize(lblCabeçalho.getPreferredSize());
		centralizar(lblCabeçalho, campo);
		
		//Configurando componentes
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

		//Adicionando listener para quando o botao Confirmar for clickado verificar se o email e senha 
		//informados correspondem com os do cadastro e voltar para a tela de login
		btnProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if ((txtEmail.getText().equals(email)) && (String.valueOf(txtSenha.getPassword()).equals(senha))) {
					
					login();
					
					mensagem("Foi enviado um e-mail de verificação. Por favor, confirme seu e-mail.");
				} else {
					
					mensagem("Voce preencheu algo errado.");
				}
			}
		});

		campo.add(lblCabeçalho);
		campo.add(lblEmail);
		campo.add(txtEmail);
		campo.add(lblSenha);
		campo.add(txtSenha);
		campo.add(btnProximo);
		
		setFonte(new JComponent[] {lblEmail, txtEmail, lblSenha, txtSenha, btnProximo}, fonteTituloTxt);
		setLayout(new JComponent[] {campo});
	}

	private void popupEsqueciSenha() {
		
		//Configurando componentes
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(0, 30, 300, 25);
		centralizar(lblCPF, popup);
		
		ETextField txtCPF = new ETextField();
		txtCPF.setBounds(0, 65, 300, 30);
		centralizar(txtCPF, popup);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(0, 115, 300, 25);
		centralizar(lblEmail, popup);
		
		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(0, 150, 300, 30);
		centralizar(txtEmail, popup);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(0, 200, 100, 30);
		centralizar(btnEnviar, popup);
		
		//Adicionando listener para quando o botao Enviar for clickado voltar para a tela de login
		//E mostrar uma mensagem informando que um email foi enviado
		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				login();
				
				mensagem("E-mail de recuperaçao enviado");
			}
		});
		
		setFonte(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar }, fonteTituloTxt);
		addPopup(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar});
	}
	
	
	private void mensagem(String msg) {
		
		//Configurando label que vai aparecer a mensagem
		JLabel lbl = new JLabel("<html><p style='max-width: 500px; margin: auto;'>" + msg + "</p></html>");
		lbl.setSize(lbl.getPreferredSize());
		lbl.setLocation(10, 10);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setForeground(Color.WHITE);
		
		int lblWidth = lbl.getWidth();
		int lblHeight = lbl.getHeight();
		
		//Configurando painel
		JPanel pane = new JPanel();
		pane.setSize(lblWidth + 20, lblHeight + 20);
		pane.setOpaque(true);
		pane.setBackground(new Color(50, 50, 50));
		
		pane.add(lbl);
		
		int paneX = frmMain.getWidth() / 2 - pane.getWidth() / 2;
		int paneY = frmMain.getHeight() - pane.getHeight() - 100;
		
		pane.setLocation(paneX, paneY);
		
		//Adicionando painel na primeira layer da tela para ficar na frente de tudo
		frmMain.getLayeredPane().add(pane, 0);
		frmMain.repaint();
		
		//Criando temporizador para quando passarem 5 segundos a mensagem sumir
		Timer timer = new Timer(5000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frmMain.getLayeredPane().remove(pane);
				frmMain.repaint();
			}
		});
		
		timer.setRepeats(false);
		timer.start();
	}
	
	private void addPopup(JComponent[] componentes) {

		frmMain.remove(lblLogo);

		popup.removeAll();
		
		for (int i = 0; i < componentes.length; i++) {

			popup.add(componentes[i]);
		}

		frmMain.add(popup);

		frmMain.getContentPane().repaint();
	}

	private void setLayout(JComponent[] componentes) {

		frmMain.getContentPane().removeAll();
		frmMain.getContentPane().repaint();

		for (int i = 0; i < componentes.length; i++) {
			frmMain.add(componentes[i]);
		}

	}
	
	private void setFonte(JComponent[] componente, Font font) {
		
		for (JComponent comp : componente) {
			
			comp.setFont(font);
		}
	}

	private void centralizar(JComponent comp, JPanel pane) {

		int compWidth = comp.getWidth();
		int compY = comp.getY();
		int paneWidth = pane.getWidth();

		comp.setLocation(paneWidth / 2 - compWidth / 2, compY);
	}

	private boolean validarInfoUser(JComponent[] componentes) {
		
		boolean retorno = true;
		
		//Obtém as informaçoes inseridas
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
		
		//Verifica se o nome inserido é válido
		if (!nome.matches("^[a-zA-Z]+$")) {
			
			((ETextField) componentes[0]).erro();
			retorno = false;
		}
		
		//Verifica se o sobrenome inserido é válido
		if (!sobrenome.matches("^[a-zA-Z]+$")) {

			((ETextField) componentes[1]).erro();
			retorno = false;
		}
		
		//Verifica se a data de nascimento inserida é válida
		if (!dataNasc.matches("^\\d{2}/\\d{2}/\\d{4}$")) {

			((ETextField) componentes[2]).erro();
			retorno = false;
		}
		
		//Verifica se o cpf inserido é válido
		if (!CPF.matches("^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")) {

			((ETextField) componentes[3]).erro();
			retorno = false;
		}
		
		//Verifica se o telefone inserido é válido
		if (!Telefone.matches("^\\d{4,5}-\\d{4}$")) {

			((ETextField) componentes[4]).erro();
			retorno = false;
		}
		
		//Verifica se o email inserido é válido
		if (!email.matches("^\\S+@[a-zA-Z]+[\\.[a-zA-Z]{2,3}]+$")) {

			((ETextField) componentes[5]).erro();
			retorno = false;
		}
		
		//Verifica se a senha inserida é válida
		if (!senha.matches("^\\w+$")) {
			
			((EPasswordField) componentes[6]).erro();
			retorno = false;
		}
		
		return retorno;
	}
	
	private ImageIcon getIcon(String icon) {

		return new ImageIcon(imageDir + icon + ".png");
	}
}