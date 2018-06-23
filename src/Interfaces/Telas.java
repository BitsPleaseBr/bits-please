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
import javax.swing.JTextField;
import javax.swing.Timer;

public class Telas {
	
	private JFrame frmMain = new JFrame();
	private JLabel popup = new JLabel();
	private JLabel lblLogo;

 	public static void main(String[] args) {
		
		new Telas();
	}

 	public Telas() {
 		
 		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setSize(1238,700);
		frmMain.setLocationRelativeTo(null);
		frmMain.setLayout(null);
		frmMain.getContentPane().setBackground(new Color(221,233,232));
		
		popup.setBounds((int) 346.5, 50, 545,250);
		popup.setOpaque(true);
		popup.setBackground(new Color(247,247,247));
	
		inicio();
		
		frmMain.setVisible(true);
 	}
 	
	private void inicio() {
		
		ImageIcon logo = new ImageIcon("src//Interfaces//img//logo.jpg");
		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());
		
		JPanel campo = new JPanel();
		campo.setBounds(410, logo.getIconHeight()+100, 415, 255);
		campo.setBackground(new Color(247,247,247));
		campo.setLayout(null);
		
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
		
		setLayout(new JComponent[] {lblLogo, campo});
	}

	private void login(){
		
		ImageIcon logo = new ImageIcon("src//Interfaces//img//logo.jpg");
		
		lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());
		
		JLabel campo = new JLabel();
		campo.setBounds(410, logo.getIconHeight()+100, 415, 255);
		campo.setOpaque(true);
		campo.setBackground(new Color(247,247,247));
		
		JLabel exemplo = new JLabel("LOGIN");
		exemplo.setBounds((int) campo.getBounds().getMinX()+150, (int) campo.getBounds().getMinY()+100, 50, 25);
		
		JButton btnCadastrar = new JButton("Novo? Cadastrar-se já");
		btnCadastrar.setBounds((int) campo.getBounds().getMaxX()-250, (int) campo.getBounds().getMinY()+25, 200, 25);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				preCadastroPaciente();
			}
		});
		
		//Recuperação de senha
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds((int) popup.getBounds().getMinX()+50, (int) popup.getBounds().getMinY()+40, 100,25);
		
		JTextField txtCPF = new JTextField();
		txtCPF.setBounds((int) popup.getBounds().getMinX()+50,(int) lblCPF.getBounds().getMaxY()+10, 175,25);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds((int) popup.getBounds().getMinX()+50, (int) txtCPF.getBounds().getMaxY()+25, 100,25);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds((int) popup.getBounds().getMinX()+50, (int) lblEmail.getBounds().getMaxY()+10, 300,30);
		
		JButton btnEnviar = new JButton(">");
		btnEnviar.setBounds((int) popup.getBounds().getMaxX()-75, (int) popup.getBounds().getMaxY()-50, 50,25); 
		
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("Enviado para o e-mail");
				
				login();
			}
		});
		
		JButton btnEsqueciSenha = new JButton("Esqueci minha senha");
		btnEsqueciSenha.setBounds((int) campo.getBounds().getMaxX()-250,(int) campo.getBounds().getMaxY()-50, 200,25);
		
		btnEsqueciSenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addPopup(new JComponent[] {lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar});
			}
		});

		setFonte(new JComponent[] {lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar}, 0, 20);
		setLayout(new JComponent[] {lblLogo, exemplo, btnCadastrar, btnEsqueciSenha, campo});
	}
	
	private void preCadastroPaciente() {
		
		JPanel campo = new JPanel();
		campo.setBounds(280,(int) 90, frmMain.getWidth()-563, frmMain.getHeight()-255);
		campo.setBackground(new Color(247,247,247));
		
		JLabel lblCabeçalho = new JLabel("<html><center>Para poder concluir o cadastro informe<br>os dados abaixo por favor.</center></html>");
		lblCabeçalho.setFont(new Font("Georgean", Font.BOLD, 23));
		lblCabeçalho.setBounds(120, 25, frmMain.getWidth()-563,70);
		
		int coluna1 = 35;
		int coluna2 = 245;
		
		int linha1 = 120;
		int linha2 = 225;		
		
		int widthCampos = 175;
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(coluna1, linha1, 100,25);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(coluna1, linha1 + 35, widthCampos, 25);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(coluna2, linha1, 125,25);
		
		JTextField txtSobrenome = new JTextField();
		txtSobrenome.setBounds(coluna2, linha1 + 35, widthCampos,25);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento:");
		lblDataNasc.setBounds(coluna1, linha2, 200,25);
		
		JTextField txtDataNasc = new JTextField();
		txtDataNasc.setBounds(coluna1, linha2 + 35, widthCampos, 25);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(coluna2, linha2, 100, 25);
		
		JTextField txtCPF = new JTextField();
		txtCPF.setBounds(coluna2, linha2 + 35, widthCampos, 25);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds((int) txtCPF.getBounds().getMaxX()+50, (int) txtSobrenome.getBounds().getMaxY()+40, 100,25);
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setBounds((int) txtCPF.getBounds().getMaxX()+50, (int) lblTelefone.getBounds().getMaxY()+10, 130,25);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds((int) campo.getBounds().getMinX()+35, (int) txtDataNasc.getBounds().getMaxY()+50, 125,25);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds((int) campo.getBounds().getMinX()+35, (int) lblEmail.getBounds().getMaxY()+10, 300,30);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds((int) txtEmail.getBounds().getMaxX()+25, (int) txtCPF.getBounds().getMaxY()+50, 125,25);
		
		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds((int) txtEmail.getBounds().getMaxX()+25, (int) lblSenha.getBounds().getMaxY()+10, 250,30);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setBounds((int) (campo.getBounds().getCenterX()-62.5), (int) campo.getBounds().getMaxY()+10, 125,35);
		
		btnProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				confirmarCadastro();
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
		
		setFonte(new JComponent[] {lblNome,  txtNome, lblSobrenome, txtSobrenome, lblDataNasc, txtDataNasc, lblCPF, txtCPF, lblTelefone, txtTelefone, 
								   lblEmail, txtEmail, lblSenha, txtSenha, btnProximo}, 0, 20);
		setLayout(new JComponent[] {campo});
	}
	
	private void confirmarCadastro() {
		
		JLabel campo = new JLabel();
		campo.setOpaque(true);
		campo.setBackground(new Color(247,247,247));
		campo.setBounds((int) 381.5, (int) 132.5, 475, 355);
		
		JLabel lblCabeçalho = new JLabel("<html>Confirme os dados abaixo para<br><center>certificação porfavor.</center></html>");
		lblCabeçalho.setFont(new Font("Georgean", Font.BOLD, 23));
		lblCabeçalho.setBounds((int) campo.getBounds().getMinX()+65, (int) campo.getBounds().getMinY()+25, 435,70); 
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds((int) campo.getBounds().getMinX()+35, (int) lblCabeçalho.getBounds().getMaxY()+25, 100,25);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds((int) campo.getBounds().getMinX()+35, (int) lblEmail.getBounds().getMaxY()+10, 300,30);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds((int) campo.getBounds().getMinX()+35, (int) txtEmail.getBounds().getMaxY()+30, 125,25);
		
		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds((int) campo.getBounds().getMinX()+35, (int) lblSenha.getBounds().getMaxY()+10, 250,30);
		
		JLabel lblEmailEnviado = new JLabel("<html><center>Foi enviado um e-mail de verificação.<br><br>Por favor, confirme seu e-mail.<br><br>Estamos aqui para ajuda-lo.</center></html>");
		lblEmailEnviado.setBounds((int) (popup.getBounds().getCenterX()-162.5), (int) popup.getBounds().getCenterY()-70, 325,130);
				
		JButton btnProximo = new JButton(">");
		btnProximo.setBounds((int) (campo.getBounds().getMaxX()-115), (int) campo.getBounds().getMaxY()-45, 100,35);
		
		btnProximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				login();
				
				addPopup(new JComponent[] {lblEmailEnviado});
				
				Timer temporizador = new Timer(3000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						login();
					}
				});
				temporizador.setRepeats(false);
				temporizador.start();
			}
		});
		
		setFonte(new JComponent[] {lblEmail, txtEmail, lblSenha, txtSenha, btnProximo, lblEmailEnviado}, 0, 20);
		setLayout(new JComponent[] {lblCabeçalho, lblEmail, txtEmail, lblSenha, txtSenha, btnProximo, campo});
	}

	private void addPopup(JComponent[] componentes) {
				
		frmMain.remove(lblLogo);
		
		for(int i=0; i<componentes.length; i++) {
			frmMain.add(componentes[i]);
		}
		frmMain.add(popup);
		frmMain.add(lblLogo);
		
		frmMain.getContentPane().repaint();
	}

	private void setLayout(JComponent[] componentes) {
		
		frmMain.getContentPane().removeAll();
		frmMain.getContentPane().repaint();
		
		for(int i=0; i<componentes.length; i++) {
			frmMain.add(componentes[i]);
		}
		
	}

	private void setFonte(JComponent[] componente, int estilo, int tamanho) {
		
		for(int i=0; i<componente.length; i++) {
			componente[i].setFont(new Font("Georgean", estilo, tamanho));
		}
	}

}