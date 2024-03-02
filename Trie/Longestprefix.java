import java.util.*;
public class Longestprefix {
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

    static String ans1="";
    static String ans2="";

    // lexicographically smaller
    public static void Longestsmaller(Node root,StringBuilder temp){

        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans1.length()){
                    ans1=temp.toString();
                }
                Longestsmaller(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    // lexicographically larger
    public static void Longestlarger(Node root,StringBuilder temp){

        if(root==null){
            return;
        }
        for(int i=25;i>=0;i--){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch=(char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans2.length()){
                    ans2=temp.toString();
                }
                Longestlarger(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        String word[]={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }
        Longestlarger(root, new StringBuilder(""));
        Longestsmaller(root, new StringBuilder(""));
        System.out.println(ans1);
        System.out.println(ans2);
    }
}