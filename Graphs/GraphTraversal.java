import java.util.*;

public class GraphTraversal {
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

    // helper function for the bfs if these are not connected
    public static void BFS(ArrayList<Edge>[]graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]){
                BFSUtil(graph,visited);
            }
        }
    }

    public static void BFSUtil(ArrayList<Edge>[]graph,boolean visited[]){
        Queue<Integer>q=new LinkedList<>();
        
        // add source
        q.add(0);
        //
        while(!q.isEmpty()){
            int curr=q.remove();// remove the element
            //if it is not visited then only do
            if(!visited[curr]){
                System.out.print(curr+" ");// print it
                visited[curr]=true;// mark it as visited
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dst);
                }
            }

        }
    }
    public static void DFS(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            DFSUtil(graph, i, vis);
        }
    }


    // dfs traversal using recurssive call
    public static void DFSUtil(ArrayList<Edge>[]graph,int curr,boolean vis[]){
        // print curr and make it visited
        System.out.print(curr+" ");
        vis[curr]=true;

        // then visit its neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);// get the edges of curr 
            if(!vis[e.dst]){// if it is not visited then only 
                DFS(graph, e.dst, vis);
            }
        }


    }




    // dfs parctice
    public static voidl DFS_(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            DFSUtil_(graph, i, vis);
        }
    }
    public static void DFSUtil_(ArrayList<Edge>[]graph,int curr,boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                DFSUtil_(graph, e.dst, vis);
            }
        }
    }


    public static void BFS_(ArrayList<Edge>[]graph){

    }

    public static void BFS_util(ArrayList<Edge>[]graph,boolean vis[],int curr){
        Queue<Integer>q=new LinkedList<>();
        //first add the source
        q.add(0);
        while(!q.isEmpty()){
            int c=q.remove();
            // if it is not visited then only do the operation
            if(!vis[c]){
                vis[c]=true;
                System.out.print(c+" ");
                for(int i=0;i<graph[c].size();i++){
                    Edge e=graph[c].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[]graph=new ArrayList[V];
        create(graph, V);
        //BFS(graph);
        DFS(graph, 0, new boolean[V]);
    }
}
