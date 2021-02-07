package package2;

import java.util.Arrays;

/**
 * 后缀数组就是排名和下标的映射 sa[0]=5 ,起始下标为5的后缀在所有字典序中最小
 * rank数组:给定后缀的下标，返回其字典序，rk[5] = 0;rk[sa[i]]=i;
 */
public class Case_字符串匹配之后缀数组 {

    public static void main(String[]arr){
        suffix_find("aaabbbba" , "bba");
    }

    public static void suffix_find(String src , String p){
        if(p.length() == 0 || src.length()==0 || p.length() > src.length()){
            return;
        }

        Suff [] sb = Create_SuffixArray(src);
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

    public static Suff [] Create_SuffixArray(String src){
        Suff [] sb = new Suff[src.length()];
        for(int i = 0 ; i < src.length() ; i++){
            sb[i] = new Suff(src.substring(i) , i) ;
        }
        Arrays.sort(sb);
        return sb ;
    }
}

class Suff implements Comparable<Suff>{
    String str ;
    int index ;

    Suff(String _str , int _index){
        str = _str ;
        index = _index ;
    }

    @Override
    public int compareTo(Suff o) {
        return this.str.compareTo(o.str);
    }

    @Override
    public String toString() {
        return "Suff{" +
                "str='" + str + '\'' +
                ", index=" + index +
                '}';
    }
}
