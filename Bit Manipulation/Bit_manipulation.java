// very important for the cp and interview
public class Bit_manipulation {
    // function to find the number is even or odd
    // return true if it is even else false

    // please refer notes for the explanation of the problem
    public static Boolean Odd_even(int n){
        int Bitmask=1;
        if((n&Bitmask)==1){
            return false;
        }
        else {
        return true;}
    } 

    // get the ith bit
    public static int GetBit(int n,int i){
        int Bitmask=1<<i;
        if((n&Bitmask)!=0)
            return 1;
        else{
            return 0;
        }
    }

    // set the ith bit
    public static int SetBit(int n,int i){
        int Bitmask=1<<i;
        int m=Bitmask | n;
        return m;
    }

    // clear ith bit
    public static int ClearBit(int n,int i){
        int Bitmask=~(1<<i);
        int m=n&Bitmask;
        return m;
    }

    // update ith bit with j th given bit
    public static int UpdateIth(int n,int i,int j){
        // first clear ith bit 
        int m=ClearBit(n, i);
        int Bitmask=j<<i;
        return m|Bitmask;
    }

    //clear last ith bits
    public static int ClearLast_i_bits(int n,int i){
        int Bitmask=~(0)<<i;
        int m=n&Bitmask;
        return m;
    }

    // clearing the range of bits from ith to jth bit\
    public static int ClearRange(int n,int i,int j){
        int a=~(0)<<(j);// see once again it is j or j+1
        int b=(1<<i)-1;
        // or we can use b=~(~(0)<<i);
        //int b=~(~(0)<<i);
        int Bitmask=a|b;
        return n&Bitmask;
    } 

    // check number if power of 2 or not
    public static void Power_Of_2(int n){
        int Bitmask=n-1;
        int res=n&(n-1);
        if(res==0){
            System.out.println("yes ");
        }
        else{
            System.out.println("no ");
        }
    }

    // count set bits in a number
    public static int CountSet(int n){
        int count=0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    // fast exponsiation a^b
    public static int Fast_power(int a,int b){
        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans=ans*a;
            }
            a=a*a;
            b=b>>1;
        }
        return ans;
    }

    public static void main(String args[]){
        //System.out.println(Odd_even(10));
        //System.out.println(GetBit(7,1));
        //System.out.println(SetBit(8,0));
        //System.out.println(ClearBit(8,3));
        //System.out.println(UpdateIth(8,3,1));
        //System.out.println(ClearLast_i_bits(15,3));
        //System.out.println(ClearRange(15,0,3));
        //Power_Of_2(256);
        //System.out.println(CountSet(15));
        //System.out.println(Fast_power(5,3));
    } 
}
