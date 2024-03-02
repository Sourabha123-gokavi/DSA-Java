import java.util.*;
import java.util.Comparator;

public class ActivitySelection_unsorted {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // sorting the arrray based on the ending time
        // if array is not sorted based on the end time 
        int activities[][]=new int[start.length][3];
        for(int j=0;j<start.length;j++){
            activities[j][0]=j;// storing the index
            activities[j][1]=start[j];// storing the start time
            activities[j][2]=end[j];// storing the end time

        }
        // sorting the array using the lambda fucntion
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));

        // initializing 
        int maxAct=0;
        ArrayList<Integer>arr=new ArrayList<>();

        maxAct=1;
        arr.add(activities[0][0]);

        int LastTime=activities[0][2];
        for(int i=1;i<start.length;i++){
            // activity selection condition
            if(activities[i][1]>=LastTime){
                maxAct++;
                arr.add(activities[i][0]);
                LastTime=activities[i][2];
            }
        }
        System.out.println("max activity selection are "+maxAct);
        for(int k=0;k<arr.size();k++){
            System.out.print("A"+arr.get(k)+" ");
        }


    }
}
