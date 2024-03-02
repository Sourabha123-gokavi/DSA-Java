import java.util.*;
public class  Pair_sum{
    // Brute force approach   -> Time complexity=O(n^2)
    public static Boolean pair_sum_1(ArrayList<Integer>list,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }


    //2 pointer approach -> the time complexity of this code is O(n)
    public static Boolean pair_sum(ArrayList<Integer>list,int target){
        int lp=0;
        int rp=list.size()-1;
        while(lp!=rp){
            // checking the sum is equal to target
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            // if sum if greater than the target move the rp to the left
            else if(list.get(lp)+list.get(rp)>target){
                rp--;
            }
            // if the sum is smaller than the target then make the lp to the right
            else if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
        }
        return false;

    }




    public static void main(String args[]){
        ArrayList<Integer> array=new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        int target=20;
        //System.out.println(pair_sum_1(array,target));
        System.out.println(pair_sum(array,target));
        
    }
}