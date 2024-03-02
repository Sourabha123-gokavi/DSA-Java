public class valid_bst {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }

    // 
    public static boolean isValid(Node root,Node max,Node min){
        // chaeck 
        if(root== null){
            return true;
        }

        // check false condition
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isValid(root.left, min, root) &&
                isValid(root.right, root, max);
    }
    public static void main(String []args){



        if(isValid(root, null, null)){
            System.out.println("Valid");
        }
        else{
            System.out.println("Not valid");
        }
    }
}
