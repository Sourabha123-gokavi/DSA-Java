import java.util.*;



public class basic_problem {
    public static void main(String args[]){
        ArrayList <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(7);
        // swap the 2 numbers from the index 2 and 4;
        int temp1=list.get(2);
        int temp2=list.get(4);
        list.set(4,temp1);
        list.set(2,temp2);
        System.out.println(list);


        // sorting the list
        Collections.sort(list);
        System.out.println(list);





    }
    
}
