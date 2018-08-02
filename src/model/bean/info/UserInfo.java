package model.bean.info;

public enum UserInfo implements Info {

  /*
   * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos
   * campos da tabela no banco de dados
   */

  ID("idUser"), Nome("nomeUser"), Sobrenome("sobrenomeUser"), Email("emailUser"), Senha("senhaUser"), CPF(
      "cpfUser"), DataNasc("nascimentoUser"), Telefone("telefoneUser"), Tipo("tipoUser"), Situacao("situacaoUser");


  // Campo que esse enum representa no banco
  private final String campo;

  // Construtor pra receber o campo que esse enum representa no banco
  UserInfo(String campo) {
    
    this.campo = campo;
  }


  public String getCampo() {

    return this.campo;
  }
}
