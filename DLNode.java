/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abuslabweek4; //DoublyLL

/**
 *DLNode.java
 *N Varadi
 *17 02 2021
 */
public class DLNode<T>{//creates node and pointer to it's previous and next element
    T elem;
    DLNode<T> prev;
    DLNode<T> next;
    
    public DLNode(T elem, DLNode<T> prev, DLNode<T> next){//constructor, overloaded, has setter methods inside it
        this.elem = elem;
        this.prev = prev;
        this.next = next;
    }
    
    public DLNode(T elem){//constructor2, sets inital values to data members
        this(elem, null, null);
        /*this.elem = elem;
        this.prev = null;
        this.next = null;
        */
    }
    
    @Override
    public String toString() {//method prints the content of the linked list in a from a String
      // if prev is null ? TRUE : FALSE
        /*String prevString = (prev==null ? "null" : prev.elem.toString());
        String nextString = (next==null ? "null" : next.elem.toString());
        return "DLNode{" + "elem=" + elem + ", prev=" + prevString + ", next=" + nextString + '}';*/
        
        return elem.toString();
    }
    
}
