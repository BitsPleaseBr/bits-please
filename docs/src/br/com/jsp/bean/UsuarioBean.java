package br.com.jsp.bean;

public class UsuarioBean {

	private int idusuario, nivelUsuario;
	private String nomeUsuario, emailusuario, senhaUsuario;
	
	
	public int getIdUsuario() {
		return idusuario;
	}
	public void setIdUsuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getNivelUsuario() {
		return nivelUsuario;
	}
	public void setNivelUsuario(int nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmailUsuario() {
		return emailusuario;
	}
	public void setEmailUsuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	
}
