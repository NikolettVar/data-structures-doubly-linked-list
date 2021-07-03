/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abuslabweek4; //DoublyLL

/**
 *DLListApp.java
 *N Varadi
 * 23 02 2021
 */
public class DLListsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*DLList<String> list = new DLLinkedLists<>();
        System.out.println(list.isEmpty());
        
        list.prepend("John");
        list.prepend("James");
        list.add("Mary");
        list.add(0, "Jack" );
        list.add(3, "New Guy");
        list.addBefore("James", "Joe");
        list.addAfter("Jack", "Steve");
        list.remove(3);
        list.remove("Steve");
        
        System.out.println(list.toString());
        System.out.println(list.get(0));
        System.out.println(list.size());*/
        
        DLList<String> numbers = new DLLinkedLists<>();
        numbers.prepend("apple");
        numbers.add("mango");
        numbers.add("banana");
        numbers.add("kiwi");
        numbers.add("pear");
        numbers.add(0, "lemon");
        numbers.remove(0);
        System.out.println(numbers.toString());
        
       
      
    }
}
