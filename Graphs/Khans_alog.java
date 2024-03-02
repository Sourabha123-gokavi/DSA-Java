import java.util.*;
public class Khans_alog{
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

    public static void calIndegree(ArrayList<Edge>[]graph,int indegree[]){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                Edge e=graph[v].get(j);
                indegree[e.dst]++;
            }
        }
    }
    public static void Khans_algo(ArrayList<Edge>[]graph){
        int indegree[]=new int[graph.length];
        calIndegree(graph,indegree);
        Queue<Integer>q=new LinkedList<>();
        // now add the edges with indegree 0
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        // now perform normal dfs
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.println(curr);
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indegree[e.dst]--;
                if(indegree[e.dst]==0){
                    q.add(e.dst);
                }
            }

        }
        System.out.println();
    }




    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V);
        Khans_algo(graph);
    }
}