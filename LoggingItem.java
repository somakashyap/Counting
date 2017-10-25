/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbercounter;

import java.util.Comparator;

/**
 *
 * @author somak
 */
public class LoggingItem {
    
    private int number;
    private int count;
    private final int uniqueId;
    
    public static Comparator loggingItemComparator = (Comparator) (Object t, Object t1) -> {
        LoggingItem item1 = (LoggingItem)t;
        LoggingItem item2 = (LoggingItem)t1;
        int ret = -1;
        if (Integer.compare(item1.getCount(), item2.getCount()) == 0 && 
            Integer.compare(item1.getNumber(), item2.getNumber()) == 0){
            ret = 0;
        }
        return ret;

    };
    
        
    LoggingItem (int n, int f, int id){
        number = n;
        count = f;
        uniqueId = id;
        
    }
    public void setNumber(int n) { number = n; }
    public int getNumber() { return number; }
    public void setCount(int c) { count = c;}
    public int getCount() { return count; }
    public int getId() { return uniqueId; }
    public void incrementCount(int inc){
        
        count = count + inc;
    }

    
}
