import java.util.*;
public class Partition {
    public static int Set_partition(int arr[]){
        int n=arr.length;
        //first find the sum
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        //now create dp array
        int w=sum/2;
        int dp[][]=new int[n+1][w+1];
        //now initialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<w+1;j++){
            dp[0][j]=0;
        }
        //now start filling the dp array in the bottom up manner
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                //check valid condition
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                //invalid condition
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][w];
        int sum2=sum-sum1;
        return Math.abs(sum2-sum1);
    }
    public static void main(String[] args) {
        int arr[]={1,11,5,6};
        System.out.println(Set_partition(arr));
    }
}
