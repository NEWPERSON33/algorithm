package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_乘船问题 {
    static int N = 10 ;
    public static void main(String[] args) {
        int [] arr = {1,4,5,8,8,9,10};
        Solution(arr , N);
    }

    private static void Solution(int[] arr, int n) {
        Arrays.sort(arr);
        int head = 0 ;
        int rear = arr.length-1;
        int cntofperson = arr.length ;
        int cntofboat = 0 ;
        while(cntofperson > 0){
            if(arr[head] + arr[rear] > n){
                rear--;
                cntofperson--;
                cntofboat++;
            }else{
                head++;
                rear--;
                cntofperson-=2;
                cntofboat++;
            }
        }
        System.out.println(cntofboat);
    }
}
