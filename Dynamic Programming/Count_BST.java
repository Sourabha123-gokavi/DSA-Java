import java.util.*;
public class Count_BST{
    public static int BST_count(int n){
        //create dp array 
        int dp[]=new int[n+1];
        //initialization of dp array
        dp[0]=1;
        dp[1]=1;
        //now start filling array in bottom up manner
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left=dp[j];
                int right=dp[i-1-j];
                dp[i]+=left*right;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(BST_count(n));

    }
}