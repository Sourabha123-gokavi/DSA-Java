// main work of the dp is reducing the time complexity of the recursion problem

public class Dynamic_programming{

    // now this program run in linear time complexity
    public static int fib(int n,int f[]){
        // base case condition
        if(n==0 || n==1){
            return n;
        }
        // main work
        
        // 1 check if the fig of n already calculated
        if(f[n]!=0){
            return f[n];
        }
        // 2> if not stored the store it 
        f[n]=fib(n-1,f)+fib(n-2,f);
        return f[n];

    }
    // fib using the tabulation
    // public static int fib_tab(int n){
    //     int dp[]=new int[n+1];
    //     dp[0]=dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    public static void main(String args[]){
        int n=5;
        int f[]=new int[n+1];
        System.out.println(fib(n,f));
        //System.out.println(fib_tab(n));


    }
}