package control.bean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import control.info.MedicoInfo;
import control.info.PacienteInfo;
import control.info.UserInfo;
import control.info.Info;
import model.conexao.ConnectionFactory;

public abstract class Bean {

	private HashMap<Enum<?>, Object> info = new HashMap<>();
	private ArrayList<Enum<?>> infoIndex = new ArrayList<>();
	
	
	// Método para adicionar alguma informação no dicionário, embora não pareça pelo
	// nome xd
	public Bean setInfo(Enum<?> key, Object value) {

		if (!infoIndex.contains(key)) {

			infoIndex.add(key);
		}

		info.put(key, value);

		return this;
	}

	// Método para remover alguma informação do dicionário, esse parece
	public Bean removeInfo(Enum<?> key) {

		if (infoIndex.contains(key)) {

			infoIndex.remove(key);
			info.remove(key);
		}

		return this;
	}

	// Método para obter alguma informação do dicionário
	@SuppressWarnings("unchecked")
	public <T extends Object> T getInfo(Enum<?> key) {

		return (T) info.get(key);
	}

	// Método para receber a lista de enum das informações do dicionário
	public ArrayList<Enum<?>> getInfoIndex() {
		
		return this.infoIndex;
	}

	
	//Array que guarda as classes dos enums já que o java não deixa um enum extender outro lol
	/*@SuppressWarnings("unchecked")
	private Class<? extends Info>[] classesEnums = new Class[] {UserInfo.class, PacienteInfo.class, MedicoInfo.class};
	
	public <T extends Bean> void inserir(T bean) {
		
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