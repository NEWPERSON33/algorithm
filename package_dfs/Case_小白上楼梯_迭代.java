package package_dfs;

public class Case_小白上楼梯_迭代 {

    static final int mod = 1000000007 ;

    public static void main(String []args){
    System.out.println(Climb(4));
    }

    public static int Climb(int n){
        if(n <= 0){
            return 0 ;
        }
        if(n == 1){
            return 1 ;
        }
        if(n == 2 ){
            return 2 ;
        }
        if(n==3){
            return 4 ;
        }

        int x1 = 1 ;
        int x2 = 2 ;
        int x3 = 4 ;
        for(int i = 4 ; i  <= n ; i++){
            int x_1 = x1 ;
            x1 = x2 % mod ;
            x2 = x3 % mod ;
            x3 = ((x1 + x2) % mod + x_1) % mod ;
        }

        return x3 ;
    }

}
