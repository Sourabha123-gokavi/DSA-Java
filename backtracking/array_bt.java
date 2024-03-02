public class array_bt{

    public static void changearr(int arr[],int idx,int val){
        // base case 
        if(idx==arr.length){
            print(arr);
            return;
        }


        // recursion 
        arr[idx]=val;
        changearr(arr, idx+1, val+1);
        arr[idx]=arr[idx]-2;// this is backtracking step
    
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }



    public static void main(String args[]){
        int arr[]=new int[5];
        changearr(arr,0,1);
        print(arr);
        
    }
}