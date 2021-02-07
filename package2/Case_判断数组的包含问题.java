package package2;

import java.util.Arrays;

public class Case_判断数组的包含问题 {
    public static void main(String []arr){
        String s1 = "er" ;
        String s2 = "gfdgvber" ;
        System.out.println(check(s1 ,s2) );
    }

    public static boolean check(String s1 , String s2){
        char[] s2_arr = s2.toCharArray() ;
        Arrays.sort(s2_arr) ;
        for(int i = 0 ; i < s1.length() ; i++){
            char a = s1.charAt(i) ;
            //int index = Arrays.binarySearch(s2_arr , a) ;
            int index = binary_search(s2_arr , a) ;
            if(index < 0 ){
                return false ;
            }
        }
        return true ;
    }

    public static int binary_search(char [] arr , char target){
        int begin = 0 ;
        int end = arr.length - 1 ;

        while(begin <= end){
            int mid = begin + ((end - begin)>>1) ;
            char midvual = arr[mid] ;
            if(midvual == target){
                return mid ;
            }else if(midvual > target){
                end = mid - 1 ;
            }else{
                begin = mid + 1 ;
            }
        }
        return -1 ;
    }

}
