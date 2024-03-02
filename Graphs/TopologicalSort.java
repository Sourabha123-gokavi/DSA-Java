import java.util.*;
public class TopologicalSort {
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
        //graph[0].add(new Edge(0, 1, 1));
        //graph[0].add(new Edge(0, 2, 1));

        // 1
        //graph[1].add(new Edge(1, 1, 1));
        //graph[1].add(new Edge(1, 3, 1));

        //2
        //graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2,3, 1));

        //3
        graph[3].add(new Edge(3, 1, 1));
        //graph[3].add(new Edge(3, 4, 1));
        //graph[3].add(new Edge(3, 5, 1));

        //4
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        //graph[4].add(new Edge(4, 5, 1));

        //5
        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 0, 1));
        //graph[5].add(new Edge(5, 6, 1));
        
        // 6
        //graph[6].add(new Edge(6, 5, 1));
    }

    public static void topological(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalsortUtil(graph,i,vis,s);
            }
        }
        // now printing the stack
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void topologicalsortUtil(ArrayList<Edge>[]graph,int curr,boolean vis[],Stack<Integer>s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                topologicalsortUtil(graph, e.dst, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V);
        topological(graph);
    }
}
