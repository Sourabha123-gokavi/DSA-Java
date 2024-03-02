import javax.management.Query;

public class start {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        Queue(int n){
            arr=new int[n];
            size=n;
        }
        //isEmpty
        public static boolean isEmpty(){
            return rear==-1;
        }
        // add
        public static void add(int data){
            if(rear==size-1){
                System.out.println("full");
                return;
            }
            rear=rear+1;
            arr[rear]=data;
            return;
        }
        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("empty");
                return-1;
            }
            int front=arr[0];
            
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear=rear-1;
            return front;

        }
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty");
                return-1;
            }
            return arr[0];
            
        }
        


    } 
    public static void main(String args[]){
        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        //q.add(4);
        q.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }




}
