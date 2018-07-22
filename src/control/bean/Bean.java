package control.bean;

import java.util.ArrayList;
import java.util.HashMap;

import control.info.Info;

public abstract class Bean<E extends Info> {

	protected HashMap<Enum<? extends Info>, Object> info = new HashMap<>();
	protected ArrayList<Enum<? extends Info>> infoIndex = new ArrayList<>();
	
	
	// Método para adicionar alguma informação no dicionário, embora não pareça pelo
	// nome xd
	@SuppressWarnings("unchecked")
	public Bean<E> setInfo(E key, Object value) {

		//Atribui o valor castado a uma variável pra não ficar castando o tempo todo
		Enum<? extends Info> k = (Enum<? extends Info>) key;
		
		if (!infoIndex.contains(k)) {

			infoIndex.add(k);
		}

		info.put(k, value);

		return this;
	}

	// Método para remover alguma informação do dicionário, esse parece
	@SuppressWarnings("unchecked")
	public Bean<E> removeInfo(E key) {

		//Atribui o valor castado a uma variável pra não ficar castando o tempo todo
		Enum<? extends Info> k = (Enum<? extends Info>) key;
		
		if (infoIndex.contains(k)) {

			infoIndex.remove(k);
			info.remove(k);
		}

		return this;
	}

	// Método para obter alguma informação do dicionário
	@SuppressWarnings("unchecked")
	public <O extends Object> O getInfo(E key) {

		return (O) info.get((Enum<? extends Info>) key);
	}

	// Método para receber a lista de enum das informações do dicionário
	public ArrayList<Enum<? extends Info>> getInfoIndex() {
		
		return this.infoIndex;
	}

	
	//Array que guarda as classes dos enums já que o java não deixa um enum extender outro lol
	/*@SuppressWarnings("unchecked")
	private Class<? extends Info>[] classesEnums = new Class[] {UserInfo.class, PacienteInfo.class, MedicoInfo.class};
	
	public <E extends Bean> void inserir(E bean) {
		
		String insert = "insert into insira_aqui_uma_tabela(";

		ArrayList<Enum<?>> infos = bean.getInfoIndex();

		for (Enum<?> info : infos) {
			
			for (Class<? extends Info> classe : classesEnums) {
				
				if (info.getClass().equals(classe))
					insert += classe.cast(info).getCampo();
			}
			
			insert += (infos.indexOf(info) < infos.size() - 1 ? ", " : "");
		}
		
		insert += ") values (?, ";
		
		for (int i = 0; i < infos.size(); i++) {
			
			insert += "?" + (i < infos.size() - 1 ? ", " : "");
		}
		
		try {
			
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(insert);
			
			for (int i = 1; i <= infos.size(); i++) {
				
				ps.setObject(i, infos.get(i - 1));
			}
			
			ps.execute();
			
		} catch (SQLException e) {
			
			System.out.println("N foi hoje");
		}
	}*/
}