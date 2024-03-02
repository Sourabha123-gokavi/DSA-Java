// implement queue using 2 stacks

import java.lang.Thread.State;
import java.util.*;
import java.util.concurrent.Flow.Publisher;
public class q1 {
    static class Queue{
        static Stack<Integer>s1=new Stack<>();
        static Stack<Integer>s2=new Stack<>();
        //is empty
        public static boolean isEmpty(){
            return s1.empty();
        }
        // add
        public static void add(int data){
            // pop all from the s1 and add to s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        // remove
        public static void remove(){
            if(s1.isEmpty()){
                System.out.println("-1");
                return ;
            }
            s1.pop();
        }

        public static int peek(){
            if(s1.isEmpty()){
                System.out.println("-1");
                return -1;
            }
            return s1.peek();

        }
    }
    public static void main(String args[]){
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
