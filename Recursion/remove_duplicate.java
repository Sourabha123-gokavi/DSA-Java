// normal approach using for loop and map
public class remove_duplicate {
    public static String give(String s){
        StringBuilder str=new StringBuilder();
        int arr[]=new int[26];
        for(int i=0;i<arr.length;i++){
        arr[i]=0;
        }
        for(int i=0;i<s.length();i++){
        if(arr[s.charAt(i)-'a']==0){
            str.append(s.charAt(i));
            arr[s.charAt(i)-'a']=1;
        }
        }
        
        return str.toString();
    }
    public static void main(String args[]){

        System.out.print(give("heeelllooo"));   
        }
}
