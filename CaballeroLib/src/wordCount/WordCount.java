/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordCount;

/**
 *
 * @author caballeroda_sd2081
 */
public class WordCount {
   public static void main(String[] args)
	{
		String input=" <p><b>Welcome to Java Session Session Session. Gwapo kuno ko, Mas Gwapo <p><b>";
                System.out.println(input);
                input = input.replaceAll("\\<.*?\\>", "");//Input String
                System.out.println(input);
		String[] words=input.split(" ");	//Split the word from String
		int wrc=0;							//Variable for getting Repeated word count
		
		for(int i=0;i<words.length;i++)		//Outer loop for Comparison		
		{
			for(int j=i+1;j<words.length;j++)	//Inner loop for Comparison
			{
				
			if(words[i].equals(words[j]))	//Checking for both strings are equal
				{
					wrc=wrc+1;				//if equal increment the count
					words[j]="0";			//Replace repeated words by zero
				}
			}
			if(words[i]!="0")
			System.out.println(words[i]+"--"+wrc);	//Printing the word along with count
			wrc=1;
			
	     }  
			
	}
}
//String str = "<p><b>Welcome to Tutorials Point</b></p>";
//      System.out.println("Before removing HTML Tags: " + str);
//      str = str.replaceAll("\\<.*?\\>", "");
//      System.out.println("After removing HTML Tags: " + str);