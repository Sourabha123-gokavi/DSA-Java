import java.util.*;
public class bst {
    
    
    
    
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }
        if(root.val>data){
            root.left=insert(root.left, data);
        }
        else{
            root.right=insert(root.right, data);
        }

    }

    // searching in bst
    public static boolean Search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.val==key){
            return true;
        }
        else if(root.val>key){
            return Search(root.left, key);
        }
        else{
            return Search(root.right, key);
        }
    }
    //


    // Delete Node
    public static Node DeleteNode(Node root,int val){
        // first find the value
        if(root.val<val){
            root.right=DeleteNode(root.right, val);
        }
        else if(root.val>val){
            root.left=DeleteNode(root.left, val);
        }
        // here it is the case where we found the element

        else{
            // case 1
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }

            // case 3
            Node IS=findInorderSuccessor(root.right);
            root.val=IS.val;
            // inorder succ
            root.right=DeleteNode(root.right, IS.val);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    // print the path from root to leaf
    public static void Path_root2leaf(Node root,ArrayList<Integer> path){
        // base case when node becomes null return
        if(root==null){
            return ;
        }
        path.add(root.val);
        //print and return
        if(root.left==null && root.right==null){
            printPath(path);
            return ;
        }



        Path_root2leaf(root.left, path);
        Path_root2leaf(root.right, path);
        // this is backtrack step
        path.remove(path.size()-1);
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }




    // print in range
    public static void Print_in_range(Node root,int k1,int k2){
        if(root==null){
            return ;
        }
        if(root.val>=k1 && root.val<=k2){
            Print_in_range(root.left, k1, k2);
            System.out.print(root.val+" ");
            Print_in_range(root.right, k1, k2);
        }
        else if(root.val<k1){
            Print_in_range(root.left, k1, k2);
        }
        else{
            Print_in_range(root.right, k1, k2);
        }

    }
    public static void main(String[] args) {
        int value[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<value.length;i++){
            insert(null, value[i]);
        }
        Path_root2leaf(root,new ArrayList<>());
    }
}
