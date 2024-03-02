import java.util.*;
public class LI_Subseq {
    public static int LC_sub(int arr[],int arr2[]){
        int n=arr.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];
        //now initialzation
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //now check the condition
                // valid condition
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }


    public static int helper(int arr[]){
        HashSet<Integer>set=new HashSet<>();
        //Adding the elements to set ,because to remove the duplicate elements
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[]=new int[set.size()];
        int i=0;
        for (int num : set) {
            arr2[i]=num;
            i++;
        }
        return LC_sub(arr,arr2);
    }
    public static void main(String[] args) {
        int arr[]={50,3,10,7,40,80};
        System.out.println(helper(arr));
    }
    
}
