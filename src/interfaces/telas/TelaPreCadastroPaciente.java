package interfaces.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Tela;
import interfaces.componentes.EPasswordField;
import interfaces.componentes.ETextField;
import interfaces.componentes.MainPanel;

public class TelaPreCadastroPaciente extends MainPanel {

	@Override
	protected void configurar() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addComponents() {

		int larguraCampo = frame.getWidth() - 563;

		// Configurando painel principal
		JPanel campo = new JPanel();
		campo.setBounds(280, 75, larguraCampo, frame.getHeight() - 200);
		campo.setBackground(Tela.corBackgroundCampo);

		// Configurando cabe�alho
		JLabel lblCabecalho = new JLabel(
				"<html><center>Para poder concluir o cadastro informe<br>os dados abaixo por favor.</center></html>");
		lblCabecalho.setFont(new Font("Georgean", Font.BOLD, 23));
		lblCabecalho.setBounds(120, 25, larguraCampo, 70);

		// Calculando coordenadas das colunas e linhas para padronizar a tela
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

		// Configurando componentes
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

		JButton btnProximo = new JButton("Pr�ximo");
		btnProximo.setBounds(larguraCampo / 2 - 60, linha4, 120, 35);

		campo.add(lblCabecalho);
		campo.add(lblNome);
		campo.add(txtNome, "txtNome");
		campo.add(lblSobrenome);
		campo.add(txtSobrenome, "txtSobrenome");
		campo.add(lblDataNasc);
		campo.add(txtDataNasc, "txtDataNasc");
		campo.add(lblCPF);
		campo.add(txtCPF, "txtCPF");
		campo.add(lblTelefone);
		campo.add(txtTelefone, "txtTelefone");
		campo.add(lblEmail);
		campo.add(txtEmail, "txtEmail");
		campo.add(lblSenha);
		campo.add(txtSenha, "txtSenha");
		campo.add(btnProximo, "btnProximo");
	}

	@Override
	protected void addListeners() {

		// Adicionando listener para quando o botao Próximo for clickado verificar se os
		// campos foram preenchidos corretamente e seguir para a próxima tela
		((JButton) getObject("btnProximo")).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (validador.validarInfoUser(getThis())) {

					new TelaConfirmarCadastro(getThis());
				} else {

					Tela.mensagem("Voce preencheu algum(s) campo(s) errado.");
				}
			}
		});
	}

}
