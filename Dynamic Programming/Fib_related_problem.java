import java.util.*;
public class Fib_related_problem {
    // Climbing statirs problem
    // Time complexity is O(n)
    // much better than the normal recusion code

    // usign memoization
    public static int Climbing_counts(int n,int dp[]){
        // base condition
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0; 
        }
        
        // main work        
        if(dp[n]!=-1){// if already calculated
            return dp[n];
        }
        // else store the value in dp[n]
        dp[n]=Climbing_counts(n-1, dp)+Climbing_counts(n-2, dp);
        // then return
        return dp[n];       
    
    }
    

    // using the tabulation dp
    public static int Climbing_counts_tab(int n){
        // create the tabulation
        int dp[]=new int[n+1];
        // now start the filling the array dp 
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        // final answer is the element stored int the last index 
        return dp[n];
    }
    
    public static void main(String args[]){
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        //System.out.println(Climbing_counts(n,dp));// ans is 8
        System.out.println(Climbing_counts_tab(n));
    }
}
