/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;

/**
 *
 * @author somak
 */
public class Logger {

    private static final int BUFFER_NUM = 1000;
    private ArrayList loggingItemList;
        
    Logger (){
        loggingItemList = new ArrayList();
        
    }
    
    private LoggingItem getLeaseFrequentItem(){
        LoggingItem leaseFrequentItem = (LoggingItem)loggingItemList.get(0);
        int leastFrequency = leaseFrequentItem.getFrequency();
        for (int i = 1; i < loggingItemList.size(); i++){
            LoggingItem item = (LoggingItem)loggingItemList.get(i);
            if (item.getFrequency() < leastFrequency){
                leastFrequency = item.getFrequency();
                leaseFrequentItem = item;
            }
        }
        return (leaseFrequentItem);
    }
    private String getStringFormatFromList(ArrayList list){
        String ret = "";
        for (int i = 0; i < list.size(); i++){
            LoggingItem item = (LoggingItem)list.get(i);
            int number = item.getNumber();
            ret = ret + String.valueOf(number) + " ";
        
        }
        return (ret);
    }
    
    private void printLoggingList(){
        String str = "";
        for (int i = 0; i < loggingItemList.size(); i++){
            LoggingItem item = (LoggingItem)loggingItemList.get(i);
            str = str + "(" + String.valueOf(item.getNumber()) + " , " + String.valueOf(item.getFrequency()) + ")";
            
        }
        System.out.println(str);
    }
    
    private void updateList(int number){
        // if list is empty
        if (loggingItemList == null || loggingItemList.isEmpty()){
            LoggingItem item = new LoggingItem(number, 1);
            loggingItemList.add(item);
            return;
        }
        else if (loggingItemList.size() == 1000){
            // remove the  element with least frequency
            LoggingItem leaseFrequentItem = getLeaseFrequentItem();
            boolean remove = loggingItemList.remove(leaseFrequentItem);
            if (remove == false){
                throw new UnsupportedOperationException("List is full not able to remove item");
            }
        }
        // find if this number already present
        boolean present = false;
        for (int i = 0; i < loggingItemList.size(); i++){
            LoggingItem item = (LoggingItem)loggingItemList.get(i);
            if (item.getNumber() == number){
                item.setFrequency(item.getFrequency() + 1);
                present = true;
            }
        }
        if (present == false){
            LoggingItem item = new LoggingItem(number, 1);
            loggingItemList.add(item);
        }
        
        
    }
    void updateLogger (InputStream stream) throws NullPointerException, IOException{
        if (stream == null){
            throw new NullPointerException("Stream is null");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(inputStreamReader);
        
        try {
            String num = in.readLine();
            //System.out.println(" The number read is : " + num);
            // update the list
            updateList (Integer.parseInt(num));
        } catch (IOException ex) {
            throw new IOException("I/O exception");
        }
    }
    
    
    String getMostFrequentNumbers(int count){
        
        String ret = null;
        if (loggingItemList == null || loggingItemList.isEmpty()){
            System.out.println("List is empty or not defined!");
            return (ret);
            
        }
        
        else if (count > loggingItemList.size()){
            System.out.println("Data is less than asked for! Returning the complete list.");
            ret = getStringFormatFromList(loggingItemList);
            return (ret);
        }
        
        // sort the list in descending order
        Collections.sort(loggingItemList, new LoggingItem());
        // print the list
        System.out.println ("The complete list is :");
        printLoggingList();
        
        // get the count number of elements from list and return in string
        ArrayList list = new ArrayList();
        for (int i = 0; i < count; i++){
            LoggingItem item = (LoggingItem)loggingItemList.get(i);
            list.add(item);
        }
        
        ret = getStringFormatFromList(list);
        return (ret);
    }
}
