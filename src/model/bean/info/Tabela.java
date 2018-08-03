package model.bean.info;

public enum Tabela {

  
  User("user"), Medico("medico"), Paciente("paciente"), Endereco("endereco"), Telefone("telefone"), Especialidade("especialidade");
  
  
  private String nome;
  
  Tabela(String nome) {
    
    this.nome = nome;
  }
  
  public String getNome() {
    
    return this.nome;
  }
}