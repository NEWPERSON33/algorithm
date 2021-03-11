package package_Graph;

/**目标：寻找矩阵中的@块数
 * 注意：若数组内容可以改变，贼不需要额外的标记数组
 */
public class Case_无向图的DFS_八连通搜索 {
    public static void main(String[] args) {
        char[][] Matrix = {
                "*@@*@".toCharArray(),
                "**@*@".toCharArray(),
                "****@".toCharArray(),
                "@*@*@".toCharArray(),
                "@@**@".toCharArray(),
        } ;
        char target = '@' ;
        System.out.println(DFSEight_connected(Matrix , target));
    }

    private static int DFSEight_connected(char[][]Matrix , char target){
        int cnt = 0 ;
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(Matrix[i][j] == target){
                    DFS2(Matrix , i , j , target) ;
                    cnt++ ;
                }
            }
        }
        return cnt ;
    }

    private static void DFS(char[][] matrix, int i, int j , char target) {
        //八个方向进行 ， 顺时针
        //上
        if(j - 1 >= 0 &&  matrix[i][j-1] == target){
            matrix[i][j-1] = '*' ;
            DFS(matrix , i , j - 1 , target);
        }
        //右上
        if( i + 1 <= matrix[0].length - 1 && j - 1 >= 0 && matrix[i+1][j-1] == target){
            matrix[i+1][j-1] = '*';
            DFS(matrix , i + 1 , j - 1 , target);
        }
        //右
        if(i + 1 <= matrix[0].length - 1 && matrix[i + 1 ][j] == target){
            matrix[i + 1 ][j] = '*' ;
            DFS(matrix , i + 1 , j , target);
        }
        //右下
        if(i + 1 <= matrix[0].length - 1 && j + 1 <= matrix.length - 1 && matrix[i+1][j+1] == target){
            matrix[i+1][j+1] = '*' ;
            DFS(matrix ,i+1 , j + 1 , target);
        }
        //下
        if(j + 1 <= matrix.length - 1 && matrix[i][j + 1] == target){
            matrix[i][j + 1 ] = '*' ;
            DFS(matrix , i , j + 1 , target);
        }
        //左下
        if(i - 1 >= 0 && j + 1 <= matrix.length - 1 && matrix[i - 1 ][j + 1] == target){
            matrix[i -  1][j + 1] = '*' ;
            DFS(matrix , i - 1 , j + 1 , target);
        }
        //左
        if(i - 1 >= 0 && matrix[i - 1 ][j] == target){
            matrix[i - 1 ][j] = '*' ;
            DFS(matrix , i - 1 , j , target);
        }
        //左上
        if(i - 1 >= 0 && j - 1 >= 0 && matrix[i - 1 ][j - 1] == target){
            matrix[i - 1][j - 1] = '*' ;
            DFS(matrix , i - 1 , j -1 , target);
        }
    }

    //对繁杂代码换一种写法
    private static void DFS2(char[][] matrix, int i, int j , char target){
        if(i < 0 || i >= matrix[0].length || j < 0 || j >= matrix.length)return;
        if(matrix[i][j] != target)return;
        //if(matrix[i][j] == target)matrix[i][j] = '*' ;
        matrix[i][j] = '*' ;//无需探测，此时结果必为target,所以可直接更改

        DFS2(matrix , i , j - 1 , target);
        DFS2(matrix , i + 1 , j - 1 , target);
        DFS2(matrix , i + 1 , j , target);
        DFS2(matrix ,i+1 , j + 1 , target);
        DFS2(matrix , i , j + 1 , target);
        DFS2(matrix , i - 1 , j + 1 , target);
        DFS2(matrix , i - 1 , j , target);
        DFS2(matrix , i - 1 , j -1 , target);
    }


}
