/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abuslabweek4; //DoublyLL

/**
 *DLList.java
 *N Varadi
 *17 02 2021
 */

public interface DLList<T>{
    
    public boolean isEmpty();
    public int size();
    public void add(T elem);
    public void add(int index, T elem);
    public String toString();
    public void prepend(T elem);
    public T remove(T target); 
    public T remove(int index); 
    public T addBefore(T target, T elem);
    public T addAfter(T target, T elem);
    public T get(int index);
    public T get (T target);
}
