import java.util.*;
public class tarjen_algo {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void CreateGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
    }
    public static void dfs(ArrayList<Edge>graph[],int curr,int par,int dt[],
                            int low[],boolean vis[],int time){
        vis[curr]=true;
        low[curr]=dt[curr]=++time;
        // now call dfs for neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int neigh=e.dest;
            // case -1
            if(neigh==par){
                continue;// it moves to next iteration
            }
            // case -2
            if(!vis[neigh]){
                dfs(graph,neigh, curr, dt, low, vis, time);
                // update the low
                low[curr]=Math.min(dt[curr], dt[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("Bridge "+curr+" |^^^^^^| "+ neigh );
                }
            }
            // case 3
            else{
                low[curr]=Math.min(low[curr], dt[neigh]);
            }
        }
                            }

    public static void Tarjen_Bridge(ArrayList<Edge>graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        boolean vis[]=new boolean[V];
        int time=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>graph[]=new ArrayList[V];
        CreateGraph(graph);
        Tarjen_Bridge(graph, V);
    }
}
