package br.com.bitsplease.beans;

public class PacienteBean {
	
	//variaveis
	private int cpf;
	private String 	nome, 
					sobrenome, 
					email,
					senha;
	
	//getters
	public int getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}

	//setters
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	//retorna o comado de inserção no banco de dados
	public void pre_cadastrar() {
		System.out.println("INSERT INTO pre_cadastro VALUES("+this.getNome()+", "
							+this.getSobrenome()+", "
							+this.getCpf()+", "
							+this.getEmail()+")");
	}

}
