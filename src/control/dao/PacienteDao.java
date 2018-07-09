package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import control.bean.PacienteBean;

import model.conexao.ConnectionFactory;

public class PacienteDao {

	private Connection conexao;
	
	//Construtor contendo a instancia da classe ConnectionFactory
	public PacienteDao (){
		
		conexao = ConnectionFactory.getConnection();	
	}
	
	//Método para efetuar o pré cadastro que permite o acesso de usuário no sistema
	public void pre_cadastrar(PacienteBean obj) {
		
		String sql = "INSERT INTO usuarios(nome, sobrenome, dataNasc, cpf, telefone, email, senha) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		//Tentar realizar o pré-cadastro
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getSobrenome());
			pstmt.setDate(3, obj.getDataNasc());
			pstmt.setInt(4, obj.getCpf());
			pstmt.setInt(5, obj.getTelefone());
			pstmt.setString(6, obj.getEmail());
			pstmt.setString(7, obj.getSenha());
			
			pstmt.execute();
			pstmt.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro falhou");
		}
	}
}	