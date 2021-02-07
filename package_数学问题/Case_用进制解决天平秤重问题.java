package package_数学问题;

import java.util.Scanner ;
import java.util.List;
import java.util.ArrayList;

/**
 * 建立核心威慑
 *
 */
public class Case_用进制解决天平秤重问题 {
    public static void main(String[] args) {
        TheBalance(20);

    }

    public static void TheBalance(int N){
        String x = Integer.toString(N , 3) ;
        char [] Array = new StringBuilder(x).reverse().toString().toCharArray() ;
        List<Integer>list = new ArrayList<>() ;

        for(int i = 0 ; i<Array.length ; i++){
            if(Array[i] == '2'){
                list.add(0 , -1);
                if(i == Array.length - 1){
                    list.add(0 , 1) ;
                }else
                    ++Array[i+1] ;
            }else if(Array[i] == '3'){
                list.add(0 , 0);
                if(i == Array.length - 1){
                    list.add(0 , 1) ;
                }else
                    ++Array[i+1] ;

            }else {
                list.add(0 , Array[i] - '0');
            }
        }
        System.out.println(list);
    }

}

