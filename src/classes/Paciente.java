package classes;

public class Paciente {
	
	private int pacienteCpf;
	private String 	pacienteNome, 
					pacienteSobrenome, 
					email,
					senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPacienteCpf() {
		return pacienteCpf;
	}

	public void setPacienteCpf(int pacienteCpf) {
		this.pacienteCpf = pacienteCpf;
	}

	public String getPacienteNome() {
		return pacienteNome;
	}

	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}

	public String getPacienteSobrenome() {
		return pacienteSobrenome;
	}

	public void setPacienteSobrenome(String pacienteSobrenome) {
		this.pacienteSobrenome = pacienteSobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public void pre_cadastrar() {
		System.out.println("INSERT INTO pre_cadastro VALUES("+this.getPacienteNome()+" VARCHAR(50), "
							+this.getPacienteSobrenome()+" VARCHAR(100), "
							+this.getPacienteCpf()+" INT, "
							+this.getEmail()+" VARCHAR(50),"
							+"PRIMARY KEY(pacienteCpf))");
	}


	
}
