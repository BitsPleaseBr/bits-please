package model.info;

public enum TelefoneInfo implements Info {

  Numero("numero"), IdUser("user_id"), Tipo("tipo");
  
//Campo que esse enum representa no banco
 private final String campo;

 // Construtor pra receber o campo que esse enum representa no banco
 TelefoneInfo(String campo) {
   
   this.campo = campo;
 }


 public String getCampo() {

   return this.campo;
 }
}
