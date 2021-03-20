package package_Graph;

import java.util.Arrays;

public class Case_最短路径之Bellman_ford算法 {
    public static void main(String[] args) {
        int [] record = new int[graph.length] ;
        Arrays.fill(record , Integer.MAX_VALUE);
        record[0] = 0 ;
        while (true){
            boolean flag = false ;
            for (int i = 0; i < graph.length; i++) {
                if(record[i] == Integer.MAX_VALUE)continue;
                for (int j = 0; j < graph[0].length; j++) {
                    if(graph[i][j] != 0){
                        if(record[i] + graph[i][j] < record[j]){
                            flag = true ;
                            record[j] = record[i] + graph[i][j] ;
                        }
                    }
                }
            }
            if(!flag)break;
        }
    }

    static int[][] graph = {
            {0, 2, 5, 0, 0, 0, 0},
            {2, 0, 4, 6, 10, 0, 0},
            {5, 4, 0, 2, 0, 0, 0},
            {0, 6, 2, 0, 0, 1, 0},
            {0, 10, 0, 0, 0, 3, 5},
            {0, 0, 0, 1, 3, 0, 9},
            {0, 0, 0, 0, 5, 9, 0}
    };
}
