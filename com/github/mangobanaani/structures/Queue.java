package com.github.mangobanaani.structures;

/**
 *  simple queue (FIFO) based on array, autogrow, autoshrink
 *
 *  Created by mangobanaani on 17/07/2017.
 *
 */

public class Queue {
    private Node first;     // least recently added
    private Node last;      // most recently added
    private int size;       // queue size

    private static class Node{
        Object item;
        Node next;

        public Node(Object value) {
            this.item=value;
        }
    }

    public boolean isEmpty(){   // if empty
        return this.size == 0;
    }

    public int getSize(){return this.size;} // get size of queue

    public void enqueue(Object value){      // add to queue
        Node tmp=last;
        this.last=new Node(value);
        this.last.item=value;
        this.last.next=null;
        if (this.isEmpty()) {
            this.first=this.last;
        }else{
            tmp.next = last;
        }
        this.size++;
    }

    public Object dequeue(){                // remove from queue
        Object o=first.item;                // o least recently used (beginning)
        this.first=first.next;
        this.size--;
        if(this.isEmpty()){
            this.last=null;
        }
        return o;
    }
}
