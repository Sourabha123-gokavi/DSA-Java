// finding the total ways to place the queens -> make static count and increment whenever 
// it reaches




public class nQueen_variations {
    static int count=0;
    public static void print(char arr[][]){
        System.out.println("------------chess board--------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }






    // condition checking isSafe to palce the queen
    public static Boolean isSafe(char arr[][],int row,int col){
        // checking the upper col
        for(int i=row-1;i>=0;i--){
            if(arr[i][col]=='Q'){
                return false;
            }

        }
        // checking the left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }

        }
        // checking the right diagonal
        for(int i=row-1,j=col+1;i>=0 &&j<arr.length;i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }

        }
        return true;
    }





    // placing queens
    public static void nQueens(char arr[][],int row){
    // base case 
    
           if(row==arr.length){
               //print(arr);
               //count++;
               return;
           }
    // main work
            for(int i=0;i<arr.length;i++){
                if(isSafe(arr,row,i))   // check condition before placing the queen
                {
                    arr[row][i]='Q';        // placing queen in right place                                  // backtracking
                    nQueens(arr, row+1);    // recursive  call to the new row 
                    arr[row][i]='X';        // backtracking
                }
            }
   
}
    public static void main(String args[]){
        int n=4;
        char arr[][]=new char[n][n];
        // board initialise to empty
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='X';
            }
        }
        nQueens(arr, 0);
        //System.out.println(count);

        //for()
    }
    
}
