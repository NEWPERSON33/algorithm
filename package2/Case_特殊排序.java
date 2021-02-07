package package2;

import java.util.Arrays;
import java.util.Comparator;

public class Case_特殊排序 {
    public static void main(String [] arr){
        System.out.println(f(new Integer[]{3 , 32 , 321}));
    }

    public static int f(Integer[] arr){
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2 ;
                String s2 = o2 + "" + o1 ;
                return s1.compareTo(s2) ;
            }
        });
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0 ; i < arr.length ; i++){
            sb.append(arr[i]) ;
        }
        return Integer.parseInt(sb.toString()) ;
    }

}
