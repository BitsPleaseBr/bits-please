package model.info;

public enum ProfissionalInfo implements Info {

	/*
	 * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos campos da tabela no banco de dados
	 */
	
	//Informações "gerais"
	CRM("CRM"), Especializacao("Especializacao"), UF("UF"), Pais("País"), IDUser("idUser"),
	
	//Informações residenciais
	TelefoneResidencial("TelefoneResidencial"), NumeroResidencial("NumeroResidencial"), RuaResidencial("RuaResidencial"), 
	ComplementoResidencial("ComplementoResidencial"), BairroResidencial("BairroResidencial"), CidadeResidencial("CidadeResidencial"), CepResidencial("CepResidencial"),

	//Informações Comerciais
	NumeroComercial("NumeroComercial"), RuaComercial("RuaComercial"), ComplementoComercial("ComplementoComercial"), 
	BairroComercial("BairroComercial"), CidadeComercial("CidadeComercial"), TelefoneComercial("TelefoneComercial"), CepComercial("CepComercial");
	
	
	//Campo que esse enum representa no banco
	private final String campo;

	//Construtor pra receber o campo que esse enum representa no banco
	ProfissionalInfo(String campo) {
		
		this.campo = campo;
	}

	public String getCampo() {
		
		return campo;
	}
}