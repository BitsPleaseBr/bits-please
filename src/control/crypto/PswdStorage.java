package control.crypto;

public class PswdStorage {
  public static String clientPswdHash(String password, String email) {
    final String prefixo = "$2a$10$";
    String salt = email + "bitsplease";
    salt = salt.replaceAll("[^A-Za-z0-9/.]", "a");
    salt = prefixo + salt;
    String hash = BCrypt.hashpw(password, salt);
    return hash;
  }
}
