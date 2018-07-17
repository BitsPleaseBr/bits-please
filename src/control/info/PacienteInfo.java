package control.info;

public enum PacienteInfo implements Info {
	
	//Isso aqui é só pra nao ficar dando erro já que não ia ter nada
	A("A");
	
	
	//Campo que esse enum representa no banco
	private final String campo;

	//Construtor pra receber o campo que esse enum representa no banco
	PacienteInfo(String campo) {
		
		this.campo = campo;
	}

	public String getCampo() {

		return this.campo;
	}
}
