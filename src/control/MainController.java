package control;

import model.dao.UserDao;

public class MainController {


  public int login(String email, String senha) {

    return new UserDao() {}.login(email, senha);
  }
}
