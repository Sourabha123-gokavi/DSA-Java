import java.util.*;
public class coin_dp{
    
    public static int coin_change(int sum,int coin[]){
        int n=coin.length;
        int dp[][]=new int[n+1][sum+1];
        //now initailize the dp array
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<sum+1;j++){
            dp[0][j]=0;
        }
        //now start filling the array in bottom up manner
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                //now check the valid condition
                if(coin[i-1]<=j){  //here include the coin or take from the previous iteration
                    dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    
    public static void main(String args[]){
        int coin[]={1,2,3};
        int sum=4;
        System.out.println(coin_change(sum, coin));
        

        
    }
}