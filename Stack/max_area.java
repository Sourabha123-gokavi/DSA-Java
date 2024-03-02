import java.util.*;
public class max_area{
    public static void max_area_histogram(int arr[]){
        int maxarea=0;
        int nsl=new int[arr.length];
        int nsr=new int[arr.length];
        // calculating the next smallest left
        Stack <Integer> s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=-1;
            }
            else{
                nsr[i]=s.peek();

            }
            s.push(i);

        }
        
        // calculating the next smallest right
        ss=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!ss.isEmpty()&& arr[ss.peek()]>=arr[i]){
                ss.pop();
            }
            if(ss.isEmpty()){
                nsl[i]=arr.length;
            }
            else{
                nsl[i]=ss.peek();
            }
            ss.push(i);
        }

        // caclulating the area
        // width= nsr[i]-nsl[i]-1;
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int area=height*width;
            maxarea=Math.max(maxarea,area );

        }
        System.out.println("max area is "+maxarea);
    }
    public static void main(String args[]){
        int arr[]={2,1,5,6,2,3};
        max_area_histogram(arr);



    }
}