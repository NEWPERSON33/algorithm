package package_动态规划以及贪心问题;

public class Case_贪心策略以及硬币支付问题 {
    public static void main(String[] args) {
        System.out.println(Coin_Greedy(620 , 5));
    }

    static int [] coin = {1 , 5 , 10 , 50 , 100 , 500};
    static int [] cnt = {3,2,1,3,0,2} ;


    private static int Coin_Greedy(int target , int cur){
        if(cur == 0){
            return target;
        }
        if (cur <0 || target <= 0){
            return 0 ;
        }
        int n = target / coin[cur] ;
        int Co = n <= cnt[cur] ? n : cnt[cur];
        return Co + Coin_Greedy(target - Co * coin[cur] , cur-1);
    }
}
