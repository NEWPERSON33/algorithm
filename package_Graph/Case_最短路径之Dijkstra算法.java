package package_Graph;



public class Case_最短路径之Dijkstra算法 {
    public static void main(String[] args) {
        int [] visited = new int[graph.length] ;
        pathList [] pathLists = new pathList[graph.length] ;
        for (int i = 0; i < pathLists.length; i++) {
            pathLists[i] = new pathList() ;
            pathLists[i].val = Integer.MAX_VALUE ;
        }
        pathLists[Begin].val = 0;
        pathLists[Begin].parent = -1 ;
        int choice = Begin ;
        //int flag = Integer.MIN_VALUE ;
        //int flag_value = Integer.MAX_VALUE ;
        boolean keep_on =true ;
        while (keep_on){
            keep_on = false ;
            for (int i = 0; i < graph[0].length; i++) {
                if(graph[choice][i] != 0 && visited[i] == 0 && choice != i){
                    keep_on = true ;
                    if(pathLists[i].val > pathLists[choice].val + graph[choice][i]){
                        pathLists[i].val = pathLists[choice].val + graph[choice][i] ;
                        pathLists[i].parent = choice ;

                    }
                }
            }
            if(keep_on){
                visited[choice] = 1 ;
                //更新flag
                int flag = Integer.MAX_VALUE ;
                int index = Integer.MIN_VALUE ;
                for (int i = 0; i < pathLists.length; i++) {
                    if(visited[i]!= 1){
                        if(flag > pathLists[i].val){
                            flag = pathLists[i].val ;
                            index = i ;
                        }
                    }
                }
                if(index != Integer.MIN_VALUE){
                    choice = index ;
                }
            }

        }
        for (pathList li:
             pathLists) {
            System.out.println(li);
        }

    }

    static int Begin = 2 ;//选定起点
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

class pathList implements Comparable<pathList>{
    public int val ;
    public int parent ;//表示其直接前驱

    @Override
    public int compareTo(pathList o) {
        return this.val - o.val ;
    }

    @Override
    public String toString() {
        return "pathList{" +
                "val=" + val +
                ", parent=" + parent +
                '}';
    }
}
