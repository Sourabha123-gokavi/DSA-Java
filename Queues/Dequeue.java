import java.util.*;

import javax.swing.text.html.StyleSheet;
public class Dequeue {
    static class Stack{
        static Deque<Integer> deque=new LinkedList<>();
        public static void push(int data){
            deque.addLast(data);
        }
        public static void pop(){
            deque.removeLast();
        }
        public static int peek(){
            return deque.getLast();
        }
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
    }
    static class Queue{
        static Deque<Integer> deque=new LinkedList<>();
        public static void add(int data){
            deque.addFirst(data);
        }
        public static void remove(){
            deque.removeLast();
        }
        public static int peek(){
            return deque.getLast();
        }
        public static boolean isEmpty(){
            return deque.isEmpty();
        }

    }
    public static void main(String[] args) {
        Stack s=new Stack();
        Queue q=new Queue();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek()+" ");
            s.pop();
        }
        q.add(5);
        q.add(6);
        q.add(7);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }



        Deque<Integer> dq=new LinkedList<>();
        // functions of deque
        dq.add(1);
        dq.addFirst(2);// both are same
        dq.addLast(3);// add the integer to the last 
        dq.remove();
        dq.removeLast();
        dq.removeFirst();
        dq.getFirst();// peek the first element
        dq.getLast();// peek the last element
        

        
        
    }
}
