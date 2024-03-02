import java.util.*;
public class DSU {
    static int n=7;
    static int parent[]=new int[n];
    static int rank[]=new int[n];
    public static void init(){
        //in itially parent of every element is itself only
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    // find function
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        // this process of updating the parent is called as the --> path compression 
        return parent[x]=find(parent[x]);
    }
    
    // union function
    public static void union(int a,int b){
        // first find the parent of both 
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            parent[parA]=parB;
        }
        else{
            parent[parB]=parA;
        }
    }
    public static void main(String[] args) {
        init();
        union(1,3);
        System.out.println(find(3));
        union(2, 4);
        System.out.println(find(4));
        union(3, 6);
        System.out.println(find(6));
        union(1, 4);
        System.out.println(find(4));
    }
}
