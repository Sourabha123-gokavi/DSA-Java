import java.util.*;
public class Edit_Distance{
    
    public static int Edit_Tabulation(String str1,String str2){
        //create the dp array
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        //now initilazation
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        //now start filling the dp array
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                // check the condition
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rem=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add,Math.min(del, rem));
                }
            }
        }
        return dp[n][m];
    }
    
    public static void main(String[] args) {
        String str1="intention";
        String str2="execution";
        System.out.println(Edit_Tabulation(str1, str2));
    }
}