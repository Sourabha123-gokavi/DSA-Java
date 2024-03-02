import java.util.*;
public class LowestCommon_ancestor {
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
    public static boolean getpath(ArrayList<Node> path,int n,Node root){
        // base case is 
        if(root==null){
            return true;
        }
        
        // first add the root
        path.add(root);
        if(root.data==n){
            return true;
        }
        // check for the left part 
        boolean LeftFound=getpath(path, n, root.left);
        // check for the right part
        boolean RightFound=getpath(path, n, root.right);
        // if both are true the return true 
        if(LeftFound || RightFound){
            return true;
        }
        // else remove from the path since it is not part of the path
        path.remove(root);
        // return false
        return false;

    }
    public static Node lowest(Node root,int n1,int n2){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        getpath(path1,n1,root);
        getpath(path2,n2,root);
        int i=0;
        for(;i<path1.size() && i< path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;


    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println(lowest(root, 7, 4));

    }
}
