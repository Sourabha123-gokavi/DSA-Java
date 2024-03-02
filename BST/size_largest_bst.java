import javax.swing.plaf.synth.Region;

public class size_largest_bst {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    public class Info{
        bool isBST;
        int size;
        int max;
        int min;
        public Info(bool isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }


    }

    static int maxBST=0;
    public static Info Largest_BST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo=Largest_BST(root.left);
        Info rightInfo=Largest_BST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.val,Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.val,Math.max(leftInfo.max, rightInfo.max));

        // check the condition
        if(root.val<=leftInfo.max || root.val>=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            // first update the maxBST
            maxBST=Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        // if anyone is not matched then return false
        return new Info(false, size, min, max);

    }

    public static void main(String[] args) {
        int value[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<value.length;i++){
            insert(null, value[i]);
        }
        //Path_root2leaf(root,new ArrayList<>());



        Info info=Largest_BST(root);
        System.out.println("The largest binary tree is "+maxBST);
    }
}
