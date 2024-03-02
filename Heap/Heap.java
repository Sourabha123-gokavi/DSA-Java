import java.util.ArrayList;

public class Heap {
    public static class MinHeap{
        // create arraylist
        ArrayList<Integer>heap=new ArrayList<>();
        
        // insert function
        public void insert(int key){
            // add the element at the last
            heap.add(key);
            
            //heapify
            int x=heap.size()-1;
            int par=(x-1)/2;

            while(heap.get(x)<heap.get(par)){
                //swap
                int temp=heap.get(x);
                heap.set(x, heap.get(par));
                heap.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }

        // peek
        public int peek(){
            return heap.get(0);
        }

        // heapify
        public void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;

            // just changing the sign will make it max heap
            if(left<heap.size() && heap.get(minIdx)>heap.get(left)){
                minIdx=left;
            }
            if(right<heap.size() && heap.get(minIdx)>heap.get(right)){
                minIdx=right;
            }

            // now swap
            if(minIdx!=i){
                int temp=heap.get(i);
                heap.set(i,heap.get(minIdx));
                heap.set(minIdx,temp);
                // if below heap is distorted 
                // then call heapify for the bolow heap
                heapify(minIdx);
            }
        }

        public int remove(){
            int data=heap.get(0);

            //swap first and last
            int temp=heap.get(heap.size()-1);
            heap.set(0, heap.get(heap.size()-1));
            heap.set(heap.size()-1, temp);

            // remove the element
            heap.remove(heap.size()-1);

            // step -3 
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return heap.size()==0;
        }



    }
    public static void main(String []args){
        MinHeap h=new MinHeap();
        h.insert(1);
        h.insert(3);
        h.insert(2);
        h.insert(6);
        h.insert(5);
        h.insert(4);

        while(!h.isEmpty()){
            System.out.print(h.peek()+" ");
            h.remove();
        }

    }
}
