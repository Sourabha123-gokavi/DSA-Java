import java.util.PriorityQueue;

public class ropes {
        public static void main(String []args){
            int ropes[]={4,2,3,6};
            PriorityQueue<Integer>pq=new PriorityQueue<>();
            for(int i=0;i<ropes.length;i++){
                pq.add(ropes[i]);
            }
            int cost=0;
            int curr;
            while(pq.size()>1){
                int min1=pq.remove();
                int min2=pq.remove();
                curr=min1+min2;
                cost+=curr;
                pq.add(curr);
            }
            System.out.println("The total cost is "+cost);
        }
}
