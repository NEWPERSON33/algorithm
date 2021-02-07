package package_dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static package_数学问题.Case_快速幂运算.pow_User;

public class Case__子集生成__二进制解法 {
    public static void main(String []args){
        ArrayList<ArrayList<Integer>> res =  getSubSetsByBinary(new int[]{1 , 2 , 3 , 4 , 5} , 5) ;
        System.out.println(res);
    }

    public static ArrayList<ArrayList<Integer>> getSubSetsByBinary(int []arr , int n){
//        n = arr.length;
        Arrays.sort(arr) ;
        ArrayList<ArrayList<Integer>> new_arraylist = new ArrayList<>() ;

        for(long i = pow_User(2 , n)-1 ; i>0 ; i--){
            ArrayList<Integer> arrayList = new ArrayList<>() ;
            for(int j = n - 1 ; j >=0 ; j--){
                if(((i>>j)&1) == 1){
                    arrayList.add(arr[j]) ;
                }
            }
            new_arraylist.add(arrayList) ;
        }
        return new_arraylist ;
    }

}
