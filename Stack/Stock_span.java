import java.util.*;

public class Stock_span {
    public static void stockspan(int stock[],int span[]){
        Stack <Integer> s=new Stack<>();
        // always 1 st stock span is always 1
        span[0]=1;
        s.push(0);
        for(int i=1;i<stock.length;i++){
            int currPrice=stock[i];
            while(!s.isEmpty() && currPrice>stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                int PrevHigh=s.peek();
                span[i]=i-PrevHigh;
            }
            s.push(i);
        }

    }




    public static void main(String args[]){
        int stock[]={100,80,60,70,60,85,100};
        int span[]=new int[stock.length];
        stockspan(stock,span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i] +" ");
        }
    }
    
}
