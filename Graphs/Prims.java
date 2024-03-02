import java.nio.file.attribute.GroupPrincipal;
import java.security.spec.EdDSAParameterSpec;
import java.util.*;
public class Prims 

    static class Pair implements Comparable<Pair>
        int v;
        int cost;
        public Pair(int v,int c){
            this.v=v;
            this.c=c;
        }
        
        //to make this comparable interface
        @Override
        public int compareTo(Pair p2){
            return this.cost-this.p2;
        }
    

    public static void Prims_MST(ArrayList<Edge>[]graph)
        //create the vis array
        boolean vis[]=new boolean[graph.length];
        //now create priority queue
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        //add 0
        pq.add(new Pair(0, 0));
        int finalcost=0;
        //prims algo
        while(!pq.isEmpty())
            //remove the current pair
            Pair curr=pq.remove();
            //check if it is visited or not
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.v,e.wt));
                }
    
        System.out.println("The MST cost of the graph is = "+finalcost);
    
    public static void main(String[] args) {
        int V=4;

    }

