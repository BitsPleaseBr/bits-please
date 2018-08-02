package model.bean;

import java.util.HashMap;
import model.info.Info;
import model.info.TelefoneInfo;

public class TelefoneBean implements Bean {

  private HashMap<TelefoneInfo, Object> infosTel = new HashMap<>();
  
  
  public TelefoneBean setInfo(TelefoneInfo key, Object value) {
    
    infosTel.put(key, value);
    
    return this;
  }
  
  public Object getInfo(TelefoneInfo key) {
    
    return infosTel.get(key);
  }
  
  
  @Override
  public HashMap<Info, Object> getInfos() {
   
    HashMap<Info, Object> info = new HashMap<>();
    info.putAll(infosTel);
    
    return info;
  }

}
