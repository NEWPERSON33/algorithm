package package_dfs;
import java.util.Arrays;

import static package_dfs.Case_全排列.Permutation_1;
public class Case_全排列之寻找字典序为k的元素 {
    public static void main(String []args){
        Permutation_rank(new String("") , "ABC".toCharArray() , 5);
        //System.out.println(Permutation_1("ABC" , 2));
    }
    static int count = 0 ;
    public static void Permutation_rank(String res , char [] arr , int k){
        if(res.length() == arr.length){
            count++ ;
            if(count == k){
                System.out.println("字典序为"+k+"的元素为:"+res);
                System.exit(0);
                }
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i] ;
            if(Count(res , ch) < Count(arr , ch)){
                Permutation_rank(res + ch , arr , k);
            }
        }
    }

    private static int Count(String arr, char ch) {
        int ct = 0 ;
        for (int i = 0; i < arr.length(); i++) {
            if(arr.charAt(i) == ch){
                ct++ ;
            }
        }
        return ct ;
    }

    private static int Count(char [] arr, char ch) {
        int ct = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ch){
                ct++ ;
            }
        }
        return ct ;
    }


}
