/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Math.Average;
import java.util.Scanner;


/**
 *
 * @author caballeroda_sd2081
 */
public class Input extends Average {

 

    public double getInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");
        return s.nextInt();
//        int num;
//        double sum = 0;
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter how many numbers to calulate avg: ");
//        num = sc.nextInt();
//
//        int a[] = new int[num];
//
//        System.out.println("Enter " +num+ " numbers: ");
//
//        for (int i = 0; i < num; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        sum = Input.CalculateAvg(a,num);
//
//        System.out.println("Average: " + sum);
//
//        return sum;
    }
}

//    
//    }
