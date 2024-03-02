import java.util.*;
public class JCF {
    public static void main(String args[]){
        LinkedList<Integer>ll=new LinkedList<Integer>();
        // adding the element at particular index
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        // adding the element at particular index
        ll.add(2, 1);
        // setting or updating the element at particular element
        ll.set(4,9);
        // to get the element at particular index
        //System.out.println(ll.get(3));
        
        // Iterating over the linked list\
        // for(Integer i: ll){
        //     System.out.println(i);
        // }

        // converting the linked list into array using toArray();
        //Object[] a = ll.toArray();
        // Object arr[]=ll.toArray();
        // for(Object i:ll){
        //     System.out.print(i);
        // }

        // adding the entire object to the linked list
        //ll.addAll(1,ll);

        // to clear all the contents of the linked list
        //ll.clear();
        
        // to clone the entire linked list  # this is not working see it once again
        // LinkedList<Integer> lll=new LinkedList<>();
        // lll=ll.clone();

        // to check the if the element is present or not
        //System.out.println(ll.contains(2));  # insted of a number we can use object to check

        //
        
        
        //System.out.println(ll);
    }
}
