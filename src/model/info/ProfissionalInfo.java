package model.info;

public enum ProfissionalInfo implements Info {

  /*
   * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos
   * campos da tabela no banco de dados
   */

  // Informações "gerais"
  CRM("crmPro"), Especializacao("Especializacao"), UF("ufPro"), Pais("paisPro"), IDUser("idUser"),

  // Informações residenciais
  TelefoneResidencial("TelefoneResPro"), NumeroResidencial("NumeroResPro"), RuaResidencial(
      "RuaResPro"), ComplementoResidencial("ComplementoResPro"), BairroResidencial(
          "BairroResPro"), CidadeResidencial("CidadeResPro"), CepResidencial("CepResPro"),

  // Informações Comerciais
  NumeroComercial("NumeroComPro"), RuaComercial("RuaComPro"), ComplementoComercial(
      "ComplementoComPro"), BairroComercial("BairroComPro"), CidadeComercial(
          "CidadeComPro"), TelefoneComercial("TelefoneComPro"), CepComercial("CepComPro");


  // Campo que esse enum representa no banco
  private final String campo;

  // Construtor pra receber o campo que esse enum representa no banco
  ProfissionalInfo(String campo) {

    this.campo = campo;
  }

  public String getCampo() {

    return campo;
  }
}
