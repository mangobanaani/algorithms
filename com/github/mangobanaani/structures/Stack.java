package com.github.mangobanaani.structures;

/**
 *  simple stack (LIFO) based on array, autogrow, autoshrink
 *
 *  Created by mangobanaani on 17/07/2017.
 *
 */

public class Stack {
    private Object[] elements;          // array to hold elements
    private int size=0;                 // initial size of stack

    public Stack(int stacksize){this.elements=new Object[stacksize];}
    public int lenght(){return this.size;}
    public boolean isEmpty(){
        return this.size <= 0;
    }

    private void resize(int stacksize){             // resize stack to number of entries
        Object[] tmpstack=new Object[stacksize];
        for(int x=0;x<this.elements.length;x++){
            if(this.elements[x]!=null) {
                tmpstack[x] = this.elements[x];
            }
        }
        this.elements=tmpstack;                     // set old to reference new copy
    }

    public void push(Object value){                 // put new value to stack
        if(this.size==this.elements.length){        // if size equals array size double array size
            this.resize(2*this.size);
        }
        this.elements[this.size++] = value;
    }

    public Object pop(){
        if(this.size==0){return null;}          // if stack is empty return null
        Object val=this.elements[--this.size];  // grab from top
        this.elements[this.size]=null;
        if(this.size>0 && this.size==this.elements.length/2){   // if size less 1/2 of array, shrink
            this.resize((this.elements.length/2)+1);   // new size half+1
        }
        return val;
    }
}
