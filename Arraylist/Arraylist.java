import java.util.*;
import java.io.*;

public class Arraylist {
    public static void main(String args[]){
        // declaration of Arraylist;
        ArrayList<Integer> list =new ArrayList();
        // adding the element to the arraylist
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        //Collections.sort(list);
        //System.out.print(list);
        ArrayList<Integer> list1=new ArrayList<>();

        // getting the index of particular element
        System.out.print(list.indexOf(2));
        
        
         //adding list 1 to list
        //  list1.add(10);
        // list1.add(20);
        // list.addAll(2,list1);
        //  System.out.println(list);

        // cloning the list to another list
        //list1=(ArrayList)list.clone();
        //System.out.println(list1);

        // contains returns true if present else false
        //System.out.println(list.contains(2));
        
       
        
        // get the element from the arraylist based on index
        //System.out.println(list.get(3));

        // remove the element from the arraylist based on index
        //list.remove(3);

        //
        
        // size of the arraylist
        //System.out.println(list.size());
        
        
        
        
        //System.out.println(list);
    }

    
}
