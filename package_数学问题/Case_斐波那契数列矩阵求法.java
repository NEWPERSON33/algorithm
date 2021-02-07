package package_数学问题;

public class Case_斐波那契数列矩阵求法 {
    public static void main(String []args){
        System.out.print(Fibonacci(6)) ;
    }

    public static int [][] MatrixMultiply(int [][]M1 , int [][]M2){
        if(M1[0].length != M2.length){
            return null ;
        }
        int [][] M3= new int[M1.length][M2[0].length] ;
        for(int k = 0 ; k < M1.length ; k++){
            for(int i = 0 ; i <M2[0].length ; i++){
                for(int j = 0 ; j < M2.length ; j++){
                    M3[k][i]+=M1[k][j]*M2[j][i] ;
                }
            }
        }
        return M3 ;
    }

    public static int [][] MatrixPow(int [][]Matrix , int n){
        int [][]res = new int[Matrix.length][Matrix.length] ;
        for(int i = 0 ; i < Matrix.length ; i++){
            res[i][i] = 1 ;
        }

        while(n != 0 ){
            if((n&1)==1){
                res = MatrixMultiply(res , Matrix);
            }
            Matrix = MatrixMultiply(Matrix , Matrix) ;
            n>>=1 ;
        }
        return res ;
    }


    public static int Fibonacci(int n){
        if(n == 1 || n==2){
            return 1 ;
        }

        int [][]Matrix = {
                {0 ,1},
                {1 ,1}
        };
        int [][] re = {{1 , 1}} ;
        int [][] res = MatrixMultiply(re , MatrixPow(Matrix , n -1) ) ;
        return res[0][0] ;
    }

}
