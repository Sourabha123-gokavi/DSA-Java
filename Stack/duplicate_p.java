import java.util.*;;
public class duplicate_p {

    public static boolean isValid(String str){
        Stack <Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            //closing condition
            char ch=str.charAt(i);
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                else{
                    s.pop();
                }
            }

            //opening condition
            else{
                s.push(ch);
            }
        }
    return false;
    }
    public static void main(String args[]){
        String str="((a+b))";// true
        String str1="(a+b)+(c+d)";
        System.out.println(isValid(str1));
    }
}
