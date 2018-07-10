package control.crypto;

/**
 * @author Diogo Classe para armazenamento de password
 */
public class PswdStorage {
  /**
   * Usado para fazer hash da senha do usuário no cliente de acesso ao sistema.
   * Utiliza o algoritmo BCrypt para fazer o hash da senha.
   * 
   * @param password
   *          senha do usuário
   * @param email
   *          e-mail do usuário, usado para fazer o salt.
   * @return Hash da senha com o parâmetro de encriptação e o hash prefixados
   */
  public static String clientPswdHash(String password, String email) {
    final String prefixo = "$2a$10$"; // String prefixado no salt com parâmetros
                                      // de hashing para o algoritmo
    String salt = email + "bitspleasebrsaltcombr"; // O salt recebe um sufixo
                                                   // para garantir que o salt
                                                   // tenha um tamanho mínimo
                                                   // necessário ]
    // É necessário remover qualquer caractere que não estejam em Base64.
    salt = removerCaracteresInvalidos(salt);
    salt = prefixo + salt;
    String hash = BCrypt.hashpw(password, salt);
    return hash;
  }

  private static String removerCaracteresInvalidos(String salt) {
    salt = salt.replaceAll("[^A-Za-z0-9/.]", "a");
    return salt;
  }

  // Construtor privado evita o instanciamento da classe
  private PswdStorage() {

  }
}
