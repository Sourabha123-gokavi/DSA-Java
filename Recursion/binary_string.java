// pt

public class binary_string {
    public static void Binary_String(String str,int n,int last){

        // base case
        if(n==0){
            System.out.println(str);
            return ;
        }
        // work 
        if(last==0){
            Binary_String(str+"0", n-1, 0);
            Binary_String(str+"1", n-1, 1);
        }
        else{
            Binary_String(str+"0", n-1, 0);
        }
    }
    public static void main(String args[]){
        Binary_String("",4,0);
    }
}
