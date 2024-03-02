// time complexity is O(2^(m+n))
// worst linear time complexity

public class gridways{
    public static int  gridways(int n,int m,int i,int j){
        // base case
        // if source if on the destination
        if(i==n-1 && j==m-1){
            return 1;
        }
        // to check source is out of bound case -> out of grid
        else if(i==n || j==m){
            return 0;
        }
        // main work
        int w1=gridways(n,m,i,j+1);     // going to right 
        int w2=gridways(n,m,i+1,j);     // going to left
        return w1+w2;

    }

    // optimized code
    public static int fib(int n){
        // base case
        if(n==0){
            return 1;
        }
        // main work
        int fib=n*fib(n-1);
        return fib;
    }

    // finding the grid in linear time
    public static int gridways_optimized(int n,int m,int i,int j){
    // use the permutation formula for placing m-1 and n-1 identical persons on chair in grid
    // formula= (m-1 + n-1)!/(m-1)!(n-1)!
    
    int a=fib(n-1+m-1);
    int b=fib(n-1);
    int c=fib(m-1);
    int ans=a/(b*c);
    return ans;
    
    
    
    
    }



    public static void main(String args[]){
        int totalrow=3;
        int totalcol=3;
        int Startrow=0;
        int Startcol=0;
        //System.out.println(gridways(totalrow,totalcol,Startrow,Startcol));
        System.out.println(gridways_optimized(totalrow,totalcol,Startrow,Startcol));

    }
}