public class UniqueSubstring {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    static Node root=new Node();
    public static void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=count(root.children[i]);
            }
        }
        return count+1;
    }
    
    
    public static void main(String[] args) {
    String str1="ababa";
    String str2="apple";
    for(int i=0;i<str2.length();i++){
        String suffix=str2.substring(i);
        insert(suffix);
    }
    int ans= count(root);
    //System.out.println("The total substring for "+str1+" ="+ans);
    System.out.println("The total substring for "+str2+" ="+ans);

        
    }
    
}
