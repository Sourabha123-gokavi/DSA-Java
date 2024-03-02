public class Dll {
    public static class NODE{
        int data;
        NODE next;
        NODE prev;
        public NODE(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static NODE head;
    public static NODE tail;
    public static int size;
    
    
    
    public  void AddFirst(int data){
        //creating the new node
        NODE newnode=new NODE(data);
        if(head==null){
            head=newnode;
            return ;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        return ;


    }

    public void reverse(){
            // 3 pointers and 4 steps
            NODE prev=null;
            NODE curr=head;
            NODE next=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                curr.prev=next;
                prev=curr;
                curr=next;
            }
            head=prev;

}
    public void print(){
        NODE temp=head;
        while(temp!=null){
            System.out.print(temp.data +" <-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }    
    public static void main(String args[]){
        
        Dll dll=new Dll();
        head=null;
        dll.AddFirst(3);
        dll.AddFirst(2);
        dll.AddFirst(1);
        dll.print();
        dll.reverse();
        dll.print();

    }
    
}
