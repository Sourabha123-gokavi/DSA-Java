import java.util.*;
public class unbounded_knapsack {
    // usign tabulation
    public static int Unbounded(int val[],int wt[],int W){
        int n=wt.length;
        int dp[][]=new int[n+1][W+1];
        // initialization of dp
        for(int i=0;i<W+1;i++){
            dp[0][i]=1;
        }
        for(int j=1;j<n+1;j++){
            dp[j][0]=0;
        }
        //now start filling the dp array using the loops
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                //valid condition 
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    // using memoization
    //public static void Unbounded_mem(int val[],int wt[],int W)

    
    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(Unbounded(val, wt, W));
    }
}
