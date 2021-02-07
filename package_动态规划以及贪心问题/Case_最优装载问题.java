package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_最优装载问题 {
    static int N = 5 ;
    public static void main(String[] args) {
        int [] arr = new int[N];
        int Max = 0 ;
        Solution(arr , Max);
    }

    private static void Solution(int[] arr, int max) {
        Arrays.sort(arr);
        int sum = 0 ;
        int cnt = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(sum > max) {
                cnt--;
                break;
            }
            sum+=arr[i];
            cnt++;
        }
        System.out.println(cnt);
    }
}
