package package_dfs;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.HashSet;
import java.util.Set;

public class Case_子集生成 {
    public static void main(String []args){
        int [] arr = { 1 ,2 , 3 , 4} ;
        for(Set<Integer> e: subSet_up(arr , 4 ,  3)){
            System.out.print(e + " ");
        }
    }
//递归解法
    public static Set<Set<Integer>> subSet(int [] arr , int n , int cur){
        Set<Set<Integer>>new_set = new HashSet<>() ;
        if(cur == 0){
            Set<Integer>S_1 = new HashSet<>() ;
            Set<Integer>S_2 = new HashSet<>() ;
            S_2.add(arr[cur]) ;
            new_set.add(S_1) ;
            new_set.add(S_2) ;
            return new_set ;
        }
        Set<Set<Integer>>old_set = subSet(arr , n , cur-1) ;
        for(Set<Integer> S : old_set){
            new_set.add(S) ;
            Set<Integer>clone = (Set<Integer>) ((HashSet)S).clone() ;
            clone.add(arr[cur]) ;
            new_set.add(clone) ;
        }
        return new_set;
    }
    //递推解法

    public static Set<Set<Integer>> subSet_up(int [] arr , int n , int cur){
        Set<Set<Integer>>res = new HashSet<>() ;
        Set<Integer>s = new HashSet<>() ;
        res.add(s) ;
        if(cur < 0){
            return res ;
        }


        for(int i = 0 ; i <= cur ; i++){
            Set<Set<Integer>>new_set = new HashSet<>() ;
            for(Set<Integer> e : res){
                new_set.add(e) ;
                Set<Integer>clone = (Set<Integer>) ((HashSet)e).clone();
                clone.add(arr[i]);
                new_set.add(clone) ;
            }
            res = new_set ;
        }
        return res ;

//        //从第一个元素开始处理
//        for (int i = 0; i <=cur; i++) {
//            Set<Set<Integer>> res_new = new HashSet<>();//新建一个大集合
//            res_new.addAll(res);//把原来集合中的每个子集都加入到新集合中
//            //遍历之前的集合,全部克隆一遍
//            for (Set e : res) {
//                Set clone = (Set) ((HashSet) e).clone();
//                clone.add(arr[i]);//把当前元素加进去
//                res_new.add(clone);//把克隆的子集加到大集合中
//            }
//            res = res_new;
//        }
//        return res;
    }
//示例解法
    public Set<Set<Integer>> getSubsets2(int[] A, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());//初始化为空集
        //从第一个元素开始处理
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> res_new = new HashSet<>();//新建一个大集合
            res_new.addAll(res);//把原来集合中的每个子集都加入到新集合中
            //遍历之前的集合,全部克隆一遍
            for (Set e : res) {
                Set clone = (Set) ((HashSet) e).clone();
                clone.add(A[i]);//把当前元素加进去
                res_new.add(clone);//把克隆的子集加到大集合中
            }
            res = res_new;
        }
        return res;
    }

}
