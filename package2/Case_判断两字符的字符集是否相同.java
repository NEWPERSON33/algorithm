package package2;
import java.util.Map;

import java.util.HashMap;

public class Case_判断两字符的字符集是否相同 {
    public static void main(String []arr){
        System.out.println(cheak2("aabb" , "ab"));
    }

    public static boolean cheak(String src1 , String src2){
        int [] help = new int[256] ;
        for(int i = 0 ; i < src1.length() ; i++){
            char c = src1.charAt(i) ;
            if(help[c] == 0){
                help[c] = 1 ;
            }
        }
        for(int i = 0 ; i < src2.length() ; i++){
            char c = src2.charAt(i) ;
            if(help[c] == 0){
                return false ;
            }
        }
        return true ;
    }

    public static boolean cheak2(String src1 , String src2){
        Map<Character , Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < src1.length() ; i++){
            char c = src1.charAt(i) ;
            if(map.get(c) == null){
                map.put(c , 1) ;
            }
        }
        for(int i = 0 ; i < src2.length() ; i++){
            char c = src2.charAt(i) ;
            if(map.get(c) == null){
                return false ;
            }
        }
        return true ;
    }

}
