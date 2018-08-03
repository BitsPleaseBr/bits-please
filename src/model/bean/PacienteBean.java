package model.bean;

import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.PacienteInfo;
import model.bean.info.UserInfo;

public class PacienteBean extends UserBean {


  private HashMap<PacienteInfo, Object> infosPac = new HashMap<>();


  public PacienteBean() {
    
    getInfosUser().put(UserInfo.Tipo, 1);
  }
  
  
  public PacienteBean setInfo(PacienteInfo key, Object value) {

    infosPac.put(key, key.parse(value));

    return this;
  }

  public Object getInfo(PacienteInfo key) {

    return infosPac.get(key);
  }

  public HashMap<PacienteInfo, Object> getInfosPac() {

    return infosPac;
  }


  @Override
  public HashMap<Info, Object> getInfos() {

    HashMap<Info, Object> info = new HashMap<>();

    info.putAll(infosPac);
    info.putAll(getInfosUser());

    return info;
  }
}
