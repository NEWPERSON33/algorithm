package package_数学问题;

import java.util.HashMap;
import java.util.Map;

public class Case_质因数分解 {
    public static void main(String []args){
        Map<Integer , Integer>map = primeFactor(34) ;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int num = entry.getKey() ;
            int k = entry.getValue() ;
            System.out.print(num+"^"+k+"  ");
        }
    }


    public static Map<Integer , Integer>primeFactor(int num){
        Map<Integer , Integer>map = new HashMap<>() ;
        for(int i = 2 ;  i<=num ; i++ ){//关于到底是用i*i还是i这件事
            while(num % i == 0){
                if(map.get(i) == null){
                    map.put(i , 1) ;
                }else{
                    map.put(i , map.get(i)+1) ;
                }
                num/=i ;
            }
        }
        return map ;
    }




//    public static Map<Integer, Integer> primeFactor_ps(int num) {
//        Map<Integer, Integer> map = new HashMap<>();//质因数-出现次数
//        for (int i = 2; i * i <= num; i++) {
//            while (num % i == 0) {
//                Integer v = map.get(i);
//                if (v == null)
//                    map.put(i, 1);
//                else
//                    map.put(i, v + 1);
//                num /= i;
//            }
//        }
//        return map;
//    }


}
