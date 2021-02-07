package package_dfs;

import java.util.Arrays;
import java.util.Scanner;



/**
 * 800000000
 * 003600000
 * 070090200
 * 050007000
 * 000045700
 * 000100030
 * 001000068
 * 008500010
 * 090000400
 *
 *
 * 812753649
 * 943682175
 * 675491283
 * 154237896
 * 369845721
 * 287169534
 * 521974368
 * 438526917
 * 796318452
 */


public class Case_数独游戏 {
    public static void main(String []args){
        // System.out.println((char)('0'+1));
        Scanner sc = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = sc.nextLine().toCharArray();
        }
        Soduku_dfs(table, 0, 0);
    }


    public static void Soduku_dfs(char [][] table , int x , int y){
        if(x == 9){
            print(table);
            System.exit(0);//不能用return退出，因为仅需一个解(dfs renturn后会继续搜索其兄弟)
        }

        if(table[x][y] == '0'){
            for (int i = 1; i < 10; i++) {
                if(check(table , x , y , i)){
                    table[x][y] = (char)('0'+i) ;
                    Soduku_dfs(table , x + (y+1)/9 , (y+1)%9);
                }
            }
            table[x][y] = '0' ;
        }else{
            Soduku_dfs(table , x + (y+1)/9 , (y+1)%9);
        }
    }

    private static boolean check(char[][] table, int x, int y , int target) {
        for (int i = 0; i < table.length; i++) {
            if((char)('0'+target) == table[i][y]){
                return false;
            }
        }
        for (int i = 0; i < table[0].length; i++) {
            if((char)('0'+target) == table[x][i]){
                return false ;
            }
        }
        for (int i = (x / 3)*3; i < ((x/3)*3)+3; i++) {
            for (int j = (y/3)*3; j < ((y/3)*3)+3; j++) {
                if((char)('0'+target) == table[i][j]){
                    return false ;
                }
            }
        }
        return true ;
    }

    private static boolean check_ps(char[][] table, int i, int j, int k) {
        //检查同行和同列
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) return false;
            if (table[l][j] == (char) ('0' + k)) return false;
        }
        //检查小九宫格
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) return false;
            }
        }
        return true;
    }


    public static void print(char[][]table){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
