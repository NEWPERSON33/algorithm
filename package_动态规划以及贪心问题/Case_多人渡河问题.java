package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_多人渡河问题 {
    public static void main(String[] args) {
        int [] speed = {1 , 2 , 5 , 10};
        System.out.println(dynamic(speed.length , speed));
    }

    private static int dynamic(int length, int[] speed) {
        int n = length ;
        Arrays.sort(speed);
        int sum = 0 ;
        while (n > 0) {
            if (n == 1)
                return sum+speed[0];
            if (n == 2)
                return sum+speed[1];
            if (n == 3)
                return sum+speed[0] + speed[1] + speed[2];
            int s1 = speed[1] + speed[0] + speed[n-1] + speed[1] ;
            int s2 = 2 * speed[0] + speed[n-1] + speed[n - 2] ;
            sum+=(s1 < s2 ? s1 : s2);
            n-=2;
        }
        return -1 ;
    }
}
