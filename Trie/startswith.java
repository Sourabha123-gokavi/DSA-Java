import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class startswith {
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

    public static boolean search(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            // check if it is null 
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String word[]={"apple","app","mango","man","woman"};
        String prefix="app";
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }
        System.out.println(search(prefix));
    } 
}
