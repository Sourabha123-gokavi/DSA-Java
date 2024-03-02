import java.util.HashMap;
import java.util.*;

public class maximum {
    public static void main(String[] args) {
        int arr[]={1,3,2,1,3,1,5,1};
        HashMap<Integer,Integer>m=new HashMap<>();
        // insert the number in the hasm map so that we can track the frequency
        // for(int i=0;i<arr.length;i++){
        //     int num=arr[i];
        //     if(m.containsKey(num)){
        //         m.put(num, m.get(num)+1);
        //     }
        //     else{
        //         m.put(num, 1);
        //     }
        // }
        // Set<Integer>s=m.keySet();
        // for (Integer i : s) {
        //     if(m.get(i)>(arr.length)/3){
        //         System.out.print(i+" ");
        //     }
        // }

            // here we are going to use the getOrDefault function 
            // if else condition both are doing something then we can use this

        for(int i=0;i<arr.length;i++){
            
            m.put(arr[i], m.getOrDefault(arr[i],0)+1);
            // the above statement means that we are going to find that element in the map then we are going to get the
            // key value for that element else them we can pass default value as 0
            // and then we are going to add +1 to that value 
        }
        // Set<Integer>s=m.keySet();
        // we can also remove this set and write in the loop directly
        for (Integer i : m.keySet()) {
            if(m.get(i)>(arr.length)/3){
                System.out.print(i+" ");
            }
        }

    }
    
}
