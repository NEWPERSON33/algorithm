package package_动态规划以及贪心问题;

import static java.lang.Integer.max;

public class Case_最长递增子序列 {
    public static void main(String[] args) {
        //int [] source = {4,2,3,1,5,6};
        int [] source = {1,3,4,2,8,7};
        Solution_dp(source);
        Solution_dpOptimize(source);
    }

    private static void Solution_dp(int [] source){
        int [] axis = new int[source.length];
        axis[0] = 1 ;
        for (int i = 1; i < axis.length; i++) {
            int cnt = 1 ;
            for (int j = i-1; j > -1 ; j--) {
                if(source[i] > source[j]){
                    cnt = max(cnt , axis[j] + 1);
                }
            }
            axis[i] = cnt;
        }

        int maxvalue = -1 ;
        for (int x:axis) {
            maxvalue = max(x , maxvalue);
        }
        System.out.println(maxvalue);
    }

    private static void Solution_dpOptimize(int [] source){
        int [] dp = new int[source.length];
        int index = -1 ;
        for (int i = 0; i < source.length; i++) {
            if(i == 0 || source[i] > dp[index]){
                index++;
                dp[index] = source[i];
            }else if(source[i] < dp[index]){
                int now = index ;
//                for (int j = now; j > -1; j--) {
//                    if(now == 0 || ( dp[now] > source[i] && dp[now - 1] < source[i])){
//                        dp[now] = source[i] ;
//                    }else if(dp[now] == source[i])break;
//                }
                find_n(dp , now , source[i]);//二分法查找优化
            }
        }
        System.out.println(index+1);
    }

    private static void find_n(int [] dp , int now_index , int target){
        int left = 0 ;
        int right = now_index ;
        int mid = 0 ;
        while(left <= right){
            mid = left + ((right - left)>>1) ;
            if(mid == 0 || (dp[mid] >= target && dp[mid-1] < target )){
                dp[mid] = target ;
                return;
            }else if(dp[mid] > target)right = mid -1 ;
            else if(dp[mid] < target)left = mid + 1 ;
        }
    }
    private static void find_n_up(int [] dp , int now_index , int target){//标准化写法
        int left = 0 ;
        int right = now_index ;
        int mid = 0 ;
        int in = now_index ;
        while (left <= right){
            mid = left + ((right - left)>>1);
            if(dp[mid] >= target){
                right = mid ;
            }else{
                left = mid + 1 ;
            }
        }
        dp[right] = target ;
    }

}
