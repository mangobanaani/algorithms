package com.github.mangobanaani.structures;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *  simple doubly linked list
 *
 *  Created by mangobanaani on 19/07/2017.
 *
 */

public class LinkedList {
    private static class Node {
        private Object data;
        private Node next;
        private Node previous;

        public Node() {}

        public Node(Object data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size;
    private final Node pre;
    private final Node post;

    public LinkedList() {
        pre =new Node();
        post =new Node();
        pre.next = post;
        post.previous = pre;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return this.size; }

    public void add(Object item) {
        Node last= post.previous;
        Node x=new Node(item, post,last);
        post.previous=x;
        last.next=x;
        size++;
    }

    public ListIterator<Object> iterator()  { return new LinkedListIterator(); }

    private class LinkedListIterator implements ListIterator<Object> {
        private Node curr= pre.next;
        private Node last=null;
        private int indx=0;

        @Override
        public boolean hasNext(){
            if (indx < size) return true;
            else return false;
        }

        @Override
        public boolean hasPrevious(){
            if (indx > 0) return true;
            else return false;
        }

        @Override
        public int previousIndex(){ return indx-1; }

        @Override
        public int nextIndex(){ return indx; }

        @Override
        public Object next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            last=curr;
            Object o=curr.data;
            curr=curr.next;
            indx++;
            return o;
        }

        @Override
        public Object previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            curr=curr.previous;
            indx--;
            last=curr;
            return curr.data;
        }

        @Override
        public void set(Object o) {
            if(last==null) {
                throw new IllegalStateException();
            }
            last.data=o;
        }

        @Override
        public void remove() {
            if(last==null) {
                throw new IllegalStateException();
            }
            Node x=last.previous;
            Node y=last.next;
            x.next=y;
            y.previous=x;
            size--;
            if(curr==last) {
                curr = y;
            } else {
                indx--;
            }
            last=null;
        }

        @Override
        public void add(Object o) {
            Node x=curr.previous;
            Node y=new Node();
            Node z=curr;
            y.data=o;
            x.next=y;
            y.next=z;
            z.previous=y;
            y.previous=x;
            size++;
            indx++;
            last=null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList that = (LinkedList) o;
        if (size != that.size) return false;
        return pre.equals(that.pre) && post.equals(that.post);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + pre.hashCode() + post.hashCode();
        return result;
    }
}

