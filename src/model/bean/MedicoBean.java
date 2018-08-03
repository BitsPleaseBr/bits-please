package model.bean;

import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.MedicoInfo;
import model.bean.info.UserInfo;

public class MedicoBean extends UserBean {


  private HashMap<MedicoInfo, Object> infosMed = new HashMap<>();

  
  public MedicoBean() {
    
    getInfosUser().put(UserInfo.Tipo, 2);
  }
  

  public MedicoBean setInfo(MedicoInfo key, Object value) {
	  
    if (key.equals(MedicoInfo.IDUser))
      getInfosUser().put(UserInfo.ID, key.parse(value));
    
    infosMed.put(key, key.parse(value));

    return this;
  }

  public Object getInfo(MedicoInfo key) {

    return infosMed.get(key);
  }

  public HashMap<MedicoInfo, Object> getInfosMed() {

    return infosMed;
  }


  @Override
  public HashMap<Info, Object> getInfos() {

    HashMap<Info, Object> info = new HashMap<>();

    info.putAll(infosMed);
    info.putAll(getInfosUser());

    return info;
  }
}
