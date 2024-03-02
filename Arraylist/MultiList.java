import java.util.ArrayList;

import java.util.*;

public class MultiList {
    public static void main(String args[]){
        // creating the multiList
        ArrayList<ArrayList<Integer>> multilist=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        // now adding the element  to list 1
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);


        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);


        list3.add(3);
        list3.add(6);
        list3.add(8);
        list3.add(12);
        list3.add(15);

        multilist.add(list1);
        multilist.add(list2);
        multilist.add(list3);

        System.out.println(multilist);
        // accessing the element from the multi list using the for loop
        for(int i=0;i<multilist.size();i++){
            ArrayList<Integer> temp1=multilist.get(i);
            for(int j=0;j<temp1.size();j++){
                System.out.print(temp1.get(j)+" ");
            }
            System.out.println();
        }








    }
    
}
