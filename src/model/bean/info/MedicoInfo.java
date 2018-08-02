package model.bean.info;

public enum MedicoInfo implements Info {

  /*
   * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos
   * campos da tabela no banco de dados
   */

  // Informações "gerais"
  CRM("crmPro"), Especializacao("Especializacao"), UF("ufPro"), Pais("paisPro"), IDUser("idUser");


  // Campo que esse enum representa no banco
  private final String campo;

  // Construtor pra receber o campo que esse enum representa no banco
  MedicoInfo(String campo) {

    this.campo = campo;
  }

  public String getCampo() {

    return campo;
  }
}
