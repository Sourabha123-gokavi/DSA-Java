import java.time.chrono.HijrahEra;
import java.util.ArrayList;
public class max_water {

    // optimized code for max water -> TC= O(n)
    // do it again because it is running wrong
    public static int maxwater(ArrayList<Integer>height){
        int lp=height.get(0);
        int rp=height.get(height.size()-1);
        int max=0;

        
        while(lp<rp){
            // calculate the area
            int templ=(rp-lp)*(Math.min(height.get(lp),height.get(rp)));
            max=Math.max(max, templ);

            if(lp>rp){
                rp--;
            }
            else{
                lp++;
            }

        }
        return max;
    }


    public static void main(String args[]){
        ArrayList<Integer> container_height=new ArrayList<>();
        //container_height={1,8,6,2,5,4,8,3,7};
        container_height.add(1);
        container_height.add(8);
        container_height.add(6);
        container_height.add(2);
        container_height.add(5);
        container_height.add(4);
        container_height.add(8);
        container_height.add(3);
        container_height.add(7);
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<container_height.size();i++){
        //     int temp1=container_height.get(i);
        //     for(int j=0;j<container_height.size();j++){
        //         int temp2=container_height.get(j);
        //         int temp3=(Math.min(temp1,temp2))*(Math.abs((i-j)));// to find the area
        //         if(temp3>max){
        //             max=temp3;
        //         }
        //     }
        // }
        // System.out.println(max);
        System.out.println(maxwater(container_height));
    }
    
}
