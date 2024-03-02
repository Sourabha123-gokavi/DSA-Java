import java.util.*;

public class Mountain {
    public static int Mountain_Pair(int n){
        // create dp array 
        int dp[]=new int[n+1];
        //initialization of dp array
        dp[0]=1;
        dp[1]=1;
        //now start filling the dp array in bottom up manner
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside_pair=dp[j];
                int outside_pair=dp[i-1-j];
                dp[i]+=inside_pair*outside_pair;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(Mountain_Pair(n));
    }   
}
