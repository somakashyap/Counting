/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting;

import java.util.Comparator;

/**
 *
 * @author somak
 */
public class LoggingItem implements Comparator{

    private int number;
    private int count;

    LoggingItem(){
        number = 0;
        count = 0;
    }
        
    LoggingItem (int n, int f){
        number = n;
        count = f;
    }
    public void setNumber(int n) { number = n; }
    public int getNumber() { return number; }
    public void setCount(int c) { count = c;}
    public int getCount() { return count; }
    
    public void incrementCount(int inc){
        
        count = count + inc;
    }

    @Override
    public int compare(Object t, Object t1) {
        LoggingItem item1 = (LoggingItem)t;
        LoggingItem item2 = (LoggingItem)t1;
        
        return(Integer.compare(item2.getCount(), item1.getCount()));
       
    }
}
