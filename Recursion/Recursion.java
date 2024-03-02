public class Recursion {
    public static void Recursion_fromn(int n){
        if(n==0)
        return;
        else{
            System.out.print(n) ;
            System.out.print(" ");
            Recursion_fromn(n-1);
        }
    }

    public static double factorial(int n){
        if(n==0){
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }

    public static void Increasing(int n){
        if(n==1){
            System.out.print(n+" ");
            return ;
        }
        else{
            Increasing(n-1);
            System.out.print(n+ " ");

        }
    }
    public static int SUM(int n){
        if(n==1){
            return 1;
        }
        else{
            return n+SUM(n-1);
        }
    }
    public static long fib(int n){
        if(n==1 || n==0){
            return n;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static int power(int base,int power){
        if(power==0){
            return 1;
        }
        return base*power( base,power-1);

    }
    // reducing the time complexity from n  -> to log(n)
    public static int opt_power(int base,int power){
        // base condition
        if(power==0){
            return 1;
        }
        int value=opt_power(base, power/2);
        
        int value_sq=value*value;// this makes log(n) time complexity
        // checking power is odd or not
        
        if(power%2!=0){
            value_sq=base*value_sq;
        }
        return value_sq;
    }
    public static void main(String args[]){
        int n=30;
        //Recursion_fromn(n);
        //out.print((int)factorial(n));
        //Increasing(n);
        //System.out.println(SUM(n));
        //System.out.println(fib(n));
        //System.out.println(power(2,3));
        //System.out.println(opt_power(2,3));
    }
}
