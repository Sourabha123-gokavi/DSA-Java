public class first_occurance {
    public static int first_occ(int arr[],int index,int key){
        if(index>arr.length-1)
        return -1;
        if(arr[index]==key){
            return index;
        }
        else {
            return first_occ(arr, index+1, key);
        }
    }

    // see last occurance once because its is not clear
    // public static int last_occ(int arr[],int index,int key){
    //     if(index==arr.length-1)return -1 ;
    //     int found= last_occ(arr, index+1, key);
    //     if(found!=-1)
    //     return found;

    //     if(found==-1 && arr[found]==key ){
    //         return index;
    //     }
    //     return found;
      

        
    // }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,1,2,3,34,5,6,7,8};
       // System.out.print(first_occ(arr, 0, 3));
        System.out.print(last_occ(arr, 0, 3));
    }
}
