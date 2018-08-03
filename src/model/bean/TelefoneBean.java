package model.bean;

import java.util.HashMap;
import model.bean.info.Info;
import model.bean.info.TelefoneInfo;

public class TelefoneBean implements Bean {

  
  public final int TELEFONE = 1, CELULAR = 2;
  
  private HashMap<TelefoneInfo, Object> infosTel = new HashMap<>();
  
  
  public TelefoneBean setInfo(TelefoneInfo key, Object value) {
    
    infosTel.put(key, key.parse(value));
    
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
