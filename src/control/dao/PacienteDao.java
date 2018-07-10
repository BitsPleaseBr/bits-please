package control.dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import control.bean.PacienteBean;
import model.conexao.ConnectionFactory;

public class PacienteDao {

  private Connection conexao;

  // Construtor contendo a instancia da classe ConnectionFactory
  public PacienteDao() {

    conexao = ConnectionFactory.getConnection();
  }

  // Método para efetuar o pré cadastro que permite o acesso de usuário no
  // sistema
  public void pre_cadastrar(PacienteBean paciente) {

    String sql =
            "INSERT INTO usuarios(nomeUser, sobrenomeUser, nascimentoUser, cpfUser, telefoneUser, emailUser, pswdUSer) VALUES(?, ?, ?, ?, ?, ?, ?)";

    // Tentar realizar o pré-cadastro
    try {
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setString(1, paciente.getNome());
      pstmt.setString(2, paciente.getSobrenome());
      pstmt.setDate(3, paciente.getDataNasc());
      pstmt.setInt(4, paciente.getCpf());
      pstmt.setInt(5, paciente.getTelefone());
      pstmt.setString(6, paciente.getEmail());
      // Converte a string de hash de senha em um binário para ser armazenado no
      // bando de dados
      pstmt.setBytes(7, paciente.getSenha().getBytes(StandardCharsets.UTF_8));

      pstmt.execute();
      pstmt.close();

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Cadastro falhou");
    }
  }
}