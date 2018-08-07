package model.bean;

import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.MedicoInfo;
import model.bean.info.UserInfo;

public class MedicoBean extends UserBean {


  private HashMap<MedicoInfo, Object> infosPro = new HashMap<>();


  public MedicoBean() {

    getInfosUser().put(UserInfo.Tipo, 2);
  }


  public MedicoBean setInfo(MedicoInfo key, Object value) {

    infosPro.put(key, value);

    return this;
  }

  public Object getInfo(MedicoInfo key) {

    return infosPro.get(key);
  }

  public HashMap<MedicoInfo, Object> getInfosPro() {

    return infosPro;
  }


  @Override
  public HashMap<Info, Object> getInfos() {

    HashMap<Info, Object> info = new HashMap<>();

    info.putAll(infosPro);
    info.putAll(getInfosUser());

    return info;
  }
}
