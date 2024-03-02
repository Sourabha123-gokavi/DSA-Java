//This is wrong please code once again
import java.util.*;
public class Matrix {
    public static int MCM(int arr[],int i,int j){
        // base case
        if(i == j){
            return 0;// Single matrix case
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1=MCM(arr,i,k);     //Ai,.....Ak    => arr[i-1]xarr[k]
            int cost2=MCM(arr,k+1,j);   //Ak+1,.....Aj  => arr[k]xarr[j+1]
            int cost3=arr[i-1]*arr[k]*arr[j];
            int final_cost=cost1+cost2+cost3;
            ans=Math.min(ans, final_cost);
        }
        return ans;
    }
    
    
    // Memoization
    public static int Memoization_mcm(int arr[],int i,int j,int dp[][]){
        //base case
        if(i==j){
            return 0;
        }
        // check if it is already calculated
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=Memoization_mcm(arr, i, k, dp);
            int cost2=Memoization_mcm(arr, k+1, j, dp);
            int cost3=arr[i-1]*arr[k]*arr[j];
            int final_cost=cost1+cost2+cost3;
            ans=Math.min(ans, final_cost);
        }
        //now before returning just store and return
        return dp[i][j]=ans;
    } 

    //tabulation approach
    public static int MCM_tabulation(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        //now initialization of array
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }    
        //  now start filling the dp array in bottom up manner 
        //  here the diagonlly filled
        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }

    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        int n=arr.length;
        //System.out.println(MCM(arr, 1, n-1));
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        //System.out.println(Memoization_mcm(arr, 1, n-1, dp));
        System.out.println(MCM_tabulation(arr));
        //  0  0  0  0   0  
        //  0  0  6  18  30  
        //  0  0  0  24  48  
        //  0  0  0  0   36  
        //  0  0  0  0   0 
    }
}
