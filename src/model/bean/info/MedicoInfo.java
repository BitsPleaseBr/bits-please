package model.bean.info;

import java.util.function.Function;

public enum MedicoInfo implements Info {

  /*
   * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos
   * campos da tabela no banco de dados
   */

  // Informações "gerais"
  CRM("crm"), Especializacao("especializacao"), UF("uf"), Pais("pais"), IDUser("user_id");


  // Campo que esse enum representa no banco
  private final String campo;
  // Função de parsing usada para validar o valor informado
  private Function<Object, Object> parser;

  // Construtor pra receber o campo que esse enum representa no banco
  // Caso não seja fornecido uma função de parsing, então a função padrão é usada
  MedicoInfo(String campo) {

    this(campo, valor -> valor);
  }

  MedicoInfo(String campo, Function<Object, Object> parser) {
    this.campo = campo;
    this.parser = parser;
  }

  public String getCampo() {

    return campo;
  }

  // Função usada para fazer o parsing correto do valor
  public Object parse(Object value) {
    return parser.apply(value);
  }
}
