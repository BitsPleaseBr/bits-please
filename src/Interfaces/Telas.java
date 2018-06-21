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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Telas {
	
	private static JFrame frmMain = new JFrame();

	public static void main(String[] args) {
		
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setSize(1238,700);
		frmMain.setLocationRelativeTo(null);
		frmMain.setLayout(null);
		frmMain.getContentPane().setBackground(new Color(221,233,232));
		
		preCadastroPaciente();
		
		frmMain.setVisible(true);
	}

	private static void inicio() {
		
		ImageIcon logo = new ImageIcon("src//Interfaces//img//logo.jpg");
		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());
		
		JLabel campo = new JLabel();
		campo.setBounds((int) 411.5,logo.getIconHeight()+100,415,255);
		campo.setOpaque(true);
		campo.setBackground(new Color(247,247,247));
		
		JButton btnProfissional = new JButton("Profissional");
		btnProfissional.setBounds((int) campo.getBounds().getMinX()+50,(int) campo.getBounds().getMinY()+50,(int) campo.getBounds().getWidth()-100,50);
		
		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.setBounds((int) campo.getBounds().getMinX()+50,(int) campo.getBounds().getMaxY()-100,(int) campo.getBounds().getWidth()-100,50);
		
		btnPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cadastro();
			}
		});
		
		setLayout(new JComponent[] {lblLogo, btnPaciente, btnProfissional, campo});
	}

	private static void cadastro(){
		
		ImageIcon logo = new ImageIcon("src//Interfaces//img//logo.jpg");
		
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());
		
		JLabel campo = new JLabel();
		campo.setBounds((int) 411.5,logo.getIconHeight()+100,415,255);
		campo.setOpaque(true);
		campo.setBackground(new Color(247,247,247));
		
		JLabel exemplo = new JLabel("LOGIN");
		exemplo.setBounds((int) campo.getBounds().getMinX()+150,(int) campo.getBounds().getMinY()+100,50,25);
		
		JButton btnCadastrar = new JButton("Novo? Cadastrar-se já");
		btnCadastrar.setBounds((int) campo.getBounds().getMaxX()-250,(int) campo.getBounds().getMinY()+25, 200,25);
		
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				preCadastroPaciente();
			}
		});
		
		setLayout(new JComponent[] {lblLogo, exemplo, btnCadastrar, campo});
	}
	
	private static void preCadastroPaciente() {
		
		JLabel campo = new JLabel();
		campo.setBounds((int) 281.5,(int) 90, frmMain.getWidth()-563, frmMain.getHeight()-255);
		campo.setOpaque(true);
		campo.setBackground(new Color(247,247,247));
		
		JLabel lblCabeçalho = new JLabel("<html>Para poder concluir o cadastro informe<br><center>os dados abaixo porfavor.</center></html>");
		lblCabeçalho.setFont(new Font("Georgean", Font.BOLD, 23));
		lblCabeçalho.setBounds((int) (campo.getBounds().getMinX()+120),(int) campo.getBounds().getMinY()+25,435,70);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds((int) campo.getBounds().getMinX()+35, lblCabeçalho.getY()+lblCabeçalho.getHeight()+25, 100,25);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds((int) campo.getBounds().getMinX()+35, lblNome.getY()+lblNome.getHeight()+10,150,25);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds((int) txtNome.getBounds().getMaxX()+50, (int) (lblCabeçalho.getBounds().getMaxY()+25), 125,25);
		
		JTextField txtSobrenome = new JTextField();
		txtSobrenome.setBounds((int) txtNome.getBounds().getMaxX()+50, (int) (lblSobrenome.getBounds().getMaxY()+10), 175,25);
		
		JLabel lblDataNasc = new JLabel("Data de Nascimento:");
		lblDataNasc.setBounds((int) campo.getBounds().getMinX()+35, (int) txtNome.getBounds().getMaxY()+40, 200,25);
		
		JTextField txtDataNasc = new JTextField();
		txtDataNasc.setBounds((int) campo.getBounds().getMinX()+35, (int) (lblDataNasc.getBounds().getMaxY()+10), 125,25);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds((int) lblDataNasc.getBounds().getMaxX()+50, (int) txtSobrenome.getBounds().getMaxY()+40, 100,25);
		
		JTextField txtCPF = new JTextField();
		txtCPF.setBounds((int) lblDataNasc.getBounds().getMaxX()+50,(int) lblCPF.getBounds().getMaxY()+10, 175,25);
		
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
		
		setFonte(new JComponent[] {lblNome,  txtNome, lblSobrenome, txtSobrenome, lblDataNasc, txtDataNasc, lblCPF, txtCPF, lblTelefone, txtTelefone, lblEmail, txtEmail, lblSenha, txtSenha, btnProximo}, 0, 20);
		setLayout(new JComponent[] {lblCabeçalho, lblNome, txtNome, lblSobrenome, txtSobrenome, lblDataNasc, txtDataNasc, lblCPF, txtCPF, lblTelefone, txtTelefone, lblEmail, txtEmail, lblSenha, txtSenha, btnProximo, campo});
	}
	
	private static void confirmarCadastro() {
		
		
	}
	
	private static void setLayout(JComponent[] componentes) {
		
		frmMain.getContentPane().removeAll();
		frmMain.getContentPane().repaint();
		
		for(int i=0; i<componentes.length; i++) {
			frmMain.add(componentes[i]);
		}
		
	}

	private static void setFonte(JComponent[] componente, int estilo, int tamanho) {
		
		for(int i=0; i<componente.length; i++) {
			componente[i].setFont(new Font("Georgean", estilo, tamanho));
		}
	}
}