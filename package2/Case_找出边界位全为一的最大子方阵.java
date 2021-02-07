package package2;

public class Case_找出边界位全为一的最大子方阵 {



    public static void main(String [] arr){
        int [][]matrix = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        //genrateHelpRec(matrix);
        //print_3D_array(Rec , Rec.length);
        System.out.println(find_max_matrix(matrix , 4));
    }


    static int [][][] Rec ;
    public static void genrateHelpRec(int [][] A){
        int N = A.length ;
        int value ;
        Rec = new int [N][N][2] ;
        //对最后一行初始化
        int row = N - 1 ;
        for(int j = N - 1 ; j > -1 ; j--){
             value = A[row][j] ;
            if(value == 1){
                if(j == N - 1){
                    Rec[row][j][0] = 1 ;
                }else
                    Rec[row][j][0] = Rec[row][j + 1][0] + 1 ;
                Rec[row][j][1] = 1 ;
            }
        }

        row-- ;
        //对其余行初始化
        for(int i = row ; i > -1 ; i--){
            for(int j = N - 1 ; j > -1 ; j--){
                value = A[i][j] ;
                if(value == 1){
                    if(j == N -1){
                        Rec[i][j][0] = 1 ;
                    }else{
                        Rec[i][j][0] = Rec[i][j + 1][0] + 1 ;
                    }
                    Rec[i][j][1] = Rec[i+1][j][1] + 1 ;
                }
            }
        }
    }



    public static boolean check(int i , int j , int n){
        if(Rec[i][j][0] >= n && Rec[i][j][1] >= n && Rec[i + n - 1][j][0] >= n && Rec[i][j + n - 1][1] >= n)
            return true ;
        return false ;
    }



    public static int find_max_matrix(int [][]matrix , int N){

        genrateHelpRec(matrix);

        int n = N ;

        while(n > 0){
            for(int i = 0 ; i < N ; i++){
                if(i+n > N)break ;
                l3:
                for(int j = 0 ; j < N ; j++){
                    if(j + n > N)break ;
//                    int r = i ;
//                    int c = j ;
//                    //上
//                    while(c < j+n){
//                        if(matrix[r][c] == 0)continue l3;
//                        c++ ;
//                    }
//                    c-- ;
//                    //右
//                    while(r < i + n){
//                        if(matrix[r][c] == 0)continue l3;
//                        r++ ;
//                    }
//                    r--;
//                    //下
//                    while(c >= j){
//                        if(matrix[r][c] == 0)continue l3;
//                        c-- ;
//                    }
//                    c++ ;
//                    //左
//                    while(r >= i){
//                        if(matrix[r][c] == 0)continue l3;
//                        r-- ;
//                    }
//                    r++ ;
//                    return n ;
                    if(check(i , j , n)){
                        return n ;
                    }
                }
            }
            n-- ;
        }
        return n ;
    }

    public static void print_3D_array(int [][][] A , int N){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(A[i][j][0] + "," + A[i][j][1] + "\t");
            }
            System.out.println("");
        }
    }

}
