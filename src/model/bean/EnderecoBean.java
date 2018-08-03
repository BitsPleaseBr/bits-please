package model.bean;

import java.util.HashMap;
import model.bean.info.EnderecoInfo;
import model.bean.info.Info;

public class EnderecoBean implements Bean {

  private HashMap<EnderecoInfo, Object> infosEnd = new HashMap<>();
  
  
  public EnderecoBean setInfo(EnderecoInfo key, Object value) {
    
    infosEnd.put(key, value);
    
    return this;
  }
  
  public Object getInfo(EnderecoInfo key) {
    
    return infosEnd.get(key);
  }
  
  
  @Override
  public HashMap<Info, Object> getInfos() {
   
    HashMap<Info, Object> info = new HashMap<>();
    info.putAll(infosEnd);
    
    return info;
  }

}