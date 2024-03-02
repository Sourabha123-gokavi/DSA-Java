import java.util.*;
public class detectcycle {
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

    // code for the detect cycle in the undirected graph
    public static  boolean DetectCycle(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(DetectCycleUtil(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DetectCycleUtil(ArrayList<Edge>[]graph,boolean vis[],int curr,int par){
        // now perform normal DFS
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            // case 3
            if(!vis[e.dst]){
                if(DetectCycleUtil(graph, vis, e.dst, curr)){
                    return true;
                }
            }
            // case 1  -> it is always true
            if(vis[e.dst]&& e.dst!=par ){
                return true;
            }

            // case 2 -> do nothing just continue
        }
        return false;
    }


    
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V); 
        System.out.println(DetectCycle(graph));
    
    }
}
