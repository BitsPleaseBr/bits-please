package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import control.bean.PacienteBean;
import model.conexao.ConnectionFactory;

public class PacienteDao {

  private static Connection conexao;
  private static String nomeTabela = "pre_cadastro_users";

  // Instancia a conexão com o banco de dados
  static {
    conexao = ConnectionFactory.getConnection();
  }
  // Construtor oculto para manter o padrão singleton
  private PacienteDao() {

    
  }

  // Método para efetuar o pré cadastro que permite o acesso de usuário no
  // sistema
  public static void pre_cadastrar(PacienteBean paciente) {

    String sql =
            "INSERT INTO " + nomeTabela + "(nomeUser, sobrenomeUser, nascimentoUser, cpfUser, telefoneUser, emailUser, pswdUSer) VALUES(?, ?, ?, ?, ?, ?, ?)";

    // Tentar realizar o pré-cadastro
    try {
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setString(1, paciente.getNome());
      pstmt.setString(2, paciente.getSobrenome());
      pstmt.setDate(3, paciente.getDataNasc());
      pstmt.setString(4, paciente.getCpf());
      pstmt.setInt(5, paciente.getTelefone());
      pstmt.setString(6, paciente.getEmail());
      // Converte a string de hash de senha em um binário para ser armazenado no
      // bando de dados
      pstmt.setBytes(7, paciente.getSenhaBytes());

      pstmt.execute();
      pstmt.close();

    } catch (Exception e) {
      System.out.println("Cadastro não realizado");
      e.printStackTrace();
    }
  }
}