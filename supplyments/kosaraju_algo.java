import java.util.*;
public class kosaraju_algo {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    // create graph
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    
    public static void topsort(ArrayList<Edge>graph[],int curr,Stack<Integer>s,boolean vis[]){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topsort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>graph[] ,int curr,boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    
    public static void Kosaraju(ArrayList<Edge>graph[],int V){
        // step 1 -> sort the graph
        Stack<Integer>s=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topsort(graph, i, s, vis);
            }
        }
        // step 2-> take transpose of the matrix
        ArrayList<Edge>transpose[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e=graph[i].get(j);// src->dest
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3 -> do dfs 
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.print("SCC ->");
                // here dfs is performed on the transpose matrix
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>graph[]=new ArrayList[V];
        createGraph(graph);
        Kosaraju(graph,V);
    }
}
