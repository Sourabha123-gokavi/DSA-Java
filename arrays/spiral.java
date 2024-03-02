
// ggg mmmm  oooo  
public class spiral {
    public static void printSpiral(int arr[][]){
        int startRow=0;
        int endRow=arr.length-1;
        int Startcol=0;
        int endCol=arr[0].length-1;
        while(startRow<=endRow && Startcol<=endCol){
            // top
            for(int i=Startcol;i<=endCol;i++){
                // print
                System.out.print(arr[startRow][i]+" ");
            }
            // right
            for(int j=startRow+1;j<=endRow;j++){
                // print
                
                System.out.print(arr[j][endCol]+" ");
            }
            // bottom
            for(int k=endCol-1;k>=Startcol;k--){
                // print
                //condition
                if(startRow==endRow){
                    break;
                } 
                
                System.out.print(arr[endRow][k]+" ");

            }
            // left
            for(int l=endRow-1;l>startRow;l--){
                // print
                if(Startcol== endCol){
                    break;
                }
                System.out.print(arr[l][Startcol]+" ");
            }
            startRow++;
            endRow--;
            Startcol++;
            endCol--;
        }
    }
    public static void main(String args[]){
        int arr[][]={{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        printSpiral(arr);
    }
}
