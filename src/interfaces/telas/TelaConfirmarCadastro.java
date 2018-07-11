package interfaces.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import control.bean.PacienteBean;
import control.dao.PacienteDao;
import interfaces.componentes.EPasswordField;
import interfaces.componentes.ETextField;
import interfaces.componentes.MainPanel;

public class TelaConfirmarCadastro extends MainPanel {

  private static final long serialVersionUID = 1L;

  String email, senha;
  MainPanel pnl;

  public TelaConfirmarCadastro(MainPanel pnl) {

	this.pnl = pnl;
	  
    ETextField txtEmail = pnl.getObject("txtEmail");
    EPasswordField txtSenha = pnl.getObject("txtSenha");

    this.email = txtEmail.getText();
    this.senha = String.valueOf(txtSenha.getPassword());
  }

  @Override
  protected void configurar() {
    setLayout(null);

  }

  @Override
  protected void addComponents() {

    // Configurando painel principal
    JPanel campo = new JPanel();
    campo.setBackground(corBackgroundCampo);
    campo.setBounds(381, 132, 475, 355);
    campo.setLayout(null);

    // Configurando cabecalho
    JLabel lblCabecalho =
            new JLabel("<html><center>Confirme os dados abaixo<br>por favor</center></html>");
    lblCabecalho.setFont(fonteTitulos);
    lblCabecalho.setLocation(0, 25);
    lblCabecalho.setSize(lblCabecalho.getPreferredSize());
    centralizar(lblCabecalho, campo);

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
    
    setFonte(new JComponent[] {lblEmail, txtEmail, lblSenha, txtSenha, btnProximo}, fonteTituloTxt);

    campo.add(lblCabecalho);
    campo.add(lblEmail);
    campo.add(txtEmail);
    campo.add(lblSenha);
    campo.add(txtSenha);
    campo.add(btnProximo);
    
    add(campo);
    
    addObject("btnProximo", btnProximo);
    addObject("txtEmail", txtEmail);
    addObject("txtSenha", txtSenha);
  }

  @Override
  protected void addListeners() {

	    // Adicionando listener para quando o botao Confirmar for clickado verificar
	    // se
	    // o email e senha
	    // informados correspondem com os do cadastro e voltar para a tela de login
	    ((JButton) getObject("btnProximo")).addActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent arg0) {

	        if ((((ETextField) getObject("txtEmail")).getText().equals(email))
	                && (String.valueOf(((JPasswordField) getObject("txtSenha")).getPassword()).equals(senha))) {

	          TelaLogin tela = new TelaLogin();
	          frame.setContentPane(tela);
	          tela.construir();
	          
	          String temp = ((ETextField) pnl.getObject("txtDataNasc")).getText();
	          
	          String[] arraytemp = temp.split("/");
	          
	          Date data = Date.valueOf(arraytemp[2] +"-"+ arraytemp[1] +"-"+ arraytemp[0]);

	          String cpf = ((ETextField) pnl.getObject("txtCPF")).getText();

	          PacienteBean prepaciente = new PacienteBean();
	          prepaciente.setNome(((ETextField) pnl.getObject("txtNome")).getText());
	          prepaciente.setSobrenome(((ETextField) pnl.getObject("txtSobrenome")).getText());
	          prepaciente.setDataNasc(data);
	          prepaciente.setCpf(cpf);
	          prepaciente.setTelefone(Integer.parseInt(((ETextField) pnl.getObject("txtTelefone")).getText().replaceAll("-", "")));
	          prepaciente.setEmail(((ETextField) getObject("txtEmail")).getText());
	          prepaciente.setSenha(String.valueOf(((JPasswordField) getObject("txtSenha")).getPassword()));
	          
	          PacienteDao.pre_cadastrar(prepaciente);
	          
	          System.out.println("Foi enviado um e-mail de verificação. Por favor, confirme seu e-mail.");
	        
	        } else {

	          System.out.println("Voce preencheu algo errado.");
	          ;
	        }
	      }
	    });
  }

}