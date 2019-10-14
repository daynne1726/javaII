/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity1;

import java.util.Scanner;

/**
 *
 * @author caballeroda_sd2081
 */
public class fiveMinute {

    public static void main(String arg[]) {
        long num;
        long reversenum;

        System.out.println("Input a number you want: ");
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        while (num != 0) {
            reversenum = num % 10;
            System.out.println(reversenum);
//            reversenum = reversenum * 10;
//            reversenum = reversenum + num % 10;
            num = num / 10;
        }
        
        
    }
}
