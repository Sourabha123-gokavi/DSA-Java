public class Trie {
    
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root=new Node();
    // 
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            // check if the index is null or not 
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                // then add it 
                curr.children[idx]=new Node();
            }
            // updation 
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean searach(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            // check if the index is null or not 
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null){
                // then add it 
                return false;
            }
            // updation 
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }


    public static void main(String[] args) {
        String words[]={"the","a","there","any","thee","their"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(searach(words[0]));
        System.out.println(searach("sourabha"));
    }
}
