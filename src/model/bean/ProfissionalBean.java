package model.bean;

import java.util.HashMap;
import model.info.Info;
import model.info.ProfissionalInfo;

public class ProfissionalBean extends UserBean {


  private HashMap<ProfissionalInfo, Object> infosPro = new HashMap<>();


  public ProfissionalBean setInfo(ProfissionalInfo key, Object value) {
	  
	switch (key) {
	
	  case Celular: value = ((String) value).replaceAll("\\D", ""); break;
	  case TelefoneComercial: value = ((String) value).replaceAll("\\D", ""); break;
	  
	  default: break;
	}
	  
    infosPro.put(key, value);

    return this;
  }

  public Object getInfo(ProfissionalInfo key) {

    return infosPro.get(key);
  }

  public HashMap<ProfissionalInfo, Object> getInfosPro() {

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
