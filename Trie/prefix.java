import javax.swing.text.AsyncBoxView.ChildLocator;

public class prefix {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq=1;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    static Node root=new Node();


    // insert function
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            // check if it is null
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
            
        }
        curr.eow=true;
    }

    public static void prefix_find(Node root,String ans){
        // base conditions
        if(root==null){
            return ;
        }
        if(root.freq==1){
            System.out.println(ans);
            return ;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                prefix_find(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    
    
    
    public static void main(String[] args) {
        String arr[]={"zebra","dog","duck","dove"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        root.freq=-1;
        prefix_find(root,"");
    }
    
}
