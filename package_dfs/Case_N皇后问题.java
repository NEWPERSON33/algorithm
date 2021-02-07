package package_dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Case_N皇后问题 {
    static int N = 4 ;
    static int cnt ;
    static List<List<Integer>>set = new ArrayList<>();
    public static void main(String[] args) {
        int [] rec = new int[N];
        cnt = 0 ;
        dfs(rec ,0);
        System.out.println(cnt);
        System.out.println(set);
    }

    private static void dfs(int []rec , int now_row) {
        if(now_row == N){
            List<Integer> new_set = new ArrayList<>();
            for (int x:rec) {
                new_set.add(x);
            }
            set.add(new_set);
            cnt++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if(c_heck(rec , now_row , col)){
                rec[now_row] = col ;
                dfs(rec , now_row+1);
                //是否回溯可选择，对结果无影响
                rec[now_row] = 0 ;
            }
        }
    }

    private static boolean c_heck(int[] rec, int now_row, int col) {
        for (int i = 0; i < now_row; i++) {
            if (rec[i] == col || i + rec[i] == now_row + col ||i - rec[i] == now_row - col){//若取绝对值会造成逻辑上错误，如4,2与2,4
                return false;
            }
        }
        return true ;
    }


//    static int n;
//    static int cnt;
//
//    static int[] rec;
//
//    public static void main(String[] args) {
//        n = 4;
//        rec = new int[4];
//        dfs(0);
//        System.out.println(cnt);
//    }
//
//    /**
//     *
//     * @param row 当前正在处理的行
//     */
//    private static void dfs(int row) {
//        if (row == n) {
//            cnt++;
//            return;
//        }
//        //依次尝试在某列上放一个皇后
//        for (int col = 0; col < n; col++) {
//            boolean ok = true;
//            //检验这个皇后是否和之前已经放置的皇后有冲突
//            for (int i = 0; i < row; i++) {
//                if (rec[i] == col || i + rec[i] == row + col || rec[i] - i == col - row) {
//                    ok = false;
//                    break;
//                }
//            }
//            /*=======这里可以认为是剪枝=======*/
//            //这一行的这一列可以放
//            if (ok) {
//                rec[row] = col; //标记
//                dfs(row + 1); //继续找下一行
//                // rec[row]=0; //恢复原状，这种解法这里是否恢复状态都行，为什么？
//            }
//        }
//    }
}

/**
 * 对于矩阵中的每个点，其坐标与其左右对角线上的点分表满足
 * 行列坐标和相等，行列坐标差相等
 */


/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

 给定一个int n，请返回方法数，保证n小于等于15
 */

