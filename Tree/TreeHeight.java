import java.util.*;
public class TreeHeight {
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
    public static int Height(Node root){
        if(root==null){
            return 0;
        }
        int left_h=Height(root.left);
        int right_h=Height(root.right);
        int Height=Math.max(left_h, right_h)+1;
        return Height;
    }

    // count the number of nodes
    public static int CountNode(Node root){
        // base case
        if(root==null){
            return 0;
        }
        int Rcount=CountNode(root.right);
        int Lcount=CountNode(root.left);
        return 1+Rcount+Lcount;
    }

    // sum of nodes
    public static int SumNodes(Node root){
        // base case
        if(root== null){
            return 0;
        }
        int Lsum=SumNodes(root.left);
        int Rsum=SumNodes(root.right);
        return (Lsum+Rsum+root.data);
    }

// finding the diameter of the tree Approach 1
    public static int Diameter2(Node root){
        if(root==null){
            return 0;
        }
        
        // calculating the Left diameter
        int Ldiam=Diameter2(root.left);
        int Lh=Height(root.left);
        // calculating the right diameter
        int Rdiam=Diameter2(root.right);
        int Rh=Height(root.right);
        // calculating the self diameter
        int SelfDiam=1+Lh+Rh;
        // returning the max among the 3 diameter
        return Math.max(SelfDiam ,Math.max(Rdiam, Ldiam));
    }


    // finding the diameter of the tree  in linear time complexity
    static class Info{
        int diam;
        int height;
        public Info(int diam,int height){
            this.diam=diam;
            this.height=height;
        }

    }
    public static Info Diameter(Node root){
        if(root==null){
            return new Info(0, 0);
        }
        // first calling the function for left tree
        Info lInfo=Diameter(root.left);
        Info rInfo=Diameter(root.right);

        // calculating the diameter
        int Diam=Math.max(Math.max(lInfo.diam, rInfo.diam),(lInfo.height+rInfo.height+1));
        int ht=Math.max(lInfo.height, rInfo.height)+1;
        // returning the bundle of information
        return new Info(Diam, ht);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        //System.out.println("The height of the teee is -> "+Height(root));
        //System.out.println("The total number of nodes are ->"+CountNode(root));
        //System.out.println("The sum of nodes in this tree is->"+SumNodes(root));
        //System.out.println("The Diameter of the tree using the approach 1 is->"+Diameter2(root));
        System.out.println("The diameter and height of the tree using the approach 2 is->"+Diameter(root).diam+" "+Diameter(root).height);
    }
}
