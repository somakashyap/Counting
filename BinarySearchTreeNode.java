/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbercounter;

/**
 *
 * @author somak
 */
public class BinarySearchTreeNode {
    private int key;
    private Object value;
    private BinarySearchTreeNode leftTree;
    private BinarySearchTreeNode rightTree;

    
    BinarySearchTreeNode(int k, Object o){
        key = k;
        value = o;
        leftTree = null;
        rightTree = null;
    }
    public void setKey(int k){
        key = k;
    }
    
    public int getKey(){
        return key;
    }
    
    public Object getValue(){
        return value;
    }
    
    public void setValue(Object o){
        value = o;
    }
    
    public BinarySearchTreeNode getLeft(){
        return leftTree;
    }
    
    public BinarySearchTreeNode getRight(){
        return rightTree;
    }
    
    public void setLeft(BinarySearchTreeNode t){
        leftTree = t;
    }
    
    public void setRight(BinarySearchTreeNode t){
        rightTree = t;
    }
}
