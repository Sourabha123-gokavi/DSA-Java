import java.util.*;
public class stack{
    
    //implmentation using arraylist
    static class StackA{
        static ArrayList <Integer> list=new ArrayList<>();
        public static boolean isempty(){
            return list.size()==0;
        }
        public static void push(int data){
            list.add(data);

        }
        public static int pop(){
            //corner codition
            if(list.size()==0){
                return -1;
            }

            int data=list.get(list.size()-1);
            list.remove(list.size()-1);
            return data;
        }
        public static int peek(){
            // corner condition
            return list.get(list.size()-1);
        }



    }

    // implementation using the linked list
    public static class NODE{
        int data;
        NODE next;
        public NODE(int data){
            this.data=data;
            this.next=null;
        }

    }
    public static class StackL{
        static NODE head=null;
        //operation 

        //push
        public static void push(int data){
            NODE newnode=new NODE(data);
            if(head==null){
                head=newnode;
                return ;
            }
            newnode.next=head;
            head=newnode;
            return;
        }
        //pop
        public static int pop(){
            if(head==null){
                return -1;
            }
            int data=head.data;
            head=head.next;
            return data;
        }
        //peek
        public static int peek(){
            if(head==null){
                return -1;
            }
            int data=head.data;
            return data;
        }
        //empty
        public static boolean isempty(){
            return head==null;
        }

    }




    public static void main(String args[]){
        StackL s=new StackL();
        s.push(1);
        s.push(2);
        s.push(3);
       
        while(!s.isempty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}