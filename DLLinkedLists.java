/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abuslabweek4; //DoublyLL

/**
 *DLLinkedLists.java
 *N Varadi
 *17 02 2021
 * @param <T>
 */
public class DLLinkedLists<T> implements DLList<T>{
    
    private DLNode<T> first; //create references to first and last elements in the list
    private DLNode<T> last;
    
    public DLLinkedLists(){ //constructor, initial values to our variables
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        //return first == null;
      if(first == null){ //if first element does not exist, the whole is empty
          return true;
      }
      else{
          return false; //if first element exist, list is not empty
      }
    }

    @Override
    public int size() { //number of elements in the list
        if(isEmpty()){ //if list is empty, size is 0
            return 0;
        }
        /*int size = 1; //if list is not empty, then we have at least one element in it
        DLNode<T> current = last; //a reference, pointing to the last element
        while(current.prev != null){
            current = current.prev;
            size++;
        }*/
        
        int count = 0;
        DLNode<T> p = first;
        while (p != null){
            count++;
            p = p.next;
        }
        //return size;
        return count;
    }
    
    @Override
    public void prepend(T elem) {//new element goes to the front of the list
      if(isEmpty()) { //if list is empty
        first = new DLNode(elem, null, null);//new element created, there's nothing before and after it yet
        last = first;
      }
      else{ //list in not empty
       
        first = new DLNode(elem, null, first); //new element goes to the front, there nothing before it, the old first element is after it
        
        first.next.prev = first; //ensure that reference to our first element is pointing to the new first element
      }
        
    }

    @Override
    public void add(T elem) {//new element goes to the end of list
        if(isEmpty()) { //if list is empty
        prepend(elem);//we can reuse prepend() method to add to the front of list
        }
        else {
        
          last.next = new DLNode(elem, last, null); //new element follows the last one, the previous node is the old last one
          last = last.next; //the last node now is the one that follows the old last one
        }
        
    }

    @Override
    public void add(int index, T elem) { //adds new element at a given index
      if(index < 0 || index >= size()) {//if the required index is not valid, give error
        throw new IndexOutOfBoundsException();
      }
    //if we want to add at the beginning of the list
        if(index == 0) {
          prepend(elem); //reuse prepend method when adding at the start of list
          return;
        }
    //if we want to add inside the list
    DLNode<T> predecessor = first; //create a reference, point it to the first node
    for(int i = 0; i < index - 1; i++) {//locate the preceeding index of the required index
      predecessor = predecessor.next;
     
    }
    DLNode<T> successor = predecessor.next; //another reference, now points to the index we want to add the new node to
    
    DLNode<T> middle = new DLNode(elem, predecessor, successor);//create new node, it's previous node is predecessor, the one after it is successor
    predecessor.next = middle; //new node is assigned to the required index, after predecessor, before successor
    
        if(successor == null) {//if there's no node after the new node
          last = middle; //new node is the last one 
        }
        else{ //if there is a successor node exist
          successor.prev = middle; //new node preceeds it's successor
        }    
       
    }   
    
    @Override
    public T remove(int index) {
        
        if(index < 0 || index >= size()) {//if require index is invalid, provid error message
          throw new IndexOutOfBoundsException();
        }
        else if(isEmpty()) {//if list is empty, there's nothing to remove
          return null;
        }

        if(index == 0) {//if we want to remove the first node
          T element = first.elem;//a reference to the element we want to remove
          first.next.prev = null; //pointer of the first node is now poining to null, this removes the first node's connection to the list
          first = first.next;//re-assigning pointer to point to the new first node(previously this was the second node)
          return element;
        }

        // Every other position
        DLNode<T> current = first; //a reference pointing to the first node
        for(int i = 0; i < index - 1; i++) {//loop finds the preceeding index of the index we want to remove from
          current = current.next;
        }
        
        current.next = current.next.next;//now current element's next position points to the next element afterwards
        if (current.next == null) {//if now element after the current one points to null
          last = current;//current element is the last one 
        }
        else{
          current.next.prev = current;
        }
        return null;        
        
    }
    
     @Override
    public T addBefore(T target, T elem) {        
        if (isEmpty()) {
        return elem;
      }

      DLNode<T> current = first; //a reference pointing to the first node
      int index = 0; //we need to find the index of target element with a loop
      while (current != null && !current.elem.equals(target)) {
        index++;
        current = current.next;
      }

      if (current != null && current.elem.equals(target)) {
        add(index, elem); //when we find the target, call method add(index, elem) to put new elem to target index
      }

      return elem;
    }

    @Override
    public T addAfter(T target, T elem) {
        if (isEmpty()) {
        return elem;
        }

      DLNode<T> current = first;//a reference pointing to the first node
      int index = 0;//we need to find the index of target element
      while (current != null && !current.elem.equals(target)) {
        index++;
        current = current.next;
      }

      if (current != null && current.elem.equals(target)) {
        add(index + 1, elem); //reuse mentod add(index, elem) to add new element AFTER the target's index
      }        

      return elem;
    }

    @Override
    public T remove(T target){//we want to remove a specified element
        if (isEmpty()) {//if list is empty, there's nothing to remove
        return null;
        }
        //if list is not empty
        DLNode<T> current = first; //a reference pointing to the first element
        int index = 0; //we need to find the index of target element with a loop
        while (current != null && !current.elem.equals(target)) {
          current = current.next;
          index++;
        }
        if (current != null && current.elem.equals(target)) {
          return remove(index); //call remove(index) method here when the require index is found
        }
        return null;

    }
    
    @Override
    public T get(int index){ //check what's at a given index
      if(isEmpty() || index > size() || index < 0){//if list is empty or given index is invalid, provide error message
      throw new IndexOutOfBoundsException();
      }
      
       DLNode<T> current = first;//a reference pointing to the first node
       for (int i = 0; i < index; i++) {//find the required index using a loop
         current = current.next;
       }
       return current.elem;//return element at the specified index
    }
   
    @Override
    public String toString(){ //display the content of the list in String format
    String str = "";
    DLNode<T> current = first;//a reference to the first node
    while (current != null) {//loop as long as we reach the end of the list
      str += current + "\n";//store current element in a String at every iteration
      current = current.next;
    }
    return str;
  }

    @Override
    public T get(T target) {//returns a specified element from the list
        if (isEmpty()){// if list is empty, there's nothing to return 
          return null;
      }
      else{
          DLNode<T> current = first;
          int index = 0;
            while (current != null && !current.elem.equals(target)) {
              current = current.next;
              index++;
        }
        if (current != null && current.elem.equals(target)) {
          return get(index); //call get(index) method again
        }
        return current.elem;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
