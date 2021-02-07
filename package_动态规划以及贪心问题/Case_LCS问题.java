package package_动态规划以及贪心问题;


import java.util.ArrayList;


public class Case_LCS问题 {
    public static void main(String[] args) {
        String S1 = new String("3563243");
        String S2 = new String("513141");
        System.out.println(Solution(S1 , S2));
        System.out.println(Solution_Matrix(S1 , S2));
        System.out.println(Solution_dp(S1 , S2));
    }

    private static String Solution_dp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int [][] Matrix = new int[len1+1][len2+1];
        //初始化第一行
        for (int i = 1; i < Matrix[0].length; i++) {
            if(Matrix[1][i-1] == 1){
                Matrix[1][i] = 1 ;
            }else if(s1.charAt(0) == s2.charAt(i-1)){
                Matrix[1][i] = 1 ;
            }
        }
        //初始化第一列
        for (int j = 1; j < Matrix.length; j++) {
            if(Matrix[j-1][1] == 1){
                Matrix[j][1] = 1 ;
            }else if(s2.charAt(0) == s1.charAt(j - 1)){
                Matrix[j][1] = 1 ;
            }
        }
        //初始化矩阵
        for (int i = 2; i < Matrix.length; i++) {
            for (int j = 2; j < Matrix[0].length; j++) {
                int maxValue = max(Matrix[i-1][j] , Matrix[i][j-1]);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    Matrix[i][j] = max(maxValue , Matrix[i-1][j-1] + 1);
                }else{
                    Matrix[i][j] = maxValue ;
                }
            }
        }
        return print_LCS(Matrix , s1 ,s2 );
    }

    private static String print_LCS(int[][] matrix, String s1, String s2) {
        int row_intdex = matrix.length -1 ;
        int col_index = matrix[0].length -1 ;
        StringBuilder sb = new StringBuilder("");
        while (row_intdex > 0 && col_index > 0){
            if(matrix[row_intdex][col_index] > max(matrix[row_intdex-1][col_index] , matrix[row_intdex][col_index -1])){
                sb.insert(0 , s1.charAt(row_intdex - 1 ));
                row_intdex--;
                col_index--;
            }else if(matrix[row_intdex-1][col_index] >matrix[row_intdex][col_index -1]){
                row_intdex--;
            }else {
                col_index--;
            }
        }
        return sb.toString();
    }

    private static ArrayList<Character> Solution_Matrix(String s1, String s2) {//矩阵求解LCS问题，时间复杂度为n^3
        int [][] Matrix = new int[s1.length()][s2.length()];
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    Matrix[i][j] = 1 ;
                }
            }
        }
        int begin = 0 ;
        ArrayList<Character>alist = new ArrayList<>();
        //ArrayList<Character>blist = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            //blist.clear();
            ArrayList<Character>blist = new ArrayList<>();
            l2:for (int j = i; j < s2.length(); j++) {
                for (int row = begin; row < s1.length(); row++) {
                    if(Matrix[row][j] == 1){
                        blist.add(s1.charAt(row));
                        begin =row + 1;
                        if(begin == s1.length()){
                            begin = 0 ;
                            break l2;
                        }
                        break;
                    }else if(Matrix[row][j] == 0 && row == s1.length()-1 && blist.size() == 0){
                        break l2 ;
                    }
                }
            }
            if(blist.size() > alist.size()){
                alist = blist ;

            }
        }
        return alist;
    }

    private static ArrayList<Character> Solution(String s1, String s2) {
        int S1_len = s1.length();
        int S2_len = s2.length();
        ArrayList<Character>ans = new ArrayList<>() ;
        for (int i = 0; i < S1_len; i++) {
            ArrayList<Character>L1st = new ArrayList<>();
            for (int j = 0; j < S2_len; j++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    L1st.add(s1.charAt(i));
                    L1st.addAll(Solution(s1.substring(i+1) , s2.substring(j+1)));
                    break;
                }
            }
            if(L1st.size() > ans.size())
                ans = L1st ;

        }
        return ans ;
    }

    private static int max(int a , int b){
        return a > b ? a : b ;
    }

}
