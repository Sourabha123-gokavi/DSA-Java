// ggggsssss
public class friends_pairing{
    public static int total_ways(int n){
        // base case
        if(n==1 || n==2){
            return n;
        }
        
        
        // single ways
        int singles=total_ways(n-1);
        // pairs  ways
        int pairs=total_ways(n-2);
        int total_paris=(n-1)*pairs;
        
        return singles+total_paris;
    }
    public static void main(String args[]){
        int n=3;
        System.out.print(total_ways(n));
    }
}