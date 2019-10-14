/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

/**
 *
 * @author caballeroda_sd2081
 */
public class Average {
    
    public static double CalculateAvg(int  a[],int num)
       {
	   double sum=0;
 
	   for(int i=0;i<num;i++)
	       sum =sum+a[i];
 
	   return sum/num;
        }
   
    
    
}
