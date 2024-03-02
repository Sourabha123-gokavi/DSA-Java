// all basic of initializing the nodes and creating the nodes 

public class Palindrome {
    // creating the nodes 
    public static class NODE{
    int data;
    NODE next;
    public NODE(int data){
        this.data=data;
        this.next=null;
        }
    }
    // creating the head and tail node
    public static NODE head;
    public static NODE tail;
    public static int size;// defalut it is zero 

    // creting the methods to add,remove,


    // 1> add the node to the first
    // hear the class can be static or not static
    public void AddFirst(int data){
        // creting the node 
        NODE newnode=new NODE(data);
        size++;
        // base case -> when the linked list is empty
        if(head==null){
            head=tail=newnode;
            return ;
        }
        // now pointing the newnode to the head
        newnode.next=head;
        // updating the head
        head=newnode;
        return ;
    }

    // adding the node to last
    public void AddLast(int data){
        // creating the node
        NODE newnode=new NODE(data);
        size++;
        // base case->empty linked list
        if(head==null){
            head=tail=newnode;
            return;
        }
        
        // updating the node's head and tail
        tail.next=newnode;
        tail=newnode;
        return;
    
    }
    // print the linked list
    public void print(){
    NODE temp=head;
    while(temp!=null){
        System.out.print(temp.data+"->");
        temp=temp.next;
    }
        System.out.print("null");
    }

    // adding the node to the given index
    public void addIdx(int index,int data){
        // creating the node
        NODE newnode=new NODE(data);
        size++;
        NODE temp=head;
        // base case
        if(index==0){
            AddFirst(data);
            return;
        }
        int i=0;
        //going to the particular index
        while(i<index-1){
            // moving the temp to the next
            temp=temp.next;
            i++;
        }
        // once the index is obtained 
        newnode.next=temp.next;
        temp.next=newnode;
        return ;
    }
    public int RemoveFirst(){
        // zero case condition
        if(size==0){
            return Integer.MIN_VALUE;
        }
        int val=head.data;
        // single node condition
        if(size==1){
            head=tail=null;
            size=0;
            return val;
        }
        head=head.next;
        size--;
        return val;
    }

    // to remove the element from the last
    public int RemoveLast(){
        // if size is 0
        if(size==0){
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        // traverse the linked list and delete
        NODE prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    // Searching the key in the linked list
    public int itr_Search(int key){
        int i=0;
        NODE temp=head;
        while(temp!=null){
            // checking if key is found or not
            if(temp.data==key){
                return i;
            }
            i++;
            temp=temp.next;
        }
        // key not found case
        return -1;
    }

    // helper function for the recursive search
    public int helper(NODE head,int key){
        // base case
        if(head==null){
            return -1;
        }
        // main work
        // if found 
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next, key);
        if(index==-1){
            return -1;
        }
        return 1+index;

    }

    // recursive approach for the search
    public int recSearch(int key){
        return helper(head,key);
    }

    // reverse the linked list     TC -> O(n)
    
    public void reverse(){
        NODE prev=null;
        NODE curr=tail=head;
        NODE next;
        // condition 
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // updating the head;
        head=prev;
    }

    // remove the nth node form the last
    public static void delete_from_end(int n){
        // find size 
        int size=0;
        NODE prev=head;
        while(prev!=null){
            prev=prev.next;
            size++;
        }
        // checking if the node is head only
        if(size==n){
            head=head.next;
            return;
        }
        // size
        int i=1; 
        int idx=size-n;
        // traverse the linked list
        NODE temp=head;
        while(i<idx){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return ;
    }


    // program to check the palindrome of the linked list
    public static void Check_palindrome(){
        // it includes 3 steps
        // step 1 -> finding the mid
        NODE slow=head;
        NODE fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        

        // step 2 -> reverse the 2 nd half 



        // step 3 -> check the palindrome

    } 


    public static void main(String args[]){
        // creting the linked list
        Linkedlist ll=new Linkedlist();
        // ll.head=new NODE(3);
        // // adding the new node
        // ll.head.next=new NODE(4);
        // // adding the new node
        // ll.head.next.next=new NODE(5);
        ll.AddFirst(1);
        ll.AddFirst(0);
        ll.AddLast(2);
        ll.AddLast(3);
        ll.addIdx(2, 10);
        // ll.RemoveFirst();
        // ll.RemoveFirst();
        //ll.RemoveLast();
        //ll.print();
        //System.out.println(ll.itr_Search(10));
        //ll.reverse();
        //ll.print();
        //System.out.println(ll.recSearch(10));
        ll.delete_from_end(4);
        ll.print();






    }


    
}
