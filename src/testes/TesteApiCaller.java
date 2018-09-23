package testes;

import s3.api.access.MethodCallerFactory;

public class TesteApiCaller {

  public TesteApiCaller() {
    // TODO Auto-generated constructor stub
  }
  
  public static void main(String[] args) {
    
    MethodCallerFactory.verificarCpf("09792442936").call();
  }

}
