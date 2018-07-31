<<<<<<< HEAD
package control.extras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class Arquivo {
    
    public void Salvar(String local, String msg, boolean add) {
        try {
            File file = new File(local);
            FileWriter fw = new FileWriter(file, add);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(msg);
            pw.close();
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo");
        }
    }
    
    public String read(String local) {
        String text = "";
        try {
          
            File file = new File(getPath() + "/" + local);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                text += br.readLine();
            }
            br.close();
        } catch (IOError e) {
          
            System.out.println("Não foi possível ler o arquivo");
            e.printStackTrace();
        } catch (IOException e) {
          
          System.out.println("Não foi possível ler o arquivo");
          e.printStackTrace();
        }
        return text;
    }
    
    public String getPath() {
      
      String nomeClasse = "Arquivo.class";
      String path = getClass().getResource(nomeClasse).getPath();
      int pathLength = path.length();
      
      String classePath = "/control/extras/Arquivo.class";
      int classePathLength = classePath.length();
      
      return path.substring(0, pathLength - classePathLength);
    }
}
=======
package control.extras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class Arquivo {
    
    public void Salvar(String local, String msg, boolean add) {
        try {
            File file = new File(local);
            FileWriter fw = new FileWriter(file, add);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(msg);
            pw.close();
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo");
        }
    }
    
    public String read(String local) {
        String text = "";
        try {
          
            File file = new File(getPath() + "/" + local);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                text += br.readLine();
            }
            br.close();
        } catch (IOError e) {
          
            System.out.println("Não foi possível ler o arquivo");
            e.printStackTrace();
        } catch (IOException e) {
          
          System.out.println("Não foi possível ler o arquivo");
          e.printStackTrace();
        }
        return text;
    }
    
    public String getPath() {
      
      String nomeClasse = "Arquivo.class";
      String path = getClass().getResource(nomeClasse).getPath();
      int pathLength = path.length();
      
      String classePath = "/control/extras/Arquivo.class";
      int classePathLength = classePath.length();
      
      return path.substring(0, pathLength - classePathLength);
    }
}
>>>>>>> branch 'Gus' of https://github.com/BitsPleaseBr/bits-please
