/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting;




import java.io.ByteArrayInputStream;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author somak
 */


public class Counting {

    /**
    * Given a stream of unicode characters, count the frequency of seen characters
    * and maintain a up-to-date collection of most frequent characters.
    * 
    */
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // get random numbers from 1 to 1000
        Random rand = new Random();
        Logger logger = new Logger(1000);
        int count = 0;
        while (true){ 
            int num = rand.nextInt(10) + 1;
            count++;
                        
            // ask after adding 10 numbers
            if (count == 10){
                System.out.println("Most frequent numbers needed (Y/N)?");
                Scanner scanner = new Scanner(System.in);
                String ans = scanner.next();
                if (ans.charAt(0) == 'Y'){
                    ArrayList<Integer> list = new ArrayList<>();
                    list = logger.getFrequentNumbers(5);
                    System.out.println("The 5 most frequent numbers");
                    System.out.println(getStringFormatFromList(list));
                }
                count = 0;
            }
            logger.updateLogger(num);
        }
        
    }

   private static String getStringFormatFromList(ArrayList<Integer> list){
        String ret = "";
        if (list == null) { return ret; }
        for (int i = 0; i < list.size(); i++){
            Integer number = list.get(i);
            ret = ret + String.valueOf(number) + " ";
        
        }
        return ret;
    }
    
}
