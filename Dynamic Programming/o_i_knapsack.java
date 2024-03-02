import java.util.*; 
public class o_i_knapsack{
    // recursive approach to solve the o 1 knapsack problem
    public static int knapsack(int val[],int wt[],int n,int W){
        // base condition
        if( W==0|| n==0){
            return 0;
        }

        // main work
        if(wt[n-1]<=W){// checking if the val is less than the bag weight
            // include
            int ans1=val[n-1]+knapsack(val, wt, n-1, W-wt[n-1]);
            // exclude
            int ans2=knapsack(val, wt, n-1, W);
            // now return max among both 
            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(val, wt, n-1, W);
        }
    }





    // memoization method for the knapsack problem
    // this code run with the time complexity TC=O(n*M)
    // which is the best time complexity with regerad to the O(2^n) 
    public static int knapsack_mem(int val[],int wt[],int n,int W,int dp[][] ){
         // base condition
        if( W==0|| n==0){
            return 0;
        }

        // check the if it exists or not
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        // main work
        if(wt[n-1]<=W){// checking if the val is less than the bag weight
            // include
            int ans1=val[n-1]+knapsack_mem(val, wt, n-1, W-wt[n-1],dp);
            // exclude
            int ans2=knapsack_mem(val, wt, n-1, W,dp);
            // store and then return the value
            dp[n][W]= Math.max(ans1, ans2);
            return dp[n][W];
        }
        else{
            // first store and return 
            dp[n][W]=knapsack_mem(val, wt, n-1, W,dp);
            return dp[n][W];
        }
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    // this is the tabulation code for the knpasack problem
    // this code is more effecient than the normal recursion problem
    // time complexity is going to be the O(n*W)
    // since 2 loops are there which runs for the n and W
    public static int knapsack_tabulation(int val[],int wt[],int n,int W){
        int dp[][]=new int[n+1][W+1];
        // initialize the row to 0
        for(int i=0;i<W+1;i++){
            dp[0][i]=0;
        }
        // initialize the col to o
        for(int j=0;j<n+1;j++){
            dp[j][0]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                // valid condition
                int value=val[i-1];
                int weight=wt[i-1];
                if(weight<=j){// here i made the mistake please see it once again 
                    //insted of writing less than j i have written W 
                    // first included condtion
                    int IncProfit=value+dp[i-1][j-weight];
                    // excluded condition
                    int ExcProfit=dp[i-1][j];
                    // now store the maximum among the both
                    dp[i][j]=Math.max(IncProfit,ExcProfit);
                }
                // now invalid condition where weight is greater than W
                else{
                    int ExcProfit=dp[i-1][j];
                    dp[i][j]=ExcProfit;
                }

            }
        }
        print(dp);
        // lastly return the value of last box which have the answer 
        return dp[n][W];
    } 
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int n=5;
        int W=7;
        int dp[][]=new int[n+1][W+1];
        //Arrays.fill(dp, -1);
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        //System.out.println(knapsack_mem(val, wt, n, W,dp));
        System.out.println(knapsack_tabulation(val, wt, n, W));
    } 
}