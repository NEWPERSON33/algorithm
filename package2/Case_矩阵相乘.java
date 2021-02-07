package package2;

public class Case_矩阵相乘 {
    public static void main(String []arr){
        int m1[][] = {
                {1,2}
        } ;
        int m2[][] = {
                {1},
                {2}
        } ;
        int [][]result = MatrixMultiply(m1 ,m2) ;
        for(int i = 0 ; i < result.length ; i++){
            for(int j = 0 ; j < result[0].length ; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int [][]MatrixMultiply(int [][]m1 , int [][]m2){
        int M = m1.length ;
        int N = m1[0].length ;
        if(N != m2.length)throw new IllegalArgumentException() ;
        int k = m2[0].length ;
        int[][]re = new int[M][k] ;
        for(int i = 0 ; i < M ; i++){
            for(int g = 0 ; g < k ; g++){
                for(int j = 0 ; j < N ; j++){
                    re[i][g]+=m1[i][j] * m2[j][g] ;
                }
            }
        }
        return re ;
    }

}
