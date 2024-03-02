import java.util.*;
public class max_min{
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }

    public static void buildST(int arr[],int si,int sj,int i){
            // base case
            if(si==sj){
                tree[i]=arr[si];
                return ;
            }
            int mid=(si+sj)/2;
            buildST(arr, si, mid,2*i+1);
            buildST(arr, mid+1,sj,2*i+2);
            tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    public static int getmaxUtil(int i,int si,int sj,int qi,int qj){
        // non overlap condition
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE;
        }
        // complete overlap
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        else{
            int mid=(si+sj)/2;
            int leftAns=getmaxUtil(2*i+1, si, mid, qi, qj);
            int rightAns=getmaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }



    ///////////////////////////
    // update the given value in the index
    public static void updateUtil(int i,int si,int sj,int idx,int newVal){
        // base condition 
        if(idx<si || idx>sj){
            return ;
        }
        if(si==sj)// only leaf node condition 
        {
            tree[i]=newVal;
        }
        // non leaf nodes condition'
        if(si!=sj){
            tree[i]=Math.max(tree[i], newVal);// this is only if it is in range
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);// call for the left part
            updateUtil(2*i+2, mid+1, sj, idx, newVal); //call for the right part
        }

        
    }
    
    
    
    
    public static void update(int arr[],int idx,int newVal){
        int n=arr.length;
        arr[idx]=newVal;
        updateUtil(0, 0, n-1, idx, newVal);

    }
    public static int getmax(int arr[],int qi,int qj){
        int n=arr.length;
        return getmaxUtil(0,0,n-1,qi,qj);
    }
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        buildST(arr, 0, n-1, 0);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        int max=getmax(arr, 2,5);
        System.out.println(max);
        update(arr, 2, 20);
        max=getmax(arr, 2,5);
        System.out.println(max);

    }
}