import java.util.*;
public class LC_substring {
    public static int LC_sub(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        //now initialize the dp array
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        int ans=0;
        //now start filling the dp array in the bottom up ma
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //check the valid condition
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans, dp[i][j]);
                }
                //if different then set the dp index to zero
                else{
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }

    
    
    public static void main(String[] args) {
        String str1="XYZAB";
        String str2="ABXYZ";
        System.out.println(LC_sub(str1, str2));
    }
}
