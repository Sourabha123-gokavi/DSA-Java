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
    



    public static Node Mirror(Node root){
        if(root==null){
            return null;
        }
        
        Node LeftMirror=Mirror(root.left);
        Node RightMirror=Mirror(root.right);
        root.left=LeftMirror;
        root.right=RightMirror;
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
