package package_dfs;

import java.util.Scanner;

public class Case_困难的串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int l = sc.nextInt();
        int No = sc.nextInt();
        dfs(new String("") , l , No);

    }
   static int count = 0 ;
    private static void dfs(String prefix ,int l , int No) {
        if(count == No){
            System.out.println(prefix);
            System.exit(0);
        }
        for (char i = 'A'; i < 'A'+l; i++) {
            if(isD(prefix , i)){
                String S = prefix + i ;
                count++;
                dfs(S , l , No);
            }
        }
    }

    private static boolean isD(String prefix, char i) {
        int span = 0 ;
        for (int j = prefix.length()-1; j >=0 ; j-=2) {//判断字符串中是否有相邻的重复子串
            String S1 = prefix.substring(j , j+ span + 1);
            String S2 = prefix.substring(j + span + 1) + i ;
            if(S1.equals(S2)){
                return false;
            }
            span++;
        }
        return true;
    }


}
