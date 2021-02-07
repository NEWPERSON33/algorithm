package package_dfs;

public class Case_机器人走方格问题 {
    final static int m = 7;
    final static int n = 7 ;
    public static void main(String []args){
        System.out.println(Robot_climb(m , n));
        System.out.println(Robot_climb_recursive(m , n));
    }

    public static int Robot_climb(int x , int y){
        if(x == 1 || y == 1){
            return 1 ;
        }
        int n = x > y ? x : y ;
        //int [][]Matrix = new int[n+1][n+1];
        int [][]Matrix = new int[x+1][y+1] ;
//        for(int i = 1 ; i < n+1 ; i++){
//            Matrix[1][i] = 1 ;
//            Matrix[i][1] = 1 ;
//        }

        for(int i = 1 ; i < x + 1 ; i++){
            Matrix[i][1] = 1 ;
        }
        for(int i = 1 ; i < y + 1 ; i++){
            Matrix[1][i] = 1 ;
        }
//        for(int i = 2 ; i < n + 1 ; i++){
//            for(int j = 2 ; j <= i ; j++){
//                Matrix[i][j] = Matrix[i-1][j] + Matrix[i][j-1] ;
//                Matrix[j][i] = Matrix[j-1][i] + Matrix[j][i-1] ;
//            }
//        }
        for(int i = 2 ; i < x + 1 ; i++){
            for( int j = 2 ; j < y + 1 ; j++){
                Matrix[i][j] = Matrix[i-1][j] + Matrix[i][j-1] ;
                if(j < x + 1 && i < y + 1){
                    Matrix[j][i] = Matrix[j-1][i] + Matrix[j][i-1] ;
                }
            }
        }
        return Matrix[x][y] ;
    }

    public static int Robot_climb_recursive(int x , int y){
        if(x == 1 || y == 1){
            return 1 ;
        }
        return Robot_climb_recursive(x -1 , y) + Robot_climb_recursive(x , y - 1) ;
    }
}
