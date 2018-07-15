package br.com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.jsp.bean.UsuarioBean;
import br.com.jsp.connection.ConnectionFactory;

public class UsuarioDao {

	Connection conectar;
	
	public UsuarioDao() {
		
		this.conectar = new ConnectionFactory().obterConexao();
	}
	
	public UsuarioBean login(String email, String senha) {
		
		UsuarioBean obj = new UsuarioBean();
		
		try {
			
			String sql = "select * from usuarios where emailUsuario = ? and senhaUsuario = ?";
			
			PreparedStatement pstmt = this.conectar.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			
			obj.setIdUsuario(rs.getInt(1));
			obj.setNomeUsuario(rs.getString(2));
			obj.setEmailUsuario(rs.getString(3));
			obj.setSenhaUsuario(rs.getString(4));
			obj.setNivelUsuario(rs.getInt(5));
			
		}catch(Exception e) {
			System.out.println("Falha no dao fei"+e.getMessage());
		}
		
		return obj;
	}

	public void cadastrarusuario(String nome, String email, String senha, int nivel) {
		
		try {
			
			String sql = "insert into usuarios(nomeUsuario, emailUsuario, senhaUsuario, nivelUsuario) values (?,?,?,?)";
					
			PreparedStatement pstmt = this.conectar.prepareStatement(sql);
			
			pstmt.setString(1, nome);
			pstmt.setString(2, email);
			pstmt.setString(3, senha);
			pstmt.setInt(4, nivel);
			
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao cadastrar");
		}
	}
	
	public String listarUsuario() {
		
		String estrutura = "<table class='tabelaListarUsuarios'>";
				estrutura+= "<tr>";
				estrutura+= "<td>Usuario</td>";
				estrutura+= "<td>Editar</td>";
				estrutura+= "<td>Excluir</td>";
				estrutura+= "</tr>";		
				
		try {
			
			String sql = "select * from usuarios";
			
			Statement stmt = this.conectar.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				estrutura+= "<tr>";
				estrutura+= "<td>"+rs.getString(2)+"</td>";
				estrutura+= "<td><a href='acoes/editarUsuario.jsp?idUsuario="+rs.getInt(1)+"'><span class='glyphicon glyphicon-pencil'></td>";
				estrutura+= "<td><a href='acoes/excluirUsuario.jsp?idUsuario="+rs.getInt(1)+"'><span class='glyphicon glyphicon-trash'></a></td>";
				estrutura+= "</tr>";
			}
		}catch(Exception e) {
			System.out.println("Falha no try do dao");
		}
		
		return estrutura;
	}
	
	public void excluirUsuario(int idUsuario) {
		
		try {
			
			String sql = "delete from usuarios where idUsuario = ?";
			
			PreparedStatement pstmt = this.conectar.prepareStatement(sql);
			
			pstmt.setInt(1,  idUsuario);
			
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao excluir o usuário");
		}
	}

	public void editarUsuario(int idUsuario) {
		
		try {
			
			String sql = "update usuarios set nomeUsuario = ? where idUsuario = ?";
			
			PreparedStatement pstmt = this.conectar.prepareStatement(sql);
			
			pstmt.setString(1 , idUsuario);
			pstmt.setInt(2, idUsuario);
			
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao editar usuário");
		}
	}
}
