import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.plaf.synth.Region;

public class merge_bst {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static void getinorder(ArrayList<Integer>arr,Node root){
        if(root==null){
            return ;
        }
        getinorder(arr, root.left);
        arr.add(root);
        getinorder(arr, root.right);
    }


    public static Node Build_BST(ArrayList<Integer> arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=Build_BST(arr, st, mid-1);
        root.right=Build_BST(arr, mid+1, end);
        return root;
    }

    public static Node Merge(Node root1,Node root2){
        
        // first find the inorder of the first bst
        ArrayList<Integer>arr1=new ArrayList<>();
        getinorder(arr1,root1);
        ArrayList<Integer>arr2=new ArrayList<>();
        getinorder(arr2,root2);

        // merge them
        ArrayList<Integer>finalArray=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalArray.add(arr1.get(i++));
            }
            else{
                finalArray.add(arr2.get(j++));
            }
        }
        // if any element left then
        while(i<arr1.size()){
            finalArray.add(arr1.get(i++));
        }
        while(j<arr1.size()){
            finalArray.add(arr1.get(j++));
        }

        // now start building the tree

        return  Build_BST(ArrayList<Integer>finalArray);

        
        
        
        
        
        
        return root;

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
