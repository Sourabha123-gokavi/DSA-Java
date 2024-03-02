import java.lang.management.MemoryMXBean;
import java.util.*;
public class ActivitySelection {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // sorting the arrray based on the ending time


        // initializing 
        int maxAct=0;
        ArrayList<Integer>arr=new ArrayList<>();

        maxAct=1;
        arr.add(0);

        int LastTime=end[0];
        for(int i=1;i<start.length;i++){
            // activity selection condition
            if(start[i]>=LastTime){
                maxAct++;
                arr.add(i);
                LastTime=end[i];
            }
        }
        System.out.println("max activity selection are "+maxAct);
        for(int k=0;k<arr.size();k++){
            System.out.print("A"+arr.get(k)+" ");
        }


    }
}
