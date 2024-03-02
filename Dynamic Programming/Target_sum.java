public class Target_sum {
    
    public static void print(boolean dp[][]){
        int n=dp.length;
        int m=dp[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j]+" "+public class Target_sum {
    
                    public static void print(boolean dp[][]){
                        int n=dp.length;
                        int m=dp[0].length;
                        for(int i=0;i<n;i++){
                            for(int j=0;j<m;j++){
                                System.out.print(dp[i][j]+" ");
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }
                    
                    // variation of knapsack problem
                    public static boolean Target_sum_subset(int arr[],int sum){
                        // first creating the dp array 2 D array
                        int n=arr.length;
                        boolean dp[][]=new boolean[n+1][sum+1];
                        // now start filling the array with the base condition
                        for(int i=0;i<=n;i++){
                            dp[i][0]=true;
                        }
                        for(int j=1;j<=sum;j++){
                            dp[0][j]=false;
                        }
                        // main work of filling the dp array from bottom up approach
                        for(int i=1;i<n+1;i++){
                            for(int j=1;j<sum+1;j++){
                                // check the 2 condition   1> include   2> exclude(it combines both
                                // invalid and excluded part in the valid condition)
                                
                                // valid condition
                                int v=arr[i-1];
                                if(v<=j && dp[i-1][j-v]==true){
                                    dp[i][j]=true;
                                }
                                
                                // invalid and excluded part in the valid condition
                                else if(dp[i-1][j]==true){
                                    dp[i][j]=true;
                                }
                            }
                        }
                        print(dp);
                        return dp[n][sum];
                    }
                
                
                
                
                    public static void main(String args[]){
                        int num[]={4,2,7,1,3};
                        int sum=10;
                       // Target_sum_subset
                        System.out.println(Target_sum_subset(num, sum));
                    }
                }
                );
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // variation of knapsack problem
    public static boolean Target_sum_subset(int arr[],int sum){
        // first creating the dp array 2 D array
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        // now start filling the array with the base condition
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int j=1;j<=sum;j++){
            dp[0][j]=false;
        }
        // main work of filling the dp array from bottom up approach
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                // check the 2 condition   1> include   2> exclude(it combines both
                // invalid and excluded part in the valid condition)
                
                // valid condition
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                
                // invalid and excluded part in the valid condition
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }




    public static void main(String args[]){
        int num[]={4,2,7,1,3};
        int sum=10;
       // Target_sum_subset
        System.out.println(Target_sum_subset(num, sum));
    }
}
