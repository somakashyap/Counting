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
    private int frequency;

    LoggingItem(){
        number = 0;
        frequency = 0;
    }
        
    LoggingItem (int n, int f){
        number = n;
        frequency = f;
    }
    public void setNumber(int n) { number = n; }
    public int getNumber() { return number; }
    public void setFrequency(int f) { frequency = f;}
    public int getFrequency() { return frequency; }

    @Override
    public int compare(Object t, Object t1) {
        LoggingItem item1 = (LoggingItem)t;
        LoggingItem item2 = (LoggingItem)t1;
        
        // do we need to check obejct conversion here ?
        return (item2.getFrequency() - item1.getFrequency());
       
    }
}
