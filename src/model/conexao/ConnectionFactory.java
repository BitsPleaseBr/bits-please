package model.conexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import control.adicionais.Arquivo;

/**
 * @author Diogo Classe para criar uma conexão com o banco de dados. Não pode
 *         ser instanciada.
 */
public class ConnectionFactory {
	// Constantes para acessar o banco de dados
	private static String prefixoConnection = "";
	private static String urlBD = "";
	private static String porta = "";
	private static String nomeBD = "";
	private static String connectionURL = "";
	private static String user = "";
	private static String password = "";

	/**
	 * Método para retornar a conexão com o banco de dados
	 * 
	 * @return Uma instância da conexão com o banco de dados se ela foi bem
	 *         sucedida, caso contrário retorna null.
	 */
	public static Connection getConnection() {

		// Variável para retornar a conexão
		Connection conexao = null;

		// Realizar a conexão
		try {
			conexao = DriverManager.getConnection(connectionURL, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conexao;
	}

	private ConnectionFactory() {

		String[] dados = new String[6];
		
		try {
			dados = new Arquivo().read("conexoes.txt").split("##");
		} catch (IOException e) {

			e.printStackTrace();
		}

		prefixoConnection = dados[0];
		urlBD = dados[1];
		porta = dados[2];
		nomeBD = dados[3];
		connectionURL = prefixoConnection + urlBD + porta + nomeBD;
		user = dados[4];
		password = dados[5];
	}
}
