package control.validators;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Parsers {
  public static Integer cpfParse(Object CPF) {
    return Integer.parseInt(((String)CPF).replaceAll("\\D", ""));
  }
  
  public static DateFormat dateParse(Object data) {
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    try {

      data = new Date(format.parse((String) data).getTime());
    } catch (ParseException e) {

      e.printStackTrace();
    }
    
    return format;
  }
}
