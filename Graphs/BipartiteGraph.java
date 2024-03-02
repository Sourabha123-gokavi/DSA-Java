import java.util.*;

public class BipartiteGraph {
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

    // function to find if the graph is bipartite or not
    public static boolean isBipartite(ArrayList<Edge>[]graph){
        // create the colour array
        // colour code 
        // 0 -> yellow
        // 1 -> blue
        // -1 ->no colour
        int colour[]=new int[graph.length];
        for(int i=0;i<colour.length;i++){
            colour[i]=-1;
        }
        // create the queue for the bfs
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            // perform the bfs if it's colour is not coloured
            if(colour[i]==-1){
                q.add(i);
                colour[i]=0; //default the colour is yellow
                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int k=0;k<graph[curr].size();k++){
                        //check the colour
                        Edge e=graph[curr].get(k);
                        if(colour[e.dst]==-1){//no colour condition
                            int nextCol=colour[curr]==0?1:0;
                            colour[e.dst]=nextCol;
                            q.add(e.dst);
                        }
                        // if the colour of destination is same as the curr edge colour
                        else if(colour[e.dst]==colour[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V); 
        System.out.println(isBipartite(graph));
    }
}
