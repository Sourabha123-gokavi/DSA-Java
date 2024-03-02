import java.util.*;

import javax.print.attribute.HashAttributeSet;
public class hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer>hm=new HashMap<>();
        // some basic operation on the hashmap

        // adding to the hash map
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        //System.out.println(hm);


        // to get the value of given key
        int population=hm.get("India");
        System.out.println("population of India is "+population);

        // to chech if the given key is present in the map
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        // to remove the given key from the map
        hm.remove("China");
        System.out.println(hm);
        System.out.println(hm.remove("Lanka"));

        // to find the size fo the map
        System.out.println(hm.size());

        // to check if the map is empty or not
        System.out.println(hm.isEmpty());

        // to clear all the map contents
        hm.clear();
        System.out.println(hm);
        System.out.println(hm.isEmpty());

        HashMap<String,Integer> HM=new HashMap<>();
        HM.put("India", 100);
        HM.put("China", 200);
        HM.put("US", 300);
        HM.put("Russia", 400);
        HM.put("SA", 500);
        HM.put("Pakistan", 600);

        // how creating the set to store the key value in the set

        // using for each loop
        Set<String>S=HM.keySet();
        for (String string : S) {
            System.out.println("The country "+string+" have population "+HM.get(string));
        }


        


    }
}
