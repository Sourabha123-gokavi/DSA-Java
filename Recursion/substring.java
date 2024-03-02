public class substring{
    // total numbers of substring starting and ending with same character
    public static int  substring_(String str,int start,int end,int length){
        if(length<=0){
            return 0;
        }
        if(length==1){
            return 1;
        }
        int res=substring_(str, start+1, end, length-1)+substring_(str, start, end-1, length-1)-substring_(str, start+1, end-1, length-2);
        if(str.charAt(start)==str.charAt(end)){
            res++;
        }
        return res;
    }
    public static void main(String args[]){
        String str="abcab";
        int n=str.length();
        System.out.println(substring_(str ,0, n-1, n));

    }
}