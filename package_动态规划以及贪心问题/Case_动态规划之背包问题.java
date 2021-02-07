package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_动态规划之背包问题 {
    public static void main(String[] args) {
        int [] w = {2,1,3,2};
        int [] v = {3,2,4,2} ;
        int limit = 5 ;
        int [][] re = new int[w.length][limit+1];
        for (int i = 0; i < re.length; i++) {
            Arrays.fill(re[i],-1);
        }
        System.out.println(dfs(w , v , 0 , limit));
        System.out.println(dp(w,v,0,limit,re));
    }

    private static int dp(int[] w, int[] v, int index, int limit, int[][] re) {//深度优先搜索之dp优化
        if(index == v.length)
            return 0;
        if(limit <= 0)
            return 0;
        if(re[index][limit] >=0)
            return re[index][limit];
        int SumofValue1= dp(w , v , index+1 , limit ,re);
        if(limit>=w[index]){
            int SumofValue2= v[index]+dp(w,v,index+1 , limit-w[index],re);
            re[index][limit] =  SumofValue2 > SumofValue1 ? SumofValue2 : SumofValue1;
            return SumofValue2 > SumofValue1 ? SumofValue2 : SumofValue1;
        }else{
            re[index][limit]= SumofValue1;
            return SumofValue1;
        }
    }

    //static int SumofValue1=0;//慎用全局变量
    //static int SumofValue2=0;
    private static int dfs(int[] w, int[] v, int index, int limit) {//深度优先搜索
        if(index == v.length)
            return 0;
        if(limit <= 0)
            return 0;
        int SumofValue1= dfs(w , v , index+1 , limit);
        if(limit>=w[index]){
           int SumofValue2= v[index]+dfs(w,v,index+1 , limit-w[index]);
            return SumofValue2 > SumofValue1 ? SumofValue2 : SumofValue1;
        }else{
            return SumofValue1;
        }
    }
}
