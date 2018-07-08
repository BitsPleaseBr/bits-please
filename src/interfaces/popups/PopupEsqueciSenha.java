package interfaces.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;

import interfaces.componentes.ETextField;
import interfaces.componentes.Popup;
import interfaces.componentes.ScreenConfiguration;

public class PopupEsqueciSenha extends Popup implements ScreenConfiguration {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void configurar() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setSize(331, 266);
		setTitle("Recuperaçao de senha");
	}

	@Override
	protected void addComponents() {

		// Configurando componentes
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(15, 15, 300, 25);
		centralizar(lblCPF, this);

		ETextField txtCPF = new ETextField();
		txtCPF.setBounds(15, 50, 300, 30);
		centralizar(txtCPF, this);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(15, 100, 300, 25);
		centralizar(lblEmail, this);

		ETextField txtEmail = new ETextField();
		txtEmail.setBounds(15, 135, 300, 30);
		centralizar(txtEmail, this);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(0, 185, 100, 30);
		centralizar(btnEnviar, this);


		setFonte(new JComponent[] { lblCPF, txtCPF, lblEmail, txtEmail, btnEnviar }, fonteTituloTxt);

		add(lblCPF);
		add(txtCPF);
		add(lblEmail);
		add(txtEmail);
		add(btnEnviar, "btnEnviar");
		
		setSize(346, 266);
	}

	@Override
	protected void addListeners() {
		
		((JButton) getObject("btnEnviar")).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();

				System.out.println("E-mail de recuperaçao enviado");
			}
		});
	}

}
