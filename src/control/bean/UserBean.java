package control.bean;

import java.nio.charset.StandardCharsets;

import control.info.UserInfo;

public class UserBean extends Bean {

	
	public byte[] getSenhaBytes() {
		return ((String) getInfo(UserInfo.Senha)).getBytes(StandardCharsets.UTF_8);
	}

	
	@Override
	public Bean setInfo(Enum<?> key, Object value) {
		
		super.setInfo(key, value);

		// Caso o cpf esteja sendo setado tira os caracteres não numéricos
		if (key.equals(UserInfo.CPF)) {

			setInfo(key, ((String) value).replaceAll("[^\\d]", ""));
		}

		return this;
	}
}