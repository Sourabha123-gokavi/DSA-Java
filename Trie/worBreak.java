public class worBreak {
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

    public static boolean search(String key){
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

    // time complex is O(L) -> L is the length of the key
    public static boolean wordbreak(String key){
        // base case
        if(key.length()==0) return true; 
        // main work
        // important here is it should go for last index 
        // since last index is not included in the substring
        for(int i=1;i<=key.length();i++){
            // check if first substring is present
            // if true then recursive call for the 2nd half part of the substring
            if(search(key.substring(0, i))&&wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String words[]={"i","like","sam","samsung","mobile","ice"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        //System.out.println(searach(words[0]));
        //System.out.println(searach("sourabha"));
        System.out.println(wordbreak("ilikesamsung"));
    }
}
