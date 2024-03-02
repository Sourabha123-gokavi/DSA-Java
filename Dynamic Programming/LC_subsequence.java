// Longest common sequence
import java.util.*;


public class LC_subsequence {
    public static int Rec_LCS(String str1,String str2,int n,int m){
        //base case
        if(n==0 || m==0){
            return 0;
        }
        //main work
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return 1+Rec_LCS(str1, str2, n-1, m-1);
        }
        else{
            int ans1=Rec_LCS(str1, str2, n-1, m);
            int ans2=Rec_LCS(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    //LCS memoization
    public static int LCS_mem(String str1,String str2,int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        //now check if it is there or not
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //now main work
        //if the characters are equal
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m]=1+LCS_mem(str1, str2, n-1, m-1, dp);
        }
        //else
        else {
            //now we have choices
            int ans1=LCS_mem(str1, str2, n-1, m, dp);
            int ans2=LCS_mem(str1, str2, n, m-1, dp);
            return dp[n][m]=Math.max(ans1, ans2);
        }

    }
    
    public static int Tabulation_LCS(String str1,String str2,int n,int m){
        //creater the dp array
        int dp[][]=new int[n+1][m+1];
        //now initialization of the dp array
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        //now start filling the dp array in the bottom up manner
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                // case-1 when the characters are equal
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                // case-2 when choices are presenet
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    
    
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        // This is recurssion code
        //System.out.println(Rec_LCS(str1, str2, str1.length(), str2.length()));
        int n=str1.length();
        int m=str2.length();
        // int dp[][]=new int[n+1][m+1];
        //initialization of dp array
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(LCS_mem(str1, str2, n, m, dp));

        //tabulation system call
        System.out.println(Tabulation_LCS(str1, str2, n, m));
    }
    
}
