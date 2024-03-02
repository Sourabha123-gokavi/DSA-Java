import java.util.*;
public class Creation {
    // this is the edge which stores the information about the (src,dst,wt)
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
    
    
    
    
    
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[]graph=new ArrayList[V];// this contains the null value
        // thus store Arraylist at particular index
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        // 0 
        graph[0].add(new Edge(0, 1, 5));
        
        // 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        //4 
        graph[4].add(new Edge(4, 2, 2));

        // print the neighbours of the src 2
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.print(e.src+"->");
            System.out.println(e.dst);
        }


    }
}
