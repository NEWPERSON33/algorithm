package package_Graph;

/**
 * 四连通检测（四个方向）
 */
public class Case_无向图的DFS {
    public static void main(String[] args) {
        char [][] Graph = new char[10][] ;
        int [][] label = new int[10][10] ;
        int [] position = {4 , 4 , 4 , 6} ;
        String [] str = {
                "0010000000",
                "0011100000",
                "0000111110",
                "0001100010",
                "1111010010",
                "0000010010",
                "0000010011",
                "0111111000",
                "0000010000",
                "0000000000",
        } ;
        for (int i = 0; i < str.length; i++) {
            Graph[i] = str[i].toCharArray() ;
        }

        //DFS_Graph(Graph , label , position);

        System.out.println(DFS(Graph , label , position));
    }


    private static void DFS_Graph(char [][] Graph , int [][] label , int [] position){

        int y1 = position[0] ;
        int x1 = position[1] ;
        int y2 = position[2] ;
        int x2 = position[3] ;
        if(y1 == y1 && x1 == x2){
            Outcome = true ;
            return;
        }
        //上下左右依次递归
        //上
        if(x1 - 1 >= 0 && label[y1][x1 - 1] != 1 && Graph[y1][x1-1] == Graph[y1][x1] ){//不越界，未被访问，图形值相同
            label[y1][x1 - 1] = 1 ;
            position[1] = x1 - 1 ;
            DFS_Graph(Graph , label , position);
            position[1] = x1 ;
        }
        //下
        if(x1 + 1 <= Graph.length - 1 && label[y1][x1 + 1] != 1 && Graph[y1][x1 + 1] == Graph[y1][x1]){
            label[y1][x1 + 1] = 1 ;
            position[1] = x1 + 1 ;
            DFS_Graph(Graph , label , position);
            position[1] = x1 ;
        }
        //左
        if(y1 - 1 >= 0 && label[y1 - 1][x1] != 1 && Graph[y1 - 1][x1] == Graph[y1][x1]){
            label[y1 - 1][x1] = 1 ;
            position[0] = y1 - 1 ;
            DFS_Graph(Graph , label , position);
            position[0] = y1 ;
        }
        //右
        if(y1 + 1 <= Graph[0].length - 1 && label[y1 + 1][x1] != 1 && Graph[y1 + 1 ][x1] == Graph[y1][x1]){
            label[y1+ 1][x1] = 1 ;
            position[0] = y1 + 1 ;
            DFS_Graph(Graph , label , position);
            position[0] = y1 ;
        }
    }

    public static boolean Outcome = false    ;
    private static Boolean  DFS(char [][] Graph , int [][] label , int [] position){
        Outcome = false ;
        DFS_Graph(Graph , label , position);
        return Outcome ;
    }

}
