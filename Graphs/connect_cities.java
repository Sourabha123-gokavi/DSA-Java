import java.util.*;
public class connect_cities {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        // constructor
        public Edge(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        @Override 
        public int CompareTo(Edge e2){
            return this.cost-e2.cost;
        }
    }

    public static int Connect_cities(int cities[][]){
        // priority queue
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        // add source
        boolean vis[]=new boolean[cities.length];
        pq.add(new Edge(0,0));
        int finalcost=0;
        while(!pq.isEmpty()){
            Edge curr=pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest]=true;
                // analyse the neighbour
                finalcost+=curr.cost;
                for(int i=0;i<cities[curr.dest].length;i++){
                    // check if edge exists or not
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(Connect_cities(cities));
    }
}
