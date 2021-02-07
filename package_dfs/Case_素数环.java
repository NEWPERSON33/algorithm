package package_dfs;

import java.util.Scanner;



public class Case_素数环 {
    public static void main(String[] args) {//注意：curb必须为一，因为0已经被赋值
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int [] rec = new int[n] ;
        dfs(rec , n , 1);

    }

    private static void dfs(int [] rec , int r , int cur ){
        if(cur == rec.length && isPrime(rec[cur-1]+1)){
            for (int i = 0; i < rec.length; i++) {
                System.out.print(rec[i]+" ");
            }
            System.out.println("");
            return;
        }
        rec[0] = 1 ;
        for (int i = 2; i < r+1; i++) {
            if(check(rec , cur , i)){
                rec[cur] = i ;
                dfs(rec , r , cur+1);
            }
        }
    }

    private static boolean check(int[] rec, int cur , int i) {
        for (int j = 0; j < cur; j++) {
            if(rec[j] == i)return false;
        }
        return isPrime(i + rec[cur - 1]) ;
    }


    private static boolean isPrime(int num) {
        for (int i = 2; i*i <= num; i++) {
            if(num % i == 0)return false;
        }
        return true ;
    }
}
