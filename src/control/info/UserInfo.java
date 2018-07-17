package control.info;

public enum UserInfo implements Info {
	
	/*
	 * Os valores das Strings sao meramente ilustrativos, depois devem ser trocados para os nomes dos campos da tabela no banco de dados
	 */
	
	Nome("nome"), Sobrenome("sobrenome"), Email("email"), Senha("senha"), CPF("cpf"), DataNasc("dataNasc"), Telefone("telefone");


	//Campo que esse enum representa no banco
	private final String campo;

	//Construtor pra receber o campo que esse enum representa no banco
	UserInfo(String campo) {
		
		this.campo = campo;
	}
	
	
	public String getCampo() {
		
		return this.campo;
	}
}