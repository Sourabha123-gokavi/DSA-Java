import java.util.*;


public class construction{
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int buildST(int arr[],int i,int start,int end){
        // base case
        // here we are going to assign the value 
        if(start==end){
            tree[i]=arr[start];
            return tree[i];
        }
        
        
        int mid=(start+end)/2;
        // there is no need to store because it is declared
        buildST(arr, 2*i+1, start, mid);// call for the left part
        buildST(arr, 2*i+2, mid+1, end);// call for the right part
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }

    // sovlving queries
    // helper function for the getsum
    public static int getsumUtil(int i,int si,int sj,int qi,int qj){
        // case 1 if it completely out
        if(sj<=qi || qj<=si){
            return 0;
        }
        // completely overlap
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        // partial overlap
        else{
            int mid=(si+sj)/2;
            int left=getsumUtil(2*i+1, si, mid, qi, qj);
            int right=getsumUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }

    public static int getsum(int arr[],int qi,int qj){
        int n=arr.length;
        return getsumUtil(0,0,n-1, qi, qj);
    }

    // updating the segment tree

    // helper function 
    public static void updateUtil(int i,int si,int sj,int idx,int diff){
        if(idx<si || idx>sj){// leaf nodes
            return ;
        }
        tree[i]+=diff;
        if(sj!=sj){// non lead nodes
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid,  idx,diff);// call for the left part
            updateUtil(2&i+2, mid+1, sj,idx,diff);// call for the right part
        }



    }
    public static void update(int arr[],int idx,int newVal){
        int n=arr.length;
        int diff=newVal-arr[idx];
        arr[idx]=newVal;
        updateUtil(0,0,n-1,idx,diff);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);
       
        update(arr, 2, 2);
        int sum=getsum(arr, 2, 5);
        System.out.println(sum);
        System.out.println(tree[0]);

    }
}