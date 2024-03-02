import java.util.*;
public class Min_jumps{
    public static int MIN_jumps(int arr[]){
        int n=arr.length;
        //create dp array
        int dp[]=new int[n];
        //initialization of dp array
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        
        // Now start filling dp array in the bottom up manner
        // start from reverse order
        for(int i=n-1;i>=0;i--){
            int steps=arr[i];
            int ans=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n;j++){
                //find answer if it is valid ie; if the jumps are possible from that index
                if(dp[j]!=-1){
                    ans=Math.min(ans, dp[j]+1);
                }
            }
            // assign the answer to dp[i] only if it is not equla to infinity
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        return dp[0];
        
    }
    public static void main(String[] args) {
        int arr[]={1,3,1,1,4};
        System.out.println(MIN_jumps(arr));
    }
}