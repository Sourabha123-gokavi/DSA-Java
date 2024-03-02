import java.util.*;
public class Catlan {

    // This is recursion approach method to solve the Catlan problem
    public static int Rec_catlan(int n){
        //base case
        if(n==0 || n==1){
            return 1;
        }
        //main work
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Rec_catlan(i)*Rec_catlan(n-1-i);
        }
        return ans;
    }

    // Memoization method
    public static int Mem_Catlan(int n,int dp[]){
        // base case
        if(n==0 || n==1){
            return 1;
        }
        //now check if the Cn is always calculated or not
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Mem_Catlan(i, dp)*Mem_Catlan(n-1-i, dp);
        }
        return dp[n]=ans;
    }

    // catlan number tabulation approach
    public static int cat_tabulation(int n){
        //create dp array
        int dp[]=new int[n+1];
        //initialization of number
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            //calculating catlan number Ci
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=6;
        //System.out.println(Rec_catlan(n));
        //int dp[]=new int[n+1];
        //Arrays.fill(dp,-1);
        //System.out.println(Mem_Catlan(n, dp));
        System.out.println(cat_tabulation(n));
    }
}
