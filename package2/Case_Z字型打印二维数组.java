package package2;

public class Case_Z字型打印二维数组 {
    public static void main(String [] arr){
        int [][]matrix = {{1,2,3,4,5} , {6,7,8,9,10} } ;
        print_z(matrix);
    }

    public static void print_z(int [][] matrix){
        int r = 0 , M = matrix.length ;
        int c = 0 , N = matrix[0].length ;
        boolean l2r = true ;
        while(r < M && c < N){
            System.out.print(matrix[r][c]+",");
            if(l2r){
                if(r == 0 && c < N -1){
                    c++ ;
                    l2r = !l2r ;
                }else if(r < M - 1 && c == N - 1){
                    r++ ;
                }else{
                    r-- ;
                    c++ ;
                }
            }else{
                if(c == 0 && r < M -1 ){
                    r++ ;
                    l2r = !l2r ;
                }else if(r == M - 1 && c < N - 1){
                    c++ ;
                    l2r = !l2r ;
                }else{
                    r++ ;
                    c-- ;
                }
            }
        }
    }

}
