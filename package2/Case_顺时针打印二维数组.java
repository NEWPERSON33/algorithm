package package2;

public class Case_顺时针打印二维数组 {
    public static void main(String []arr){
        int [][] matrix = {
                {1,2,3,4,5},
                {6,7,0,9,10},
                {5,4,3,2,1},
                {0,9,8,7,6}
        };
        //print(matrix);
        find_zero(matrix);
    }

    public static void print(int [][]matrix){
        int leftuprow = 0 , leftupcol = 0 , rightdownrow = matrix.length - 1 , rightdowncol = matrix[0].length - 1 ;
        while(leftuprow <= rightdownrow && leftupcol <= rightdowncol){
            int r = leftuprow ;
            int c = leftupcol ;
            while(c <= rightdowncol){
                System.out.print(matrix[r][c++]+",");
            }
            c = rightdowncol ;
            r++ ;
            while(r <= rightdownrow){
                System.out.print(matrix[r++][c] + ",");
            }
            r = rightdownrow ;
            c-- ;
            while(c >= leftupcol){
                System.out.print(matrix[r][c--] + ",");
            }
            c = leftupcol ;
            r-- ;
            while(r > leftuprow){
                System.out.print(matrix[r--][c] + ",");
            }
            leftupcol++ ;
            leftuprow++;
            rightdowncol-- ;
            rightdownrow-- ;
        }
    }
    public static void find_zero(int [][]matrix){
        int M = matrix.length ;
        int N = matrix[0].length ;
        int Col[] = new int[N]  ;
        int Row[] = new int[M] ;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    Row[i] = 1 ;
                    Col[j] = 1 ;
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(Row[i] == 1 || Col[j] == 1){
                    matrix[i][j] = 0 ;
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }
    }

}
