package model.info;

public enum EnderecoInfo implements Info {

  
  Cep("cep"), Estado("estado"), Cidade("cidade"), Bairro("bairro"), Rua("rua"), 
  Numero("numero"), Complemento("complemento"), IdUser("user_id"), Tipo("tipo");
  

  // Campo que esse enum representa no banco
 private final String campo;

  // Construtor pra receber o campo que esse enum representa no banco
 EnderecoInfo(String campo) {
   
   this.campo = campo;
 }


  public String getCampo() {

    return this.campo;
  }
}
