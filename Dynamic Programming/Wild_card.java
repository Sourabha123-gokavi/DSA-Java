import java.util.*;
public class Wild_card{
    public static Boolean isMatch(String s,String p){
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean[n+1][m+1];
        //now initialization
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        //check for the empty string with the * char
        for(int j=1;j<m+1;j++){
            //if this is matching with the star then
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
            else{
                dp[0][j]=false;
            }
        }

        //now start filling the table in the bottom up manner
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //check if last char are equal or pattern char equal to ?
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                // check if the the last char is equal to *
                else if(p.charAt(i-1)=='*'){
                    //       * is included  * is ignored 
                    dp[i][j]=dp[i-1][j] ||  dp[i][j-1];
                }
                else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];

    }
    
    
    public static void main(String[] args) {
        String s="baaababa";
        String p="*****ba*****ab";
        System.out.println(isMatch(s, p));
    }
}