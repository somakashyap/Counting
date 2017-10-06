/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author somak
 */
public class Logger {

    private int BUFFER_NUM;
    private ArrayList<LoggingItem> loggingItemList;
        
    Logger (int bufferSize){
        loggingItemList = new ArrayList<>();
        BUFFER_NUM = bufferSize;
        
    }
    
    public void updateLogger (int num){
        
        // if list is null
        if (loggingItemList == null){
            return;
        }
        // if list is empty
        if (loggingItemList.isEmpty()){
            LoggingItem item = new LoggingItem(num, 1);
            loggingItemList.add(item);
            return;
        }
        else if (loggingItemList.size() == BUFFER_NUM){
            // remove the  element with least count
            LoggingItem leastFrequentItem = getLeastCountItem();
            boolean remove = loggingItemList.remove(leastFrequentItem);
            if (remove == false){
                throw new UnsupportedOperationException("List is full not able to remove item");
            }
        }
        // find if this number already present
        boolean present = false;
        for (int i = 0; i < loggingItemList.size(); i++){
            LoggingItem item = loggingItemList.get(i);
            if (item.getNumber() == num){
                item.incrementCount(1);
                present = true;
            }
        }
        if (present == false){
            LoggingItem item = new LoggingItem(num, 1);
            loggingItemList.add(item);
        }
        
    }
    
    
    ArrayList<Integer> getFrequentNumbers(int count){
        
        ArrayList<Integer> retList = new ArrayList<>();
        if (loggingItemList == null || loggingItemList.isEmpty()){
            System.out.println("List is empty or not defined!");
            return (retList);
            
        }
        else if (count > loggingItemList.size()){
            System.out.println("Data is less than asked for! Returning the complete list.");
            count = loggingItemList.size();
        }
        
        // sort the list in descending order
        Collections.sort(loggingItemList, new LoggingItem());
        // print the list
        System.out.println ("The complete list is :");
        printLoggingList();
        
        // get the count number of elements from list 
        for (int i = 0; i < count; i++){
            LoggingItem item = loggingItemList.get(i);
            retList.add(item.getNumber());
        }
        return retList;
    }
    
    private LoggingItem getLeastCountItem(){
        LoggingItem leastFrequentItem = loggingItemList.get(0);
        int leastFrequency = leastFrequentItem.getCount();
        for (int i = 1; i < loggingItemList.size(); i++){
            LoggingItem item = loggingItemList.get(i);
            if (item.getCount() < leastFrequency){
                leastFrequency = item.getCount();
                leastFrequentItem = item;
            }
        }
        return leastFrequentItem;
    }
    
    
    private void printLoggingList(){
        String str = "";
        for (int i = 0; i < loggingItemList.size(); i++){
            LoggingItem item = (LoggingItem)loggingItemList.get(i);
            str = str + "(" + String.valueOf(item.getNumber()) + " , " + String.valueOf(item.getCount()) + ")";
            
        }
        System.out.println(str);
    }
}
