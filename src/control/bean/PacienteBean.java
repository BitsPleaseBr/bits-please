package control.bean;

import java.nio.charset.StandardCharsets;
import java.sql.Date;

public class PacienteBean {

  // variaveis
  private int telefone;
  private Date dataNasc;
  private String nome, sobrenome, email, senha, cpf;

  // getters
  public Date getDataNasc() {
    return dataNasc;
  }

  public int getTelefone() {
    return telefone;
  }

  public String getCpf() {
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
  
  public byte[] getSenhaBytes() {
    return senha.getBytes(StandardCharsets.UTF_8);
  }

  // setters
  public void setDataNasc(Date dataNasc) {
    this.dataNasc = dataNasc;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public void setCpf(String cpf) {
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

}
