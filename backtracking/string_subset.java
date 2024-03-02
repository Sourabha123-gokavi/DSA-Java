public class string_subset {
    public static void subset(String str,String empty,int i){
        // base case
        if(i==str.length()){
            if(empty.length()==0){
                System.out.println("null");

            }
            else{
                System.out.println(empty);
            }
            
            return ;
        }
        // recursion based on choices
        // yes choice
        subset(str, empty+str.charAt(i), i+1);
        // no condition
        subset(str,empty,i+1);
    }


    public static void main(String args[]){
        String str="abc";
        subset(str,"",0);
    }
    
}
