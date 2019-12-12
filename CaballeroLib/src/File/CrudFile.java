/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author belciñaan_sd2081
 */
public class CrudFile {

    static List<String> allLines = null;
//    static String file = "Z:\\CrudFile\\src\\crudfile\\users.txt";
     static String file = ".\\src\\users.txt";
    File myFile = new File(file);

    public Boolean addUser(String firstname, String lastname, String email, String password, String passCon) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(myFile, true) //Set true for append mode
        );
        getLine();
        int id = allLines.size();
//        writer.newLine();	//Add new line
        writer.write(id + "," + firstname + "," + lastname + "," + email + "," + password + "," + passCon);
        writer.close();

        return false;
    }

    public static void getLine() {
        try {
//            allLines = Files.readAllLines(Paths.get("Z:\\CrudFile\\src\\crudfile\\users.txt"));
            allLines = Files.readAllLines(Paths.get(".\\src\\users.txt"));
        } catch (IOException ex) {
            Logger.getLogger(CrudFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean checkAccount(String inputusername, String inputpassword) {
        getLine();
        for (int i = 0; i < allLines.size(); i++) {
            if (inputusername.equals(allLines.get(i).split(",")[3]) && inputpassword.equals(allLines.get(i).split(",")[4])) {
                return true;
            }
        }
        return false;
    }

    public void showData() {
        getLine();
        List<String> line = null;
        for (int i = 1; i < allLines.size(); i++) {
            line.add(allLines.get(i).split(",")[1]);

        }

    }

    private Scanner x;

    public void removeRecord(String filePath, String removeTerm) {
        String tempFile = "user.txt";
        File oldFile = myFile;
        File newFile = new File(tempFile);
        String id = "";
        String First_Name = "";
        String Last_Name = "";
        String Email = "";
        String Password = "";
        String passCon = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                id = x.next();
                First_Name = x.next();
                Last_Name = x.next();
                Email = x.next();
                Password = x.next();
                passCon = x.next();
                if (!Email.equals(removeTerm)) {
                    pw.print(id + "," + First_Name + "," + Last_Name + "," + Email + "," + Password + "," + passCon);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
        } catch (IOException ex) {
            Logger.getLogger(CrudFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getEmail(String email) {

        List<String> lines = new ArrayList();
        try {

            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(CrudFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i < allLines.size(); i++) {
            if (email.equals(allLines.get(i).split(",")[4])) {
                return lines.get(i);
            }
        }
        return null;
    }

    public void update(String id, String first_name, String last_name, String mails, String pswrd) {
        getLine();
        List<String> temp = new ArrayList();
        for (int i = 0; i < allLines.size(); ++i) {
            if (id.equals(allLines.get(i).split(",")[0])) {
                String inp = String.format("%s,%s,%s,%s,%s", id, first_name, last_name, mails, pswrd);
                temp.add(inp);
            } else {
                temp.add(allLines.get(i));
            }
        }
        try {
            Files.write(Paths.get(file), "".getBytes());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < temp.size(); ++i) {
            String[] line = temp.get(i).split(",");
            String inp = String.format("%s,%s,%s,%s,%s\n", line[0], line[1], line[2], line[3], line[4]);
            try {
                Files.write(Paths.get(file), inp.getBytes(), StandardOpenOption.APPEND);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }
}