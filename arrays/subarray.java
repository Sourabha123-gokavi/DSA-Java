import javax.print.event.PrintJobListener;

public class subarray{
    public static void printSubarray(int arr[]){
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            start=i;
            for(int j=i+1;j<arr.length;j++){
                end=j;
                for(int k=start;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    } 
    
    
    public static void main(String args[]){
        int arr[]={1,2,3,4,5};
        printSubarray(arr);

    }
}