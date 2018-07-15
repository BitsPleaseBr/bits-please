package control.bean;

import java.nio.charset.StandardCharsets;
import java.sql.Date;

public class MedicoBean {
	
	  private int  celular, telefoneResidencial, numeroResidencial, cepResidencial, telefoneComercial, numeroComercial, cepComercial;
	  private Date dataNasc;
	  private String nome, sobrenome, email, senha, cpf, crm, ruaResidencial, complementoResidencial, bairroResidencial, cidadeResidencial, ruaComercial, complementoComercial, bairroComercial, cidadeComercial, uf, pais, especialzacao;
	
	//Getters 
	public int getCelular() {
			return celular;
		}
	public int getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public int getNumeroResidencial() {
		return numeroResidencial;
	}
	public int getCepResidencial() {
		return cepResidencial;
	}
	public int getTelefoneComercial() {
		return telefoneComercial;
	}
	public int getNumeroComercial() {
		return numeroComercial;
	}
	public int getCepComercial() {
		return cepComercial;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getCpf() {
		return cpf;
	}
	public String getCrm() {
		return crm;
	}
	public String getRuaResidencial() {
		return ruaResidencial;
	}
	public String getComplementoResidencial() {
		return complementoResidencial;
	}
	public String getBairroResidencial() {
		return bairroResidencial;
	}
	public String getCidadeResidencial() {
		return cidadeResidencial;
	}
	public String getRuaComercial() {
		return ruaComercial;
	}
	public String getComplementoComercial() {
		return complementoComercial;
	}
	public String getBairroComercial() {
		return bairroComercial;
	}
	public String getCidadeComercial() {
		return cidadeComercial;
	}
	public String getUf() {
		return uf;
	}
	public String getPais() {
		return pais;
	}
	public String getEspecialzacao() {
		return especialzacao;
	}
}

