// aaaaaa
public class Tiling{
    public static int Tile(int n){
        // base case
        if(n==0 || n==1){
            return 1;
        }
        // work to find total ways 
        int horizontal=Tile(n-1);// for horizontal 
        int vertical=Tile(n-2);// fot vertical
        int total=horizontal+vertical;// total
        return total;
    }
    public static void main(String args[]){
        System.out.print(Tile(4));
    }
}