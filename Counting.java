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
        Logger logger = new Logger();
        int count = 0;
        do{ 
            int num = rand.nextInt(10) + 1;
            count++;
            // convert the numbe  r to string
            String strNum = String.valueOf(num);
            
            
            // ask after adding 10 numbers
            if (count == 10){
                System.out.println("Most frequent numbers needed (Y/N)?");
                Scanner scanner = new Scanner(System.in);
                String ans = scanner.next();
                if (ans.charAt(0) == 'Y'){
                    String str = logger.getMostFrequentNumbers(5);
                    System.out.println("The 5 most frequent numbers");
                    System.out.println(str);
                }
                count = 0;
            }
            try {
                    
                InputStream stream = new ByteArrayInputStream(strNum.getBytes(StandardCharsets.UTF_8.name()));
                    
                //System.out.println("Number "+ strNum + " added in stream");
                logger.updateLogger(stream);
                            
                
            }catch (UnsupportedEncodingException ex) {
                    System.out.println("Encoding not supported");
            }catch (NullPointerException | IOException ex) {
                    System.out.println(ex);
            }
            
        }while(true);
        
    }

   
    
}
