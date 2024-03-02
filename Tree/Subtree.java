import java.util.*;
public class Subtree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isidentical(Node root,Node subroot){
        // here we are checking the not identical condition
        // 1> if both are null
        if(root==null && subroot==null){
            return true;
        }
        if(root==null || subroot==null || root.data!=subroot.data){
            return false;
        }
        // checking for the left part
        if(!isidentical(root.left, subroot.left)){
            return false;
        }
        if(!isidentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean Issubtree(Node root,Node subroot){
        // root condition
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            if(isidentical(root, subroot)){
                return true;
            }
        }
        return Issubtree(root.left, subroot) || Issubtree(root.right, subroot);

    }
    public static void main(String[] args) {
        // main tree
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        System.out.println(Issubtree(root,subroot));
        
    }
}
