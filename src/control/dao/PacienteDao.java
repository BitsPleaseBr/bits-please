package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.bean.PacienteBean;
import control.crypto.PswdStorage;
import interfaces.componentes.MainPanel;
import model.conexao.ConnectionFactory;

public class PacienteDao {

  private static Connection conexao = ConnectionFactory.getConnection();;
  private static String nomeTabela = "pre_cadastro_users";
  private static PacienteDao dao = new PacienteDao();

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
  
  public static void login(String email, String senha) {
		
	  String sql = "select emailUser, pswdUser from "+nomeTabela+" where emailUser = ?";
	  
	  System.out.println(email);
	  System.out.println(senha);
	  
	  try {
		  PreparedStatement pstmt = conexao.prepareStatement(sql);
		  pstmt.setString(1, email);

		  ResultSet rs = pstmt.executeQuery();
		  
		  if(!rs.next()) {
			  System.out.println("not login");
		  }else {
			  
			  if(PswdStorage.compararHashClient(senha, rs.getBytes(2))) {
				  System.out.println("success");
			  }else {
				  System.out.println("senha wrong");
			  }
		  }
		  
		  pstmt.close();
	  }catch(Exception e) {
		  System.out.println("Falha ao obter login");
		  e.printStackTrace();
	  }
}
  
  public static PacienteDao getInst() {
    return dao;
  }

}