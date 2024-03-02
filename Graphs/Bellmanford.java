// see this once again because it is giving the wrong answer
import java.util.*;
public class Bellmanford {
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s,int d,int w){
            this.src=src;
            this.dst=d;
            this.wt=w;
        }
    }
    public static void Create(ArrayList<Edge>[]graph,int V){
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        // 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1
        graph[1].add(new Edge(1, 2, -4));

        //2
        graph[2].add(new Edge(2, 3, 2));

        //3
        graph[3].add(new Edge(3, 4, 4));

        //4
        graph[4].add(new Edge(4, 1, -1));

    }
    public static void BellmanFord(ArrayList<Edge>[]graph,int src){
        //first initilaization
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        // algorithm
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            // get the edges , this 2 for loops takes O(E) time complixity
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dst;
                    int wt=e.wt;
                    // relaxation step
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        Create(graph, V);
        BellmanFord(graph,0);
    }
}
