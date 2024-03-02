public class sorted_recursion {
    public static boolean checksort(int arr[],int i){
        // i is the starting point of the array from where we want to start
        if(i==arr.length-1)
        {
            return true;
        }
        if(arr[i]>arr[i+1])
        {
            return false;
        }
        return checksort(arr,i+1);
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8,9};
        System.out.print(checksort(arr,0));
        
    }
}
