import java.util.*;
public class krushkals {
    static int n=4;
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

    // creation of graph
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int c){
            this.src=s;
            this.dest=d;
            this.wt=c;
        }
        @Override 
        public int compareTo(Edge e2){
            return this.wt-e2.wt;// ascending order
        }
    }

    public static void createGraph(ArrayList<Edge>edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,1,40));
        edges.add(new Edge(2,3,50));
    }

    // krushkals algorithm
    public static void Krushkals_MST(ArrayList<Edge>edges,int V){
        init();
        Collections.sort(edges);
        int mstcost=0;
        int count=0;
        for(int i=0;count<V-1;i++){
            Edge e=edges.get(i);
            //(src , dest , wt)
            // this is cycle detection step
            int parA=find(e.src);
            int parB=find(e.dest);
            // if parents are not equal then cycle is not present
            if(parA!=parB){
                mstcost+=e.wt;
                union(e.src, e.dest);
                count++;
            }
        }
        System.out.println(mstcost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createGraph(edges);
        Krushkals_MST(edges, V);
    }
}
