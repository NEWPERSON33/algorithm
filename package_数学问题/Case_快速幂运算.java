package package_数学问题;

/**
 * 可利用指数的二进制对应关系:
 * 1,2,4,8 ;
 */

public class Case_快速幂运算 {
    public static void main(String []args){
        long n = pow_User(2 , 10 ) ;
    }

    public static long pow_User(long n , long m){
        long num = n ;
        long res = 1 ;
        while(m != 0){
            if((m & 1) == 1){
                res *= num ;
            }
            num *=num ;
            m = m>>1 ;
        }
        return res ;
    }

}
