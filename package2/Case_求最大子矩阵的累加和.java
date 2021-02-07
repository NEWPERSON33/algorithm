package package2;
import java.util.Arrays;

import static package2.Case_子数组的最大累加和.find_array_max_sum_ps ;

public class Case_求最大子矩阵的累加和 {
    public static void main(String []arr){
        int [][]matrix = {
                {1,-1,-1},
                {-1,2,2},
                {-1,-1,-1}
        } ;
        System.out.println(find_matrix_sum(matrix));
    }

    public static int find_matrix_sum(int[][]matrix){
        int M = matrix.length ;
        int N = matrix[0].length ;
        int current_Row = 0 ;
        int sumj = matrix[0][0] ;
        int max = sumj ;
        int [] sums = new int[N] ;

        if(matrix.length == 0){
            return 0 ;
        }

        while(current_Row < M){
            for(int i = current_Row ; i < M ; i++){
                for(int j = 0 ; j < N ; j++){
                    sums[j]+=matrix[i][j];
                }
                sumj = find_array_max_sum_ps(sums) ;
                if(sumj > max)
                    max = sumj ;
            }
            Arrays.fill(sums , 0);
            current_Row++ ;
        }
        return max ;
    }

}
