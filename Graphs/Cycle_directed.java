import java.util.ArrayList;
import java.util.*;

import javax.swing.plaf.nimbus.State;
public class Cycle_directed{

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
        //graph[0].add(new Edge(0, 2, 1));

        // 1
        //graph[1].add(new Edge(1, 1, 1));
        //graph[1].add(new Edge(1, 3, 1));

        //2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2,3, 1));

        //3
        //graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        //graph[3].add(new Edge(3, 5, 1));

        //4
        graph[4].add(new Edge(4, 2, 1));
        //graph[4].add(new Edge(4, 3, 1));
        //graph[4].add(new Edge(4, 5, 1));

        //5
        //graph[5].add(new Edge(5, 3, 1));
        //graph[5].add(new Edge(5, 4, 1));
        //graph[5].add(new Edge(5, 6, 1));
        
        // 6
        //graph[6].add(new Edge(6, 5, 1));
    }

    public static boolean iscycle(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(iscycleUtil(graph,i,vis,stack)){
                    return true;
                }

            }

        }
        return false;
    }

    public static boolean iscycleUtil(ArrayList<Edge>[]graph,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dst]){//if the destination if already visited then
                return true;
            }
            // if the other part is not visited then we have to explore it and call it recursively for that part
            else if(!vis[e.dst] && iscycleUtil(graph,e.dst,vis,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }


    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V);
        System.out.println(iscycle(graph));
    }
}
