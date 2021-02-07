package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_钢条切割 {
    public static void main(String[] args) {
        //int [] l = {1,2,3,4,5,6,7,8,9,10};//下标有序，无需记录
        int [] p = {1,5,8,16,10,17,17,20,24,30};
        int length = p.length;
        int [] re = new int[length+1];
        Arrays.fill(re , -1);
        System.out.println(Solution(p , length , re));
        Solution_dp(p , length);
        Solution_dp_ps(p , length);
    }
    private static int Solution(int[] p, int length , int [] re) {
        if(length == 0)return 0 ;
        if(re[length] > -1)
            return re[length];
        int ans = 0 ;
        for (int i = 1; i <=length ; i++) {
            int v = p[i-1]+ Solution(p ,length-i , re);
            ans = max(ans,v);
            //re[length] = ans;

        }
        re[length] = ans ;
        return ans;
    }

    private static int max(int a , int b){
        return a > b ? a : b;
    }

    private static void Solution_dp(int [] p , int length){//dp递推解法
        steel [] Obj = new steel[p.length];
        for (int i = 0; i < Obj.length; i++) {
            Obj[i] = new steel(i+1 , p[i]);
        }
        Arrays.sort(Obj);
        int [][] Matrix = new int[Obj.length][length+1];
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 1; j < Matrix[0].length; j++) {
//                if(j >= Obj[i].x){
//                    if(i == 0){
//                        Matrix[i][j] = (j / Obj[i].x) * Obj[i].y;
//                    }else{
//                        Matrix[i][j] = ((j / Obj[i].x) * Obj[i].y + Matrix[i-1][j % Obj[i].x]);
//                    }
//                }else if( i > 0){
//                    Matrix[i][j] = Matrix[i-1][j] ;
//                }
                if(i==0)
                    Matrix[i][j] = (j / Obj[i].x) * Obj[i].y;
                else
                    Matrix[i][j] = ((j / Obj[i].x) * Obj[i].y + Matrix[i-1][j % Obj[i].x]);
            }
        }
        System.out.println(Matrix[Matrix.length-1][Matrix[0].length-1]);
    }

    private static void Solution_dp_ps(int [] p , int length){
        int [] axis = new int[length+1];
        for (int i = 1; i < axis.length; i++) {
            for (int j = 1; j <= i ; j++) {
                axis[i] = max(axis[i] , p[j-1]+axis[i-j]);
            }
        }
        System.out.println(axis[axis.length-1]);
    }

}

class steel implements Comparable<steel>{
    int x ;
    int y ;
    public steel(int x , int y){
        this.x = x ;
        this.y = y ;
    }
    public double GetRatio(){
        return y / (double)x ;
    }

    @Override
    public int compareTo(steel o) {
        if(this.GetRatio() < o.GetRatio())return -1;
        return 1;
    }
}
