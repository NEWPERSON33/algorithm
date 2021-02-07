package package_dfs;

public class Case_硬币表示某个特定的值 {
    final static int N = 11 ;
    public static void main(String []args){
        System.out.println(Coin(N));
        System.out.println(Coin_recursion(N , new int[]{1 , 2 , 5 , 10 , 25}));
    }


    //递归表示

    public static int Coin(int n){
        if(n <= 0){
            return 0 ;
        }
        return Coin_n(n , new int[]{1 , 2 , 5 , 10 , 25} , 4) ;
    }

    public static int Coin_n(int n , int [] cur , int current){
        if(current == 0){
            return cur[current] ;
        }
        int res = 0 ;
        for(int i = 0 ; i * cur[current] <= n ; i++){
            res+= Coin_n(n - i * cur[current] , cur , current-1);
        }
        return res ;
    }


    //递推形式

    public static int Coin_recursion(int n , int [] cur) {
        if(n <= 0){
            return 0 ;
        }
        int [][] Matrix = new int[cur.length ][ n + 1] ;
        for(int i = 0 ; i < Matrix[0].length ; i++){
            Matrix[0][i] = 1 ;
        }

        for(int i = 0 ; i < Matrix.length ; i++){
            Matrix[i][0] = 1 ;
        }

        for(int row = 1 ; row < Matrix.length ; row++){
            for(int num = 1 ; num <= n ; num++){
                for(int k = 0 ; cur[row] * k <= num ; k++){
                    if(num < cur[row]){
                        Matrix[row][num] = Matrix[row-1][num] ;
                    }
                    else
                        Matrix[row][num] += Matrix[row-1][num - k*cur[row]] ;
                }
            }
        }
//        int i = 0 ;
//        while( i < cur.length && cur[i] <= n){
//            i++ ;
//        }
        return Matrix[cur.length - 1][n] ;
    }

}
