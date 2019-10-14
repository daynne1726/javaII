/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadraticFormula;

/**
 *
 * @author caballeroda_sd2081
 */
public class Formula {
    public double quadratic(double a, double b, double c){
        double x = (-b - (Math.sqrt((b * b) - (4 * (a * c))))) / 2 * a;
        return x;

          
    }
}
