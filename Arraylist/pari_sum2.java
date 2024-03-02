// finding the target sum in sorted and rotated array
import java.util.ArrayList;

public class pari_sum2 {
    public static Boolean pair_sum_2(ArrayList<Integer>list,int target){
        // first finding the pivot point
        int bp=-1;
        int n=list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        // finding the pair sum conditions ->cases
        int lp=bp+1;
        int rp=bp;
        while(lp!=rp){
            int sum=list.get(lp)+list.get(rp);
            // case 1 : target=sum
            if(sum==target){
                return true;
            }
            // case 2: update the rp to left
            else if(sum>target){
                // using the modular arithmatic operation
                rp=(n+rp-1)%n;
            }
            // case 3: updation of the lp to right
            else{
                lp=(lp+1)%n;
            }
        }
        return false;

    }
    public static void main(String args[]){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target=16;
        System.out.println(pair_sum_2(list,target));
        


    }
    
}
