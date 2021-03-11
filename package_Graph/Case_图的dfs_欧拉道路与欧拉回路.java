package package_Graph;

import java.util.Stack;

/**
 * 要求：图中至多存在两个奇点
 * 不存在奇点时成为欧拉环路
 */
public class Case_图的dfs_欧拉道路与欧拉回路 {
    public static void main(String[] args) {
        int [][] Graph = {
                {0,1,2,1},
                {1,0,0,0},
                {2,0,0,1},
                {1,0,1,0}
        };
        Euler_DFS(Graph , 1);
    }

    private static void Euler_DFS(int [][] Graph , int from){
        int [][] label = new int[Graph.length][Graph[0].length] ;
        Stack<String > stack = new Stack<>() ;
        dfs(label , from , Graph , stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void dfs(int [][] label ,   int now , int [][] Graph , Stack<String >stack){
        for (int i = 0; i < Graph[0].length; i++) {
            if(Graph[now][i] > label[now][i]){
                label[now][i]++ ;
                label[i][now]++ ;
                dfs(label , i , Graph , stack);
                stack.push((char)('A' + now)+"->"+(char)('A' + i)) ;
            }
        }
        return;
    }

}
