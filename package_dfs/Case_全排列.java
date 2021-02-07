package package_dfs;

import java.util.ArrayList;

public class Case_全排列 {
    static ArrayList<String> all = new ArrayList<>() ;
    public static void main(String []args){
    System.out.println(Permutation_1("ABCD" , 3));
    System.out.println(Permutation("ABCD"));
    Permutation_2( "ABC".toCharArray() , 0);
    System.out.println(all);
    }
//递推形式
    public static ArrayList<String> Permutation(String A){
        ArrayList<String>res = new ArrayList<>() ;
        res.add(A.charAt(0)+"");
        if(A.length() == 1){
            return res ;
        }
        for(int i = 1 ; i < A.length() ; i++){
            ArrayList<String> res_new = new ArrayList<>() ;
            for(String S : res){
                res_new.add(A.charAt(i) + S) ;
                res_new.add( S + A.charAt(i));
                for(int j = 0 ; j < i -1; j++){
                    res_new.add(S.substring(0,j+1)+A.charAt(i) + S.substring(j+1)) ;
                }
//                for(int j = 1 ; j < S.length() ; j++){
//                    res_new.add(S.substring(0 , j) + A.charAt(i) + S.substring(j)) ;
//                }
            }
            res = res_new ;
        }
        return res ;
    }

    //递归形式

    public static ArrayList<String>Permutation_1(String A , int cur){
        ArrayList<String>res = new ArrayList<>() ;
        if(cur == 0){
            res.add(A.charAt(cur)+"") ;
            return res ;
        }

        ArrayList<String>res_old = Permutation_1(A , cur - 1);
        for(String S : res_old){
            res.add(A.charAt(cur)+ S) ;
            res.add(S + A.charAt(cur)) ;
            for(int j = 1 ; j < S.length() ; j++){
                res.add(S.substring(0 , j) + A.charAt(cur) + S.substring(j)) ;
            }
        }
        return res ;
    }

    //全排列之多路递归回溯

    /**
     * 经典递归执行语句执行顺序问题
     * @param arr
     * @param k
     */
    public static void Permutation_2( char [] arr , int k){
        if(k == arr.length ){
            all.add(new String(arr)) ;
        }
        for(int i = k ; i < arr.length ; i++){
            swap(arr , i  , k) ;
            Permutation_2( arr , k+1);
            swap(arr , i , k);
        }
    }

    private static void swap(char [] arr , int a , int b) {
        if(a == b){
            return;
        }
        char temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp ;
    }

}
