import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
public class LinkedHash {
    public static void main(String[] args) {
        // here the elements are accessed as how we have inserted in the hasm map 
        // here we are using the doubly linked list
        LinkedHashMap<String ,Integer>lhm=new LinkedHashMap<>();
        lhm.put("INDIA", 100);
        lhm.put("China", 200);
        System.out.println(lhm);

        HashMap<String,Integer>hm=new HashMap<>();
        hm.put("India", 100);
        hm.put("china", 200);
        System.out.println(hm);



        // tree map is used 
        // here the elements are sorted based on the key 
        // because it is going to use the red black tree
        TreeMap<String,Integer>tm=new TreeMap<>();
        tm.put("C", 100);
        tm.put("B", 200);
        tm.put("a",300);
        System.out.println(tm);
    }
}
