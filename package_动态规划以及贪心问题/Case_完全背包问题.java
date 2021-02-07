package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_完全背包问题 {
    public static void main(String[] args) {
        int [] w = {2,1,3,2};
        int [] v = {3,2,4,2} ;
        int limit = 5 ;
        Solution_dp(w , v , limit);
    }

    private static void Solution_dp(int[] w, int[] v, int limit) {
        int[][] Matrix = new int[w.length][limit + 1];
        pack[] pa = new pack[w.length];
        for (int i = 0; i < pa.length; i++) {
            pa[i] = new pack(w[i], v[i]);
        }
        Arrays.sort(pa);
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
//                if(j > pa[i].x){
//                    if(i == 0)
//                        Matrix[i][j] = (j / pa[i].x) * pa[i].y ;
//                    else{
//                        Matrix[i][j] = (j / pa[i].x) * pa[i].y + Matrix[i-1][j%pa[i].x];
//                    }
//                }else if( i > 0){
//                    Matrix[i][j] = Matrix[i-1][j] ;
//                }
                if (i == 0)
                    Matrix[i][j] = (j / pa[i].x) * pa[i].y;
                else {
                    Matrix[i][j] = (j / pa[i].x) * pa[i].y + Matrix[i - 1][j % pa[i].x];
                }
            }
        }
        System.out.print(Matrix[w.length - 1][limit]);
    }
}
class pack implements Comparable<pack>{
    int x ;
    int y ;
    public pack(int x , int y){
        this.x = x ;
        this.y = y ;
    }
    public double GetRatio(){
        return y / (double)x ;
    }

    @Override
    public int compareTo(pack o) {
        if(this.GetRatio() < o.GetRatio())return -1;
        return 1;
    }
}
