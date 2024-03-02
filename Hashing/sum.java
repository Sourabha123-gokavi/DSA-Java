import java.util.HashMap;

public class sum {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10,17};
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int len=0;
        // pre sum method 
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            // checking if it is present or not
            if(map.containsKey(sum)){
                len=Math.max(len, j-map.get(sum));
            }
            else{
                map.put(sum, j);
            }
        }
        System.out.println(len);
    }
    
}
