import java.util.*;
public class Fractionalknapsack {
    public static void main(String[] args) {
        int weight[]={10,20,30};
        int val[]={60,100,120};
        int W=50;
        // store it in 2D array and sort is based on ratio
        double ratio[][]=new double[val.length][2];
        for(int i=0;i<val.length;i++){
            // oth col=>index ; 1st col=>ratio
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }
        // now sort it based on ratio value
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        // since it is  sorted in ascending order 
        // run the loop in reverse order
        
        int Capacity=W;
        int FinalVal=0;
        for(int j=val.length-1;j>=0;j--){
            // case 1 => include fully
            int idx=(int)ratio[j][0];
            if(Capacity>=weight[idx]){
                Capacity=Capacity-weight[idx];
                FinalVal=FinalVal+val[idx];
            }
            else{
            // case 2=> Include fractionally and break
                FinalVal=FinalVal+(int)(ratio[j][1]*Capacity);
                Capacity=0;
                break;
            }
        }
        System.out.println("The maximum capacity is =>"+FinalVal);



    }
}
