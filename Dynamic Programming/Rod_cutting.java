import java.util.*;
public class Rod_cutting {
    public static int rod_dp(int length[],int prices[],int rodlength){
            int dp[][]=new int[prices.length+1][rodlength+1];
            for(int i=0;i<prices.length+1;i++){
                dp[i][0]=0;
            }
            for(int j=0;j<rodlength+1;j++){
                dp[0][j]=0;
            }

            //main work
            for(int i=1;i<prices.length+1;i++){
                for(int j=1;j<rodlength+1;j++){
                    //check the valid condition
                    if(length[i-1]<=j){
                        dp[i][j]=Math.max(prices[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                    }
                    //invalid condition
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }




        return dp[length.length][prices.length];

    }
    public static void main(String args[]){
        int length[]={1,2,3,4,5,6,7,8};
        int prices[]={1,5,8,9,10,17,17,20};
        int rodlength=8;
        System.out.println(rod_dp(length, prices, rodlength));
    }
}
