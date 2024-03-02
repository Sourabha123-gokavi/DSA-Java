import java.util.ArrayList;
import java.util.PriorityQueue;

public class k_nearest {
    
    static class Node implements Comparable<Node> {
        int x,y,dist,i;
        public Node(int x,int y,int dist,int i){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.i=i;
        }
        @Override
        public int compareTo(Node n2){
            return this.dist-n2.dist;
        }
    }
    
    public static void main(String []args){
        int dist[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Node>pq=new PriorityQueue<>();
        for(int i=0;i<3;i++){
            int d=dist[i][0]*dist[i][0]+dist[i][1]*dist[i][1];
            pq.add(new Node(dist[i][0], dist[i][1], d, i));
        }
        //now print k nearest cars
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().i);
        }

    }
}
