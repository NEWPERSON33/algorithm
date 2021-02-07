package package_dfs;

import java.util.ArrayList;
import java.util.Arrays;

import static package_数学问题.Case_快速幂运算.pow_User;



public class Case_集合部分求和问题 {
    public static void main(String [] args){
        System.out.println("递推穷举:");
        calculate_check(new int[]{1,2,3,4,5} , 12);
        System.out.println("递归深搜:");
        SubSum(new int[]{1,2,3,4,5} , 0 , 12 , new ArrayList<>());
    }
//解法之子集穷举
    public static ArrayList<ArrayList<Integer>> res_Subset(int []arr , int n){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>>res = new ArrayList<>() ;
        for (long i = pow_User(2 , n) - 1; i > 0; i--) {
            ArrayList<Integer>array = new ArrayList<>() ;
            for (int j = n-1; j >= 0; j--) {
                if(((i>>j)&1) == 1){
                    array.add(arr[j]) ;
                }
            }
            res.add(array) ;
        }
        return res ;
    }

    public static void calculate_check(int [] arr , int target){
        ArrayList<ArrayList<Integer>>res = res_Subset(arr , arr.length);
        for (ArrayList<Integer> e: res) {
            int sum = 0 ;
            for (int x: e) {
                sum+=x ;
            }
            if(sum == target){
                System.out.println(e);
            }
        }
    }

    //示例递归解法

    /**
     * 树形递归样例，对于解答递归语句执行的顺序有着重大的意义
     * @param arr
     * @param cur
     * @param target
     * @param li
     */
    public static void SubSum(int [] arr , int cur , int target , ArrayList<Integer> li){
       if(target == 0){
           System.out.println(li);
           //System.exit(0);//找出一种可能
           return;//找出多种可能
       }
       if(target < 0 || cur == arr.length){
           return;
       }

       SubSum(arr,cur+1 , target , li);
       li.add(arr[cur]);
       int index = li.size()-1 ;
       SubSum(arr , cur+1 , target - arr[cur] , li);
       li.remove(index) ;
    }

}
