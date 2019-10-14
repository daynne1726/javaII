/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author caballeroda_sd2081
 */
public class Display {
    public boolean display(String value){
        try {
            System.out.println(value);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
