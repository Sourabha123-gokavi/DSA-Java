import javax.swing.event.PopupMenuListener;

public class Sudoku{
    // finding is safe function for checking the correct location or not
    public static boolean isSafe(int arr[][],int row ,int col ,int digit){
        // row checkcing 
        for(int i=0;i<9;i++){
            if(arr[row][i]==digit){
                return false;
            }
        }

        // col checking
        for(int i=0;i<9;i++){
            if(arr[i][col]==digit){
                return false;
            }
        }
        
        // checking the gird 
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int k=sr;k<sr+3;k++){
            for(int l=sc;l<sc+3;l++){
                if(arr[k][l]==digit){
                    return false;
                }
            }
        }
        return true;

    }
    

    // function to  find the sudoku exists\
    public static boolean sudoku(int arr[][],int row,int col){
        // base case
        if(row==9){
            return true;
        }
        int nextrow=row;
        int nextcol=col+1;
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        if(arr[row][col]!=0){
            return sudoku(arr, nextrow, nextcol);
        }
        
        // main work    
        for(int digit=1;digit<=9;digit++){
            if(isSafe(arr,row,col,digit)){
                arr[row][col]=digit;
                if(sudoku(arr, nextrow, nextcol))
                return true;
            }
            arr[row][col]=0;

        }
        
        
        return false;
    }
    // printing the sudoku
    public static void printsudoku(int arr[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }






    public static void main(String args[]){
        int arr[][]={
        {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,4,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}

        };
        if(sudoku(arr, 0, 0)){
            System.out.println("Solution exist");
            printsudoku(arr);
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}