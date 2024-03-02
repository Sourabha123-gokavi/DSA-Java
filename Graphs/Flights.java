import java.util.*;
public class Flights{
    static class Edge{
        int src;
        int dest;
        int wt;

        //constructor
        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }
    
    // creating the graph
    public static void createMap(int flights[][],ArrayList<Edge>graph[]){
        // creating the arraylist for each vertices
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        // start filling the graph
        for(int i=0;i<flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            //create new edge
            Edge e=new Edge(src, dest, wt);
            graph[src].add(e);
        }

    }
    
    static class Info{
        int v;
        int cost;
        int stops;
        // constructor
        public Info(int v,int c,int s){
            this.v=v;
            this.cost=c;
            this.stops=s;
        }
    }

    // main algorithm
    public static int cheapest_flight(int n,int flights[][],int src,int dest,int k){
        // first create graph
        ArrayList<Edge> graph[]=new ArrayList[n];
        createMap(flights, graph);
        
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        // create queue
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(0,0,0));

        while(!q.isEmpty()){
            //remove edge
            Info curr=q.remove();
            //check if the stops is equal to maximum
            if(curr.stops>k){
                break;
            }
            // else analyse neighbours
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                // relaxation step
    //- - - - - use this or 
    // |      // if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v] && curr.stops<=k){
    // |      //     dist[v]=dist[u]+wt;
    // |      //     q.add(new Info(v, dist[v],curr.stops+1));
    // |      // }
    // ----------> thyis
                if(curr.cost+wt<dist[v] && curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v],curr.stops+1));
                }
            }
        }

        // check if i have reached or not
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        int n=4;
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dest=3;
        int k=1;
        System.out.println(cheapest_flight(n, flights, src, dest, k));

    }
}