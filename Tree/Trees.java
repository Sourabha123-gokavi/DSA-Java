// it showing some thrash see it once again
import java.util.*;
public class Trees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node BuildTree(int Nodes[]){
            idx++;
            if(Nodes[idx]==-1){
                return null;
            }
            // creating the new node
            Node newnode=new Node(Nodes[idx]);
            // building the left subtree
            newnode.left=BuildTree(Nodes);
            // building the right subtree
            newnode.right=BuildTree(Nodes);
            return newnode;
        }
        public static void preroder(Node root){
            if(root==null){
                return;
            }
            System.out.println(root.data);
            preroder(root.left);
            preroder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return ;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
        public static void inorder(Node root){
            if(root==null){
                return ;
            }
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
        // important
        public static void leverorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                // checking if the node is null to print the nextline 
                if(currNode==null){
                    System.out.println();
                    // checking the empty condition
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                // checking the othere condition to print
                else{
                    System.out.print(currNode.data+" ");
                    // if left is not null then add left node
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    // if right is not null then add right node
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }

                }
            }

        }
        

    }
    public static void main(String[] args) {
        int Nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(Nodes);
        //System.out.println("the root node is "+root);
        //tree.preroder(root);
        //tree.postorder(root);
        //tree.inorder(root);
        tree.leverorder(root);
    }
    
}
