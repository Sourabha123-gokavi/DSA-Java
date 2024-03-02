import java.util.Stack;
public class Stack_main {
    //push at bottom (Ama)  using recursion
    public static void PushAtbottom(Stack<Integer> s,int data){
        // base condition
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        //main work
        int top=s.pop();
        PushAtbottom(s, data);
        s.push(top);
    }

    // reverse the string 
    public static String reverseString(String str){
        Stack <Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            char curr=str.charAt(idx);
            s.push(curr);
            idx++;
        }
        StringBuilder res=new StringBuilder("");
        while(!s.isEmpty()){
            char c=s.pop();
            res.append(c);
        }
        return res.toString();

    }

    // reverse the stack without using the space 
    public static void reversestack(Stack<Integer> s){
        // base work 
        if(s.isEmpty()){
            return ;
        }
        // main work
        int top=s.pop();
        reversestack(s);
        PushAtbottom(s, top);
    }



    public static void main(String args[]){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //PushAtbottom(stack, 10);
        System.out.println(stack);
        
        
        // String str="Sourabha";
        // String res=reverseString(str);
        // System.out.println(res);

        reversestack(stack);
        System.out.println(stack);


    }
}
