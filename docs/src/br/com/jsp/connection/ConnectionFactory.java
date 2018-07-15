package br.com.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String url = "jdbc:mysql://localhost:3306/conceitos_jsp";
	private final String user = "root";
	private final String password = "proway";
	
	public Connection obterConexao() {
		
		Connection conexao = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		
		}catch(Exception e) {
			System.out.println("Falha no ConnectionFactory, no try do driver. hihi");
		}
		
		try {
			
			conexao = DriverManager.getConnection(url, user, password);
			
		}catch(SQLException erroSQL) {
			System.out.println("Falha no ConnectionFactory, no try da conexão");
			throw new RuntimeException(erroSQL);
		}
		
		return conexao;
	}
}
