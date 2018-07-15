package control;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;

import control.bean.PacienteBean;
import control.crypto.PswdStorage;
import control.dao.PacienteDao;
import interfaces.componentes.MainPanel;

public class DaoTests {

  public static void main(String[] args) {
   /* try {
      PacienteBean paciente = new PacienteBean();
      paciente.setCpf("05757502940");
      LocalDate data = LocalDate.parse("23/01/1991",
              new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter());
      paciente.setDataNasc(Date.valueOf(data));
      paciente.setEmail("diogodklein2@gmail.com");
      paciente.setNome("Diogo");
      paciente.setSenha(PswdStorage.clientPswdHash("111111", "diogodklein@gmail.com"));
      paciente.setSobrenome("Derossi");
      paciente.setTelefone(999568999);
      System.out.println("Criação de bean concluída");
      PacienteDao.pre_cadastrar(paciente);
      System.out.println("Cadastro realizado");
    } catch (Exception e) {
      System.out.println("Erro no teste");
      e.printStackTrace();
    }
    System.out.println("Sucesso");*/
	  
  }

}
