// MMMMM  and GGGGG
// using recursion
public class duplicate_string {
    public static void Remove_duplicate(StringBuilder sb,boolean map[],int index,String str){
        if(index==str.length()){
            System.out.print(sb);
            return;
        }
        char c=str.charAt(index);
        // this is 2nd occurence of that character
        if(map[c-'a']==true){
            Remove_duplicate(sb, map, index+1, str);
        }
        else{
            map[c-'a']=true;
            Remove_duplicate(sb.append(c), map, index+1, str);
        }
    }
    public static void main(String args[]){
        String s="hhhheeeelllllloooooo";
        Remove_duplicate(new StringBuilder(""),new boolean[26],0,s);
    }
}
