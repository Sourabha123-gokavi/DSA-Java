// it showing some thrash see it once again

public class PreorderSequence {
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
        

    }
    public static void main(String[] args) {
        int Nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(Nodes);
        System.out.println("the root node is "+root);
    }
    
}
