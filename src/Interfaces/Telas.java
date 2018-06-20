package Interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Telas {

	public static void main(String[] args) {
		
		JFrame frmMain = new JFrame();
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setSize(1238,700);
		frmMain.setLocationRelativeTo(null);
		frmMain.setLayout(null);
		frmMain.getContentPane().setBackground(new Color(221,233,232));
		
		inicio(frmMain);
		
		
		frmMain.setVisible(true);
	}

	private static void inicio (JFrame frm) {
		
		ImageIcon logo = new ImageIcon("P:/TCC/bits-please/src/Interfaces/img/logo.jpg");
		
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
				
				cadastro(frm);
			}
		});
		
		setLayout(frm, lblLogo, btnPaciente, btnProfissional, campo);
	}

	private static void cadastro(JFrame frm){
		
		ImageIcon logo = new ImageIcon("P:/TCC/bits-please/src/Interfaces/img/logo.jpg");
		
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
				
				
			}
		});
		
		setLayout(frm, lblLogo, exemplo, btnCadastrar, campo);
	}
	
	private static void preCadastroPaciente() {
		
		
	}
	
	private static void setLayout(JFrame janela, JComponent componente1, JComponent componente2, JComponent componente3, JComponent componente4) {
		
		//janela.removeAll();
		
		janela.add(componente1);
		janela.add(componente2);
		janela.add(componente3);
		janela.add(componente4);
	}
}