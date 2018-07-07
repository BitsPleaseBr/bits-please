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

	private JFrame frmMain = new JFrame();
	private JPanel popup = new JPanel();
	private JLabel lblLogo;

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
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setSize(1238, 700);
		frmMain.setLocationRelativeTo(null);
		frmMain.setLayout(null);
		frmMain.getContentPane().setBackground(new Color(221, 233, 232));

		setContentPane(new TelaInicio());
		
		frmMain.setVisible(true);
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
				
				mensagem("E-mail de recupera�ao enviado");
			}
		});
		
		setFonte(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar }, fonteTituloTxt);
		addPopup(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar});
	}
	
	
	public static void mensagem(String msg) {
		
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
	
	public static void setFonte(JComponent[] componente, Font font) {
		
		for (JComponent comp : componente) {
			
			comp.setFont(font);
		}
	}

	public static void centralizar(JComponent comp, JPanel pane) {

		int compWidth = comp.getWidth();
		int compY = comp.getY();
		int paneWidth = pane.getWidth();

		comp.setLocation(paneWidth / 2 - compWidth / 2, compY);
	}

	public static ImageIcon getIcon(String icon) {

		return new ImageIcon(imageDir + icon + ".png");
	}
}