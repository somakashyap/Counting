/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbercounter;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author somak
 */
public class BinarySearchTree {
    
    private BinarySearchTreeNode minNode;
    private BinarySearchTreeNode maxNode;
    private int numNodes;
    BinarySearchTreeNode root;
    private Comparator valueComparator;
    
    BinarySearchTree(Comparator vcomp){
        minNode = null;
        maxNode = null;
        root = null;
        valueComparator = vcomp;
        numNodes = 0;
    }
    
    public int getNumberOfNodes(){
        return numNodes;
    }
    
    void insertObject(int key, Object o){
        BinarySearchTreeNode node = new BinarySearchTreeNode(key, o);
        numNodes++;
        if (minNode == null && maxNode == null){
            minNode = node;
            maxNode = node;
        }
        else{
            if (minNode.getKey() > node.getKey()){
                minNode = node;
            }
            if (maxNode.getKey() < node.getKey()){
                maxNode = node;
            }
        }
        root = insert(root, node);
        
    }
    
    public void deleteObject(int key, Object o){
        if (root == null){
            throw new IllegalStateException(" No node to delete!");
        }
        root = delete(root, key, o);
        if (root != null){
            if (minNode.getKey() == key && 
                    valueComparator.compare(minNode.getValue(), o) == 0){
                minNode = getMinNode(root);
            }
            if (maxNode.getKey() == key &&
                    valueComparator.compare(maxNode.getValue(), o) == 0){
                maxNode = getMaxNode(root);
            }
        }
        numNodes = numNodes - 1;
        if (root == null){
            minNode = null;
            maxNode = null;
            numNodes = 0;
        }
    }
    
    public ArrayList<Object> getCountMaxNodes(int count){
        ArrayList<Object> retList = new ArrayList<>();
        int counter = 0;
        getCountMaxNodeUtil(root, count, counter, retList);
        return retList;
        
    }
    
    public Object getMinNodeValue(){
        return minNode.getValue();
    }
    
    public void printTree(){
        System.out.println();
        printInorder(root);
        
    }
    
    private BinarySearchTreeNode insert(BinarySearchTreeNode root, 
                                        BinarySearchTreeNode newNode){
        if (root == null){
            root = newNode;
        }
        else if (root.getKey() > newNode.getKey()){
            root.setLeft(insert(root.getLeft(), newNode));
        }
        else if (root.getKey() <= newNode.getKey()){
            root.setRight(insert(root.getRight(), newNode));
        }
        return root;
    }
    
    
    
    private BinarySearchTreeNode delete(BinarySearchTreeNode root, int key, Object o){
        if (root == null){
            return null;
        }
        if (root.getKey() < key){
            root.setRight(delete(root.getRight(), key, o));
        }
        else if (root.getKey() > key){
            root.setLeft(delete(root.getLeft(), key, o));
        }
        else if (root.getKey() == key){
            if (valueComparator.compare(root.getValue(), o) == 0){
                // leaf node
                if (root.getLeft() == null && root.getRight() == null){
                    return null;
                }
                // one child
                else if (root.getLeft() == null){
                    return root.getRight();
                }
                else if (root.getRight() == null){
                    return root.getLeft();
                }
                
                // node with two children
                // need to get smallest in right tree to replace root
                BinarySearchTreeNode minNode = getMinNode(root.getRight());
                // copy minNode to cuurent root
                root.setKey(minNode.getKey());
                root.setValue(minNode.getValue());
                
                // delete minNode from right tree
                root.setRight(delete(root.getRight(), minNode.getKey(), minNode.getValue()));
            }
            else {
                // check in right subtree for same key
                root.setRight(delete(root.getRight(), key, o));
            }
            
        }
        return root;
    }
    
    private BinarySearchTreeNode getMinNode(BinarySearchTreeNode root){
        BinarySearchTreeNode min = null;
        if(root != null){
            min = root;
            while (root.getLeft() != null){
                min = root.getLeft();
                root = root.getLeft();
            }
        }
        return min;
    }
    
    private BinarySearchTreeNode getMaxNode(BinarySearchTreeNode root){
        BinarySearchTreeNode max = null;
        if(root != null){
            max = root;
            while (root.getRight() != null){
                max = root.getRight();
                root = root.getRight();
            }
        }
        return max;
    }
    
    
    
    private void printInorder(BinarySearchTreeNode root){
        if (root != null){
            printInorder(root.getLeft());
            LoggingItem item = (LoggingItem)root.getValue();
            System.out.print("(" + root.getKey() + "," + item.getNumber() + ")");
            printInorder(root.getRight());
        }
    }
    
    
    
    private int getCountMaxNodeUtil(BinarySearchTreeNode root,
                                int count,
                                int currentCount,
                                ArrayList<Object> list){
        if (root == null || currentCount >= count){
            return currentCount;
        }
        if (root.getRight() != null){
            currentCount = getCountMaxNodeUtil(root.getRight(), count, currentCount, list);
            if (currentCount >= count){
                return currentCount;
            }
        }
        list.add(root.getValue());
        currentCount++;
        if (root.getLeft() != null){
            currentCount = getCountMaxNodeUtil(root.getLeft(), count, currentCount, list);
            if (currentCount >= count){
                return currentCount;
            }
        }
        return currentCount;
    }
    
}
