package control;

import control.crypto.BCrypt;
import control.crypto.PswdStorage;

public class CryptoTest {

  public static void main(String[] args) {
    String senha = "12345678";
    String email = "diogodklein@gmail.com";

    String hash = PswdStorage.clientPswdHash(senha, email);
    System.out.println(hash);
    byte[] hashByte = hash.getBytes();
    System.out.println(BCrypt.checkpw(senha, hash));
    System.out.println(PswdStorage.compararHashClient(senha, hashByte));
  }

}
