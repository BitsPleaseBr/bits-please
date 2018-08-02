package model.bean.info;

import java.util.function.Function;
import control.validators.Parsers;

public enum UserInfo implements Info {

  Nome("nomeUser"), Sobrenome("sobrenomeUser"), Email("emailUser"), Senha("senhaUser"), CPF(
      "cpfUser", a -> Parsers.cpfParse(a)), DataNasc("nascimentoUser",
          a -> Parsers.dateParse(a)), Telefone("telefoneUser");


  // Campo que esse enum representa no banco
  private final String campo;
  // Função de parsing usada para validar o valor informado
  private Function<Object, Object> parser;

  // Construtor pra receber o campo que esse enum representa no banco
  // Caso não seja fornecido uma função de parsing, então a função padrão é usada
  UserInfo(String campo) {

    this.campo = campo;
    this.parser = valor -> valor;
  }

  UserInfo(String campo, Function<Object, Object> parser) {
    this.campo = campo;
    this.parser = parser;
  }

  public String getCampo() {

    return this.campo;
  }

  // Função usada para fazer o parsing correto do valor
  public Object parse(Object value) {
    return parser.apply(value);
  }
}
