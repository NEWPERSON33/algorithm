package package2;

public class CXase_字符串匹配之KMP算法 {
    public static void main(String []arr){
        System.out.println(Kmp_Find("shuangzeng" , "uen"));
    }

    public static int Kmp_Find(String src , String p){
        if(src.length() == 0 || p.length() == 0){
            return -1 ;
        }
        if(src.length() < p.length()){
            return -1 ;
        }

        int [] next = CreateNext(p) ;
        int j = -1 ;
        int count = 0 ;
        for(int i = 0 ; i < src.length();){
//            char ch = src.charAt(i) ;
//            char ch_p = src.charAt(j) ;
            if(j == -1 || src.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j] ;
            }
            if( j == p.length()){
                i-- ;
                j = next[j-1];
                count++ ;
                //return i - p.length();
            }
        }
        return -1 ;
    }

    public static int [] CreateNext(String p ){
        int [] next = new int[p.length()] ;
        next[0] = -1 ;
        if(p.length() == 1){
            return next ;
        }
        next[1] = 0 ;
        int j = 1 ;
        int k = next[1] ;
        while(j < p.length() - 1){
            if(k < 0 || p.charAt(k) == p.charAt(j)){
                next[++j] = ++k;
                continue;
            }else{
                k = next[k] ;
            }

        }
        return next ;
    }

}
