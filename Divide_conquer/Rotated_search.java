// similar to the binary search and this is very easy if u visulize this and draw the graph

public class Rotated_search{
    
    public static int search(int arr[],int si,int ei,int target){
        // base case 
        if(si>ei)
        return -1;
        
        
        int mid=si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }
        // online L1
        else if(arr[mid]>=arr[si]){
            // case a
            if(target>=arr[si] && arr[mid]>=target){
                // recurssive call 
                return search(arr, si, mid-1, target);
            }
            else{
                return search(arr, mid+1, ei, target);
            }
        }
        // online L2
        else{
            if(target>=arr[mid]  && target<=arr[ei]){
                return search(arr, mid+1, ei, target);
            }
            else{
                return search(arr, si, mid-1, target);
            }

        }
    }
    



    public static void main(String args[]){
        int arr[]={3,4,5,6,7,0,1,2};
        int arr1[]={1,0,1,1,1};
        int target=0;
        int index=search(arr1,0,arr1.length-1,target);
        System.out.print(index);
    }
}