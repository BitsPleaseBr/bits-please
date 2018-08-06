package control;


import java.net.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import control.email.EmailWrapper;
import control.extras.PropertiesManager;
import model.bean.PacienteBean;
import model.bean.info.PacienteInfo;
import model.bean.info.UserInfo;

public class EmailTests {
  public static void main(String[] args) {
    testHtmlEmail();
  }

  public static void sendHTMLEmail() {
    // Create the email message
    HtmlEmail email = new HtmlEmail();
    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setSSLOnConnect(true);
    email.setAuthenticator(new DefaultAuthenticator("bitspleasebr", "b1tspl34s3"));
    try {
      email.addTo("nathangabriel97@gmail.com");
      email.setFrom("bitspleasebr@gmail.com");
    } catch (EmailException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    email.setSubject("HTML TestMail");

    // embed the image and get the content id
    URL url;
    try {
      url = new URL("http://teste.mk4avhzpsj.sa-east-1.elasticbeanstalk.com/_img/icon.png");
      String cid = email.embed(url, "Nossa Logo");
      // set the html message
      email.setHtmlMsg("<html>Nossa logo - <img src=\"cid:" + cid + "\"></html>");

      // set the alternative message
      email.setTextMsg("Your email client does not support HTML messages");

      // send the email
      email.send();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void sendEmail() {
    Email email = new SimpleEmail();

    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator("bitspleasebr", "b1tspl34s3"));
    email.setSSLOnConnect(true);
    try {
      email.setFrom("bitspleasebr@gmail.com");
      email.setSubject("TestMail");
      email.setMsg("This is a test mail ... :-)");
      email.addTo("diogodklein@gmail.com");
      email.send();
    } catch (Exception e) {

    }
  }
  
  public static void testHtmlEmail() {
    PacienteBean paciente = new PacienteBean();
    paciente.setInfo(PacienteInfo.IDUser, 11);
    paciente.setInfo(UserInfo.CPF, "057-575-029-50");
    paciente.setInfo(UserInfo.DataNasc, "27/01/1991");
    paciente.setInfo(UserInfo.Nome, "Diogo");
    paciente.setInfo(UserInfo.Email, "diogodklein@gmail.com");
    EmailWrapper.enviarEmailConfirmacao(paciente);
  }
}
