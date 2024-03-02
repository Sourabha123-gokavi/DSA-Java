import java.util.*;
public class Haspath{
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dst=d;
            this.wt=w;
        }
    }
    public static void create(ArrayList<Edge>[]graph,int V){
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        // 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 1, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        //4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
        // 6
        graph[6].add(new Edge(6, 5, 1));




    }
    public static boolean haspath(ArrayList<Edge>[]graph,boolean vis[],int src,int dst){
    // check if the src is equal to the destination
    if(src==dst){
        return true;
    }
    vis[src]=true;
    for(int i=0;i<graph[src].size();i++){
        Edge e=graph[src].get(i);
        // here the the e.dst means the neighbour
        if(!vis[e.dst]&& haspath(graph, vis, e.dst, dst)){
            return true;
        }
    }
    return false;
    }
public static void main(String[] args) {
    int V=7;
    ArrayList<Edge>[]graph=new ArrayList[V];
    create(graph, V);
    boolean vis[]=new boolean[7];
    System.out.println(haspath(graph,vis, 0, 5));
    

}
}