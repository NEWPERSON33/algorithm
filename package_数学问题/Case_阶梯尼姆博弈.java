package package_数学问题;
import java.util.Arrays ;
import java.util.Arrays;

public class Case_阶梯尼姆博弈 {
    public static void main(String []arr){
        int [] Case_n = { 3 , 5 , 4 } ;
        System.out.println(deal(3 , Case_n));
    }

    public static boolean deal(int num , int [] arr){
        Arrays.sort(arr);
        int res = 0 ;
        if((num&1) == 0){
            for(int i = 1 ; i < arr.length ; i+=2){
                res = (arr[i] - arr[i - 1] - 1)^res ;
            }
        }else{
            //res = res^ (arr[0] - 1) ;
            for(int i = 0 ; i < arr.length  ; i+=2 ){
                res ^= (i == 0? arr[0] - 1 :  arr[i] - arr[i - 1] - 1) ;
            }
        }
        return res != 0 ;
    }

}
