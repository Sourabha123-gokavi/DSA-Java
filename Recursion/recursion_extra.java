public class recursion_extra {
    // find the position of key occurance
    public static void Search_occurance(int arr[],int key,int n){
        if(n==arr.length){
            return ;
        }
        if(arr[n]==key){
            System.out.print(n+" ");
        }
        
        Search_occurance(arr, key, n+1);
    }

    // converting number into string ->2019 =>into two zero one nine
    // public static StringBuilder convert(StringBuilder sb,String str, int n){
    //     if(n==str.length()){
    //         return sb;
    //     }
    //     else{
    //         if(str.charAt(n)=='0'){
    //             return convert( sb.append("zero "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='1'){
    //             return convert( sb.append("one "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='2'){
    //             return convert( sb.append("Two "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='3'){
    //             return convert( sb.append("Three "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='4'){
    //             return convert( sb.append("Four "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='5'){
    //             return convert( sb.append("Five "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='6'){
    //             return convert( sb.append("Six "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='7'){
    //             return convert( sb.append("seven "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='8'){
    //             return convert( sb.append("eight "), str,  n+1);
    //         }
    //         else if(str.charAt(n)=='9'){
    //             return convert( sb.append("nine "), str,  n+1);
    //         }

    //     }
    // }
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void convert(int n){
        
        if(n==0){
            return ;
        }
        
        else{
            int remainder=n%10;
            convert(n/10);
            System.out.print(digits[remainder]+" ");

            
        }
    }

    // finding the lenght of the string using recurssion
    public static int find_length(StringBuilder sb,String str,int count){
        
        if(str.compareTo(sb.toString())==0){
            return count;
        }
        else{
            //har c=str.charAt(count)
            
            return find_length(sb.append(str.charAt(count)), str,++count );
        }
        
        
        
        
        
    }


    public static void main(String args[]){
        // int arr[]={3,2,4,5,6,2,7,2,2};
        // int key=2;
        // Search_occurance(arr,key,0);
        //System.out.println(convert(sb,str,0));
        //convert(2019);
        StringBuilder sb=new StringBuilder();
        String str="hello";
        System.out.print(find_length(sb, str, 0));
    }
}
