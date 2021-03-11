package package_Graph;

import java.util.Stack;
//对有向无环图的dfs算法
public class Case_图的DFS_拓扑排序 {
    public static void main(String[] args) {
        int [][]Graph = {
                {0,1,0,0},
                {0,0,0,0},
                {0,1,0,0},
                {0,0,1,0}
        };
        topological_Sort(Graph);
    }

    private static void topological_Sort(int [][] Graph){
        int [] record = new int[Graph.length] ;
        Stack<Integer> stack = new Stack<>() ;
        for (int i = 0; i < Graph.length; i++) {
            if(record[i] != 1){
                boolean flag = dfs( Graph , record , stack , i) ;
                if(!flag){
                    System.out.println("There is Loop!");
                }
            }


        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
//函数兼备检测是否有环的功能
    private static boolean dfs(int [][] Graph , int[] record, Stack<Integer> stack, int i) {
        record[i] = -1 ;
        for (int j = 0; j < record.length; j++) {
            if(Graph[i][j] > 0){
                if (record[j] == -1 )return false ;
                else if(record[j] == 0 && dfs(Graph , record , stack , j) == false)return false ;
            }
        }
        stack.add(i) ;
        record[i] = 1 ;
        return true ;
    }

}
