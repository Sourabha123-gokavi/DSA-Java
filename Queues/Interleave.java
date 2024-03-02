import java.util.*;
public class Interleave {
    public static void Interleave_func(Queue<Integer>q){
        int s=q.size();
            Queue <Integer> First_half=new LinkedList<>();
            // remove the first half element from the main queue and add to the first half queue
            for(int i=0;i<s/2;i++){
                First_half.add(q.remove());
            }
            while(!First_half.isEmpty()){
                q.add(First_half.remove());
                q.add(q.remove());
            }

    }
    public static void main(String[] args) {
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        Interleave_func(q);
        // print the queue
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }

    }
}
