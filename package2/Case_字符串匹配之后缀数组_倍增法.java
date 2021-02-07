package package2;

import java.util.Arrays;
/*
*
* 高度
* 倍增
* 对后缀数组求高度的时候，
* 其满足Height[rk[i+1]] >= Height[rk[i]] - 1 ;
*
* 高度数组可用于求解字符串中的最大重叠字串问题
 */

public class Case_字符串匹配之后缀数组_倍增法 {
    public static void main(String []arr){
        suffix_find("aaabbbka" , "bka");
        Suff [] SuffixArray = Create_SuffixArray_multiplier("ABCABC") ;
        int [] array = GetHeight("ABCABC" , SuffixArray) ;

        for(int x : array){
            System.out.print(x+" ");
        }
        System.out.println("");
    }

    public static void suffix_find(String src , String p){
        if(p.length() == 0 || src.length()==0 || p.length() > src.length()){
            return;
        }

        Suff [] sb = Create_SuffixArray_multiplier(src);
        int left = 0 ;
        int right = sb.length - 1 ;
        int CompareResult = 0 ;
        while(left <= right){
            int mid = left + ( (right - left)>>1) ;
            String SuffiixString = sb[mid].str;
            if(SuffiixString.length() >= p.length()){
                CompareResult = SuffiixString.substring(0,p.length()).compareTo(p);
                if(CompareResult == 0){
                    System.out.println(sb[mid]);
                    return;
                }
            }else{
                CompareResult = SuffiixString.compareTo(p) ;
            }
            if(CompareResult > 0){
                right = mid - 1 ;
            }else if(CompareResult < 0){
                left = mid+1 ;
            }
        }
        System.out.println("-1");
    }

    public static Suff [] Create_SuffixArray_multiplier(String src){
        Suff [] SuffArray = new Suff[src.length()] ;
        int [] rk = new int[src.length()] ;
        int k = 0;

        for( k = 1 ; k <=src.length() ; k*=2){
            for(int i = 0 ; i < src.length(); i++){
                String SuffString = src.substring(i , i+k > src.length()? src.length():i+k) ;
                SuffArray[i] = new Suff(SuffString , i) ;
            }
            if(k==1){
                Arrays.sort(SuffArray);
            }else{
                int kk = k ;
                Arrays.sort(SuffArray , ((o1, o2) -> {
                    int i = o1.index ;
                    int j = o2.index ;
                    if(rk[i] == rk[j]){
                        try{
                            return rk[i+kk/2] - rk[j + kk/2] ;
                        }catch (ArrayIndexOutOfBoundsException e){
                            return o1.str.length() - o2.str.length() ;
                        }
                    }else{
                        return rk[i] - rk[j] ;
                    }

                }));
            }
            int r = 0 ;
            for(int i = 1 ; i <SuffArray.length ; i++){
                if(SuffArray[i].compareTo(SuffArray[i-1]) == 0){
                    rk[SuffArray[i].index] = r ;
                }else {
                    rk[SuffArray[i].index] = ++r;
                }
            }
        }

       return SuffArray ;
    }

    public static int [] GetHeight(String src , Suff []Suffix){
        //Suffix = Create_SuffixArray_multiplier(src) ;
        int [] rk = new int[src.length()] ;
        int [] height = new int[src.length()] ;
        int k = 0 ;

        for(int i = 0 ; i < src.length() ; i++){
            rk[Suffix[i].index] = i ;
        }

        for(int i = 0 ; i < src.length() ; i++){
            int rk_i = rk[i] ;
            if(rk_i == 0){
                height[0] = 0 ;
                continue;
            }
            int rk_i_1 = rk_i - 1 ;
            int rk_i_1_index = Suffix[rk_i_1].index ;
            for(; i+k < src.length() && rk_i_1_index + k < src.length() ; k++){
                if(src.charAt(i+k) != src.charAt(rk_i_1_index + k)){
                    break;
                }
            }
            height[rk_i] = k ;
            if(k > 0)k-- ;
        }
        return height ;
    }

}










