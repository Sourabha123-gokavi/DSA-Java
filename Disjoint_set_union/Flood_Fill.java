public class Flood_Fill {
    public int[][] helper(int[][] image,int sr,int sc,int color,boolean vis[][],int orgCol){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length|| vis[sr][sc] || image[sr][sc]!=orgCol)
        return image;

        image[sr][sc]=color;
        helper(image, sr, sc-1, color, vis, orgCol);
        helper(image, sr, sc+1, color, vis, orgCol);
        helper(image, sr-1, sc, color, vis, orgCol);
        helper(image, sr+1, sc, color, vis, orgCol);
        return image;
    }
    
    public int[][] Folldfill(int[][] image,int src,int sc,int col){
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper(image,src,sc,col,vis,image[src][sc]);
        return image;
    }


    public static void main(String[] args) {
        
    }
}
