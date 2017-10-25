/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbercounter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author somak
 */
public class RandomNumberCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // get random numbers from 1 to 10
        Random rand = new Random();
        int count = 0;
        Logger logger = new Logger(20);
        while (true){ 
            int num = rand.nextInt(50) + 1;
            System.out.println("Adding number: " + Integer.toString(num));            
            // query for frequent numbers after adding 5 numbers
            if (count == 5){
                System.out.println("Most frequent numbers needed (Y/N)?");
                Scanner scanner = new Scanner(System.in);
                String ans = scanner.next();
                if (ans.charAt(0) == 'Y'){
                    ArrayList<Integer> list = logger.getFrequentNumbers(5); 
                    System.out.println("The 5 most frequent numbers");
                    System.out.println(getStringFormatFromList(list));    
                }
                count = 0;
            }
            logger.updateLogger(num);
            count++;
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
