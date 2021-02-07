package package_动态规划以及贪心问题;

import java.util.Arrays;

public class Case_区间覆盖问题 {
    static int N = 5 ;
    public static void main(String[] args) {
        int [] from = {0,8,1,2,6};
        int [] to = {2,10,4,5,10};
        interval [] in = new interval[N];
        for (int i = 0; i < N; i++) {
            in[i] = new interval(from[i] , to[i]);
        }

        Solution_2(in , 1 , 10 );
        System.out.println(Solution(in , 1 , 10));
    }


    public static int Solution(interval [] in , int begin , int end) {
        Arrays.sort(in);
        if(in[0].x > begin)return -1;
        int start = begin ;
        int flag = begin;
        int cnt = 1 ;
        for (int i = 0; i < in.length; i++) {
            int x = in[i].x ;
            int y = in[i].y ;
            if(x <= start){
                flag = y > flag ? y : flag ;
            }else{
                start = flag ;
                if(x > start)return -1 ;
                cnt++;
                flag = y > flag ? y : flag ;
            }
            if(flag >= end)return cnt ;
        }
        return -1 ;
    }

    /**
     * 老师的解法似乎有bug，
     * 第一次发现老师的bug，还有点小激动hhhhh
     * @param in
     * @param begin
     * @param T
     */
    public static void Solution_2(interval [] in , int begin , int T){//为避免出现测试bug,起点默认为1
        Arrays.sort(in);
        int start = 1;//要覆盖的目标点，end覆盖该点的所有区间中右端点最右
        int end = 1;
        int ans = 1;
        for (int i = 0; i < N; i++) {

            int s = in[i].x;
            int t = in[i].y;

            if (i == 0 && s > 1) break;

            if (s <= start) {//当前区间有可能覆盖start
                end = max(t, end);//更新更右的端点
            } else {//开始下一个区间
                ans++;//上一个目标覆盖已经达成，计数加1
                start = end ;//(start = end + 1)此为原写法，存在bug
                if (s <= start) {
                    end = max(t, end);
                } else {
                    break;
                }
            }
            if (end >= T) {//当前的end超越了线段的右侧
                break;
            }

        }
        if (end < T)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    private static int max(int t, int end) {
        return t > end ? t : end ;
    }


}


class interval implements Comparable<interval>{
    int x ;
    int y ;
    public interval(int x , int y){
        this.x = x ;
        this.y = y ;
    }

    @Override
    public int compareTo(interval o) {
        int e = x - o.x ;
        if(e == 0){
            return y - o.y;
        }
        return e;
    }
}
