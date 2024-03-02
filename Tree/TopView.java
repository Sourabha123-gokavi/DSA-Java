// code once again because the  code is showing some error

import java.util.*;
public class TopView {
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
    static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }


    // function to print the top view of the tree
    public static void Topview(Node root){
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,Node>map=new HashMap<>();
        int min=0;
        int max=0;
        // first add the root node with horizontal distance 0
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                // adding the information to the map for the first occurance
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                // now normal traversal for the left nodes
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                }
            }
        }
        for(int i=min;i<+max;i++){
            System.out.print(map.get(min));
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        Topview(root);

    }
}
