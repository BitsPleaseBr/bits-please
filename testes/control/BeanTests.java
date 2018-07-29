package control;

import model.bean.PacienteBean;

public class BeanTests {

  public static void main(String[] args) {
    PacienteBean paciente = new PacienteBean();
    paciente.setCpf("057.575.29-40");
    System.out.println(paciente.getCpf());

  }

}
