package package_动态规划以及贪心问题;

public class Case_背包问题之dp解法 {
    public static void main(String[] args) {
        int [] w = {2,1,3,2};
        int [] v = {3,2,4,2} ;
        int limit = 5 ;
        Solution(w,v,limit);
    }

    private static void Solution(int[] w, int[] v, int limit) {//构造矩阵地推求解
        int [][]Martrix = new int[w.length][limit+1];//数组默认值为零
        for (int i = 0; i < Martrix.length; i++) {
            for (int j = 0; j < Martrix[0].length; j++) {
                if(j >= w[i]){
                    if(i > 0){
                        Martrix[i][j]=max(Martrix[i-1][j] , Martrix[i-1][j-w[i]]+v[i]);
                    }else{
                        Martrix[i][j] = v[i] ;
                    }
                }else if(i > 0){
                    Martrix[i][j] = Martrix[i-1][j];
                }
            }
        }
//        int MaxValue = 0 ;
//        for (int i = 0; i < Martrix.length; i++) {
//            if(Martrix[i][limit] > MaxValue){
//                MaxValue = Martrix[i][limit];
//            }
//        }
        System.out.println(Martrix[Martrix.length-1][Martrix[0].length-1]);
    }

    private static int max(int a , int b){
        return a > b ? a : b;
    }


}
