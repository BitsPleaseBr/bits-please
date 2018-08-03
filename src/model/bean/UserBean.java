package model.bean;

import java.util.ArrayList;
import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.UserInfo;

public class UserBean implements Bean {


  private HashMap<UserInfo, Object> infosUser = new HashMap<>();
  private ArrayList<EnderecoBean> enderecos = new ArrayList<>();
  private ArrayList<TelefoneBean> telefones = new ArrayList<>();
  
  
  public UserBean() {
    
    infosUser.put(UserInfo.Situacao, 1);
  }
  

  public UserBean setInfo(UserInfo key, Object value) {

    infosUser.put(key, key.parse(value));

    return this;
  }

  public Object getInfo(UserInfo key) {

    return infosUser.get(key);
  }

  public HashMap<UserInfo, Object> getInfosUser() {

    return infosUser;
  }


  public UserBean addTelefone(TelefoneBean bean) {
    
    telefones.add(bean);
    
    return this;
  }
  
  public UserBean addEndereco(EnderecoBean bean) {
    
    enderecos.add(bean);
    
    return this;
  }
  
  
  public ArrayList<EnderecoBean> getEnderecos() {
    
    return enderecos;
  }
  
  public ArrayList<TelefoneBean> getTelefones() {
    
    return telefones;
  }
  
  @Override
  public HashMap<Info, Object> getInfos() {

    HashMap<Info, Object> info = new HashMap<>();

    info.putAll(infosUser);

    return info;
  }
}