package package_dfs;

import java.util.Scanner;

public class Case_水洼数目 {
    public static void main(String[] args) {
        int cnt = 0 ;
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        char [][] a = new char[M][];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(a[i][j] == 'W'){
                    dfs(a,i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(char[][] a, int i, int j) {
        a[i][j] = '.';
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if(k == 0 && l == 0)
                    continue;
                if(i+k >= 0 && i+k < a.length && j+l >=0 && j+l < a[0].length){
                    if(a[i+k][j+l] == 'W')
                        dfs(a, i+k , j+l);
                }
            }
        }
    }
}
