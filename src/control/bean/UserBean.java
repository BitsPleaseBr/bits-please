package control.bean;

import java.nio.charset.StandardCharsets;

import control.info.Info;
import control.info.UserInfo;

public abstract class UserBean<E extends Info> extends Bean<UserInfo> {
	
	
	public byte[] getSenhaBytes() {
		return ((String) getInfo(UserInfo.Senha)).getBytes(StandardCharsets.UTF_8);
	}

	
	@Override
	public Bean<UserInfo> setInfo(UserInfo key, Object value) {

		super.setInfo(key, value);

		// Caso o cpf esteja sendo setado tira os caracteres não numéricos
		if (key.equals(UserInfo.CPF)) {

			super.setInfo(key, ((String) value).replaceAll("[^\\d]", ""));
		}
		
		return this;
	}

	@SuppressWarnings("unchecked")
	public UserBean<E> setInfo(E key, Object value) {

		// Atribui o valor castado a uma variável pra não ficar castando o tempo todo
		Enum<? extends Info> k = (Enum<? extends Info>) key;
		
		if (!infoIndex.contains(k)) {

			infoIndex.add(k);
		}

		info.put(k, value);
		
		return this;
	}
}