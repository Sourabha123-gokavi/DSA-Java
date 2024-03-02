import java.util.*;


public class Next_greatest_no {
    public static void print(int nextgreater[]){
        for(int i=0;i<nextgreater.length;i++){
            System.out.print(nextgreater[i]+" ");
        }
        return ;
    }


    public static void nextgreatestno(int arr[]){
        int nextgreater[]=new int[arr.length];
        Stack <Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            // stack
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            } 
            //if else
            if(s.isEmpty()){
                nextgreater[i]=-1;
            }
            else{
                nextgreater[i]=arr[s.peek()];
            }
            // push
            s.push(i);
        }
       print(nextgreater);

    }
    public static void main(String args[]){
        int arr[]={9,7,5,3,1};
        nextgreatestno(arr);

    }
}
