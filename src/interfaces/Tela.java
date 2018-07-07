package interfaces;

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

import control.MainController;
import interfaces.componentes.EPasswordField;
import interfaces.componentes.ETextField;
import interfaces.componentes.LblMouseListener;
import interfaces.componentes.MainPanel;
import interfaces.telas.TelaInicio;
import interfaces.telas.TelaLogin;

public class Tela extends JFrame {

	private JPanel popup = new JPanel();

	//Diretório onde as imagens ficam
	private static String imageDir = "src//Interfaces//img//";

	public static Color corBackgroundCampo = new Color(247, 247, 247);

	//Fontes usadas nas telas
	public static Font fonteTitulos = new Font("Gregorian", Font.PLAIN, 23);
	public static Font fonteTituloTxt = new Font("Gregorian", Font.PLAIN, 20);
	public static Font fonteTituloTxtLogin = new Font("Gregorian", Font.PLAIN, 15);
	
	
	public static void main(String[] args) {

		new Tela();
	}

	public Tela() {

		//Configurando a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1238, 700);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(221, 233, 232));

		TelaInicio inicio = new TelaInicio();
		setContentPane(inicio);
		inicio.construir();
		
		setVisible(true);
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
				
				System.out.println("E-mail de recupera�ao enviado");
			}
		});
		
		setFonte(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar }, fonteTituloTxt);
	}
	
	public static ImageIcon getIcon(String icon) {

		return new ImageIcon(imageDir + icon + ".png");
	}
}