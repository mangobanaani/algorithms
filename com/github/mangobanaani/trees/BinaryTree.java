package com.github.mangobanaani.trees;

import java.util.Iterator;

/**
 * simple Binary search tree (BST), no height limited
 *
 * Created by mangobanaani on 14/07/2017.
 */

public class BinaryTree {

    protected static class Node{
        private String key;
        private int value;
        private Node left;
        private Node right;

        public Node(String key, int value, Node above, Node leftChild, Node rightChild){
            this.key=key;
            this.value=value;
            this.left=leftChild;
            this.right=rightChild;
        }

        public void setKey(String key){this.key=key;}
        public String getKey(){return this.key;}
        public void setValue(int value){this.value=value;}
        public int getValue(){return this.value;}
        public void setLeft(Node n){this.left=n;}
        public Node getLeft(){return this.left;}
        public void setRight(Node n){this.right=n;}
        public Node getRight(){return this.right;}
        public boolean isLeaf(){ return (this.left==null) && (this.right==null); }
        public String toString(){return this.getKey();}
    }

    private long size;          // amount of nodes in tree
    private Node root;          // root node
    private boolean isEmpty;    // set if tree is empty

    public BinaryTree(){
        this.size=0;
        this.root=null;
        this.isEmpty=true;
    }

    public Node getRoot(){
        return this.root;
    }         // get root node

    public void add(String key,int value){              // add new one
        Node n=new Node(key,value,null,null,null);
        if(this.isEmpty){                   // if first item
            this.addRoot(key,value);        // then add the root key
        }else{
            this.add(n);                    // otherwise call normal add
        }
    }

    public void addRoot(String key, int value){     // case of adding root key
        this.root=new Node(key,value,null,null,null);
        this.size=1;
        this.isEmpty=false;
    }

    public void add(Node n) {
        Node curr = this.getRoot();         // start from root
        if (curr == null) {
            curr = n;                       // if it's first one, set
        } else {
            while (curr != null) {          // while we're won't emd up with empty node
                String tmp = curr.getKey();
                                            // if left side of curr is empty and val smaller add there
                if ((curr.getLeft() == null) && (n.getKey().compareTo(curr.getKey()) < 0)) {
                    curr.setLeft(n);        // smaller than curr, point to left side
                    this.size++;            // grow size
                    break;
                                            // if right side of curr empty and larger, add right side
                } else if ((curr.getRight() == null) && (n.getKey().compareTo(curr.getKey()) > 0)) {
                    curr.setRight(n);
                    this.size++;
                    break;
                } else if(n.getKey().compareTo(curr.getKey())==0){  // if key exists
                    curr.setValue(n.getValue());                    // update it
                }
                                            // if node was neither empty or same, traverse further
                if ((curr.getLeft() != null) && (n.getKey().compareTo(curr.getKey()) < 0)) {
                    curr = curr.getLeft();          // traverse left
                }else{
                    curr = curr.getRight();         // traverse right
                }
            }
        }
    }

    public int getValue(String key){
        return getValue(root,key);
    }   // get val, start w/ root

    public int getValue(Node n,String key){
        int val=key.compareTo(n.key);
        if(val<0) {
            return getValue(n.left, key);    // if smaller, traverse left
        }else if(val>0){
            return getValue(n.right, key);   // larger, go right
        }else{
            return n.value;               // match, return node value
        }
    }
}
