import java.util.PriorityQueue;

public class sliding {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair (int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            // sort in descending order
            return p2.val-this.val;
        }
        
    }
    public static void main(String []args){
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        
        // include 1st window
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }

        // include the first answer
        res[0]=pq.peek().val;

        // start iterating 
        for(int i=k;i<arr.length;i++){
            // condition is imp
            // remove the element until idx of peek element
            // is less than (i-k)
            while(pq.size()>0 && pq.peek().idx<=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(arr[i],i));
            res[i-k+1]=pq.peek().val;
        }
    
        for(int i=0;i<arr.length;i++){
            System.err.print(res[i]+" ");
        }
    }
    
}
