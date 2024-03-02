public class permutation {

    public static void permut(String str,String ans){
        // base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        // recursion case
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            // delete the char
            String newstr=str.substring(0, i)+str.substring(i+1);
            
            permut(newstr, ans+c);
        }
    }
    public static void main(String args[]){
        permut("abc","");

    }
    
}
