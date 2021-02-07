package package_动态规划以及贪心问题;

import java.util.Arrays;

/**
 * 区间选点问题，思路以及解法与本体类似
 *
 */
public class Case_区间调度问题 {
    static int N = 5 ;
    public static void main(String[] args) {
        int [] key = {1,2,4,6,8};
        int [] value = {3,5,7,9,10};
        job [] jo = new job[N] ;
        for (int i = 0; i < N; i++) {
            jo[i] = new job(key[i] , value[i]) ;
        }
        System.out.println(Greedy(jo));

    }

    private static int Greedy(job[] jo) {
        Arrays.sort(jo);
        int flag = 0 ;
        int cnt = 0 ;
        for (int i = 0; i < N; i++) {
            if (i - 1 < 0 || jo[flag].value < jo[i].key) {
                flag = i;
                cnt++;
            }
        }
        return cnt ;
    }


}

class job implements Comparable<job>{
    public int key ;
    public int value;
    public job(int x , int y){
        key = x ;
        value = y ;
    }

    @Override
    public int compareTo(job o) {
        int x = this.value - o.value ;
        if(x == 0)
            return this.key - o.key ;
        return x ;
    }
}
