import java.util.*;

public class QueueB {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        } 
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;
        // is empty condition
        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        // add 
        public static void Add(int data){
            Node newnode=new Node(data);
            // empty condition
             if(head==null){
                head=tail=newnode;
                return ;
             }
             tail.next=newnode;
             tail=tail.next;
             return;

        }

        // remove 
        public static int Remove(){
            // single node  condition
             if(isEmpty()){
                return -1;
            }
            int info=head.data;
            if(head==tail){
                head=tail=null;
                return info;
            }
            else{
                head=head.next;
                return info;
            }
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue a=new Queue();
        a.Add(1);
        a.Add(2);
        a.Add(3);
        while(a.peek()!=-1){
            System.out.println(a.peek());
            a.Remove();
        }
    }
    
}
