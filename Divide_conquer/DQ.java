import java.util.*;
public class DQ {
    
    
    
    public static void mergesort(int arr[],int si,int ei){
        // base case 
        int mid=si+(ei-si)/2;
        if(si>=ei){
            return ;
        }
        // divide the given array
        mergesort(arr, si, mid);// for left part
        mergesort(arr,mid+1,ei); // for the right part
        merge(arr,si,ei,mid);
    }
    public static void merge(int arr[],int si,int ei,int mid){
        int i=si;// iterator for the left part
        int j=mid+1;// iterator for the right part 
        int k=0;// iterator for the temp array
        int temp[]=new int[ei-si+1];// temp array for holding the temp part
        while(i<=mid && j<=ei){/// for the compraing 
            if(arr[i]>arr[j]){
                temp[k]=arr[j];
                j++;
                k++;
            }
            else{
                temp[k]=arr[i];
                i++;
                k++;
            }
        }
        // 
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //coping the temp into main array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }  



    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // quick sort 


    public static void quicksort(int arr[],int si,int ei){
        // base case
        if(si>=ei)return ; 
        int pIdx=partition(arr,si,ei);
        quicksort(arr, si,pIdx-1);
        quicksort(arr, pIdx+1, ei);
    }
    public static int partition(int arr[],int si,int ei){
        
        int i=si-1; 
        int pivot=arr[ei];
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                // swap
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void main(String args[]){
        int arr[]={5,4,3,2,1,9};
        //mergesort(arr,0,arr.length-1);
        quicksort(arr, 0,arr.length-1);
        print(arr);
    }
}


