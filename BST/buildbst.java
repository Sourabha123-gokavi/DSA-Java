import java.util.*;
public class mirror {
    
    
    
    
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    

    public static Node createBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }

        // calculate the mid
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }








    // 
    public static void GetInorder(Node root,ArrayList<Integer>inorder){
        if(root==nulll){
            return;
        }
        GetInorder(root.left, inorder);
        inorder.add(root.val);
        GetInorder(root.right, inorder);
    }
    public static Node Builld(ArrayList<Integer>arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=Builld(arr,st,mid-1);
        root.right=Builld(arr, mid+1, end);
        return root;
    }


    // build balanced bst from bst
    public static Node Build_balance(Node root){
        // first find the inorder sequence
        ArrayList<Integer>inorder=new ArrayList<>();

        //  build bst
        int st=0;
        int end=inorder.size()-1;
        root=Build_Tree(ArrayList<Integer>arr,st,end);
        return root;


    }









    public static void main(String[] args) {
        int value[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<value.length;i++){
            insert(null, value[i]);
        }
        //Path_root2leaf(root,new ArrayList<>());
    }
}
