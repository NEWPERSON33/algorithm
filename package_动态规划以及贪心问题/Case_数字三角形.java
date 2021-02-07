package package_动态规划以及贪心问题;


import java.util.Arrays;

public class Case_数字三角形 {
    public static void main(String[] args) {
        int [][] Triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5},
            {4, 5, 2, 6, 5, 7},
            {4, 13, 12, 88, 6, 6, 5},
            {3, 8, 7, 11, 9, 22, 66, 3},
        };
        int [][] re = new int[Triangle.length][Triangle[Triangle.length-1].length];
        for (int i = 0; i < re.length; i++) {
            Arrays.fill(re[i],-1);
        }
        System.out.println(Solution(Triangle , 0 , 0,re));
        System.out.println(Solution_ps(Triangle , 0 , 0));
        Solution_dp(Triangle );
        Solution_dp_up(Triangle);
    }
    //static int value = 0;
    private static int Solution(int[][] triangle, int x, int y , int [][] re) {
        if(x == triangle.length - 1){
            return triangle[x][y];
        }
        if(re[x][y] != -1){
            return re[x][y];
        }
        int value1 = triangle[x][y] + Solution(triangle , x+1 , y , re);
        int value2 = triangle[x][y] + Solution(triangle , x+1 , y+1 , re);
        re[x][y] = Math.max(value1,value2);
        return Math.max(value1,value2);
    }

    private static int Solution_ps(int[][] triangle, int x, int y){
        if(x == triangle.length - 1){
            return triangle[x][y];
        }
        return triangle[x][y] + Math.max(Solution_ps(triangle,x+1,y),Solution_ps(triangle,x+1,y+1));
    }

    private static void Solution_dp(int [][] triangle ){
        int [][] Matrix = new int[triangle[triangle.length-1].length][triangle.length];
        for (int j = 0; j < Matrix[0].length; j++) {
            for (int i = 0; i < triangle[triangle.length-j-1].length; i++) {
                if(j == 0)Matrix[i][j] = triangle[triangle.length-j-1][i];
                else{
                    Matrix[i][j] = Math.max(Matrix[i][j-1] , Matrix[i+1][j-1]) + triangle[triangle.length-j-1][i];
                }
            }
        }
        System.out.println(Matrix[0][Matrix[0].length - 1]);
    }

    /**
     * 总结：慎用Math.max()方法,尽量自己写。
     * @param triangle
     */

    private static void Solution_dp_up(int [][] triangle ){//dp之滚动数组优化
        //int [][] Matrix = new int[triangle[triangle.length-1].length][triangle.length];
        int [] Matrix = new int[triangle[triangle.length-1].length];
        for (int j = 0; j < triangle.length; j++) {
            for (int i = 0; i < triangle[triangle.length-j-1].length; i++) {
                if(j == 0)Matrix[i] = triangle[triangle.length-j-1][i];
                else{
                    int value = Math.max(Matrix[i] , Matrix[i+1]) + triangle[triangle.length-j-1][i];
                    Matrix[i] = value ;
                }
            }
        }
        System.out.println(Matrix[0]);
    }

}
