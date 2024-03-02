import java.util.*;
public class first_non_repeating {
    public static void print_Firstnon_repeating(String str){
        // creating the map/ frequency array
        int freq[]=new int[26];
        //Creating the new queue
        Queue <Character> q=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
            
        }   
        System.out.println(); 
        

    }
    public static void main(String[] args) {
        String s="aabccxb";
        print_Firstnon_repeating(s);

    }    
}
