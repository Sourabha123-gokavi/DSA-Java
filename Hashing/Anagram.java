import java.io.PushbackInputStream;
import java.io.ObjectInputFilter.Status;
import java.util.HashMap;
import java.util.TreeMap;

public class Anagram {
    
    public static boolean IsAnagram(String s,String t){
        HashMap<Character,Integer>map=new HashMap<>();
        
        // first we are storing the character of the string s in the map
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        // now we are tracking the strin t using the loop in the map

        for(int i=0;i<t.length();i++){
            // start removing the character from the map
            char ch=t.charAt(i);
            if(map.containsKey(ch)){
                // if the frequency is 1 then remove that from the map 
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }

        // lastly check if the map is empty or not
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s1="race";
        String t1="care"; 
        System.out.println("1) The given two string are anagram or not ?\n Ans:"+IsAnagram(s1, t1));
        String s2="lipid";
        String t2="tulip";
        System.out.println("2) The given two string are anagram or not ?\n Ans:"+IsAnagram(s2, t2));
        
    
    }    
}
