package interfaces.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.componentes.MainPanel;

@SuppressWarnings("serial")
public class TelaInicio extends MainPanel {

	@Override
	protected void configurar() {
		
		setLayout(null);
	}

	@Override
	protected void addComponents() {

		// Obtendo icone da logo
		ImageIcon logo = getIcon("logo");

		// Configurando label da logo
		JLabel lblLogo = new JLabel(logo);
		lblLogo.setBounds(244, 0, logo.getIconWidth(), logo.getIconHeight());

		// Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(410, logo.getIconHeight() + 100, 415, 255);
		campo.setBackground(corBackgroundCampo);
		campo.setLayout(null);

		// Configurando botoes
		JButton btnProfissional = new JButton("Profissional");
		btnProfissional.setBounds(50, 50, 315, 50);

		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.setBounds(50, 150, 315, 50);

		campo.add(btnProfissional);
		campo.add(btnPaciente);
		
		add(lblLogo);
		add(campo);
		addObject("btnProfissional", btnProfissional);
		addObject("btnPaciente", btnPaciente);
	}

	@Override
	protected void addListeners() {
		
		((JButton) getObject("btnPaciente")).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaLogin login = new TelaLogin();
				frame.setContentPane(login);
				login.construir();
			}
		});
	}

}
