import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Set {
    public static void main(String[] args) {
        HashSet<Integer>set=new HashSet<>();
        // add function
         set.add(1);
         set.add(2);
         set.add(3);
         set.add(1);
         set.add(4);
         set.add(2);

         // remove operation
        set.remove(2);
        set.remove(1);

        // contains operation
        System.out.println(set.contains(2));
        System.out.println(set.contains(3));

        // size operation 
        System.out.println("The size of the set is "+set.size());

        // isEmpty() operation
        System.out.println(set.isEmpty());
        
        // clear() operation
        set.clear();
        System.out.println(set.isEmpty());

        System.out.println(set);

        

        // these are unordred and thesa do not use any speacial thing so order is not maintained
        HashSet<String> city=new HashSet<>();
        city.add("Mumbai");
        city.add("Noida");
        city.add("Bangaluru");
        city.add("Chennai");
        

        // using the iterator to iterate the set
        System.out.println("This is iterating the set through the iterator ");
        Iterator it=city.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


        // using the advanced for loop
        System.out.println("This is iterating the set through the advanced for loop");
        for (String citi : city) {
            System.out.println(citi);
        }


        // linkedHash set
        // here the order is maintained as they inserted 
        LinkedHashSet<String> lhs=new LinkedHashSet<>();
        lhs.add("India");
        lhs.add("Mumbai");
        lhs.add("Bangaluru");
        lhs.add("Australia");
        System.out.println("These are the elements from the Linked hash set ");
        Iterator I=lhs.iterator();
        while(I.hasNext()){
            System.out.println(I.next());
        }

        // Tree set
        //here the elements are ordered in ascending order because they uses red black tree
        TreeSet<String>ts=new TreeSet<>();
        ts.add("India");
        ts.add("Mumbai");
        ts.add("Bangaluru");
        ts.add("Australia");
        System.out.println("These are the elements from the Tree Set");
        Iterator T=ts.iterator();
        while(T.hasNext()){
            System.out.println(T.next());
        }


    }
}
