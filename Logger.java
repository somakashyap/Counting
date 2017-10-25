/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbercounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author somak
 */
public class Logger {
    
    private int BUFFER_NUM;
    private BinarySearchTree numbersTree;
    private HashMap<Integer, Object> numbersMap;
    private static int counter = 0;
    Logger (int bufferSize){
        numbersTree = new BinarySearchTree(LoggingItem.loggingItemComparator);
        BUFFER_NUM = bufferSize;
        numbersMap = new HashMap<>();
             
    }
    
    public void updateLogger(int num){
        if (numbersTree == null || numbersMap == null){
            throw new IllegalStateException("Logger updation called without instantiation!");
        }
        
        if (numbersTree.getNumberOfNodes() == BUFFER_NUM){
            // get the min node and delete it
            LoggingItem minNode = (LoggingItem) numbersTree.getMinNodeValue();
            numbersTree.deleteObject(minNode.getCount(), minNode);
            numbersMap.remove(minNode.getNumber());
        }
        
        // find if this number already present
        LoggingItem searchItem = (LoggingItem) numbersMap.get(num);
        
        if (searchItem == null){
            // number not present
            // add the number in tree and map
            LoggingItem newItem = new LoggingItem(num, 1, ++counter);
            numbersTree.insertObject(1, newItem);
            numbersMap.put(num, newItem);
        }
        else{
            
            // delete the node from tree
            numbersTree.deleteObject(searchItem.getCount(), searchItem);
            // increment the count of item
            searchItem.incrementCount(1);
            // add to tree
            numbersTree.insertObject(searchItem.getCount(), searchItem);
        }
        numbersTree.printTree();

    }
    
     ArrayList<Integer> getFrequentNumbers(int count){
        ArrayList<Integer> retList = new ArrayList<>();
        if (numbersTree.getNumberOfNodes() == 0){
            System.out.println("List is empty or not defined!");
            return (retList);    
        }
        else if (count > numbersTree.getNumberOfNodes()){
            System.out.println("Data is less than asked for! Returning the complete list.");
            count = numbersTree.getNumberOfNodes();
        }
        ArrayList<Object> list = numbersTree.getCountMaxNodes(count);
        
        for (int i = 0; i < list.size(); i++){
            LoggingItem item = (LoggingItem)list.get(i);
            retList.add(item.getNumber());
        }
        return retList;
     }
    
}
