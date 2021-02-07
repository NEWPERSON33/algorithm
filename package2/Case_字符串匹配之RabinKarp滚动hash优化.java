package package2;
import java.lang.Math;
import static package2.Case_字符串匹配之RabinKarp.hash;

public class Case_字符串匹配之RabinKarp滚动hash优化 {
    public static void main(String []arr){
        System.out.println("match:"+ Rb_plus("shuangzeng" , "enz"));
    }

    final static int seed = 31 ;

    public static long [] Creat_hash(String s , int n){
        long[] res = new long[s.length() - n + 1] ;
        res[0] = hash(s.substring(0,n)) ;
        for(int i = n ; i < s.length() ; i++){
            char newChar = s.charAt(i) ;
            char Ochar = s.charAt(i - n) ;
            res[i-n+1] = (res[i-n] * seed + newChar - (long)Math.pow(seed , n) * Ochar ) % Long.MAX_VALUE;
        }
        return res ;
    }

    public static int Rb_plus(String src , String p ){
        long hash_p = hash(p) ;
        long []hash_src = Creat_hash(src , p.length()) ;
        for(int i = 0 ; i < hash_src.length ; i++){
            if(hash_p == hash_src[i]){
                return i ;
            }
        }
        return -1 ;
    }

}
