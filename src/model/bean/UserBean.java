package model.bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import model.info.Info;
import model.info.UserInfo;

public class UserBean implements Bean {


  private HashMap<UserInfo, Object> infosUser = new HashMap<>();

  
  public UserBean() {
    
    infosUser.put(UserInfo.Situacao, 1);
  }
  

  public UserBean setInfo(UserInfo key, Object value) {

    switch (key) {

      case Tipo: return this;
      
      case CPF:
        value = ((String) value).replaceAll("\\D", "");
        break;

      case DataNasc: {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {

          value = new Date(format.parse((String) value).getTime());
        } catch (ParseException e) {

          e.printStackTrace();
        }
        break;
      }

      default:
        break;
    }

    infosUser.put(key, value);

    return this;
  }

  public Object getInfo(UserInfo key) {

    return infosUser.get(key);
  }

  public HashMap<UserInfo, Object> getInfosUser() {

    return infosUser;
  }


  @Override
  public HashMap<Info, Object> getInfos() {

    HashMap<Info, Object> info = new HashMap<>();

    info.putAll(infosUser);

    return info;
  }
}