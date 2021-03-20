package package_Graph;
//并查集
//此题中的图为无向图
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_最小生成树之Kruskal算法 {
    public static void main(String[] args) {
        System.out.println(Solution());
        System.out.println(Solution2());
    }

    private static Map<String , EdgeNode> buildMap( EdgeMap things){//建立节点和特定数据结构的映射
        Map<String , EdgeNode>map = new HashMap<>() ;
        for (Edge e: things.edges) {
            map.put(e.from, new EdgeNode()) ;
            map.put(e.to , new EdgeNode()) ;
        }
        return map ;
    }

    private static ArrayList<Edge> Solution(){



        EdgeMap things = new EdgeMap() ;
        things.build();
        Map<String , EdgeNode> map = buildMap(things) ;
        ArrayList<Edge>re = new ArrayList<>() ;

        for (Edge e:
             things.edges) {
            if(find(map , e)){
                re.add(e) ;
            }
            if(re.size() == map.size() - 1)break;
        }
        return re ;
    }

    private static boolean find(Map<String  , EdgeNode>map ,Edge e){
        String A = e.from ;
        String B = e.to ;
        EdgeNode nodeA = map.get(A) ;
        EdgeNode nodeB = map.get(B) ;
        if(nodeA == null || nodeB == null)return false ;
        while (nodeA.parent != null){
            nodeA = nodeA.parent ;
        }
        while (nodeB.parent != null){
            nodeB = nodeB.parent ;
        }
        if(nodeA !=nodeB){
            nodeA.parent = nodeB ;
            return true ;
        }else {
            return false ;
        }
    }


    private static ArrayList<Edge> Solution2(){
        EdgeMap things = new EdgeMap() ;
        things.build();
        Map<String , EdgeNode> map = buildMap(things) ;
        ArrayList<Edge>re = new ArrayList<>() ;
        for (Edge e:
                things.edges){
            if(find2(map , e.from) != find2(map , e.to)){
                re.add(e) ;
                find2(map , e.from).parent = find2(map , e.to) ;
            }
            if(re.size() == map.size() - 1)break;
        }
        return re ;
    }

    private static EdgeNode find2(Map<String  , EdgeNode>map , String point){
        EdgeNode p = map.get(point) ;
        ArrayList<EdgeNode>nodes = new ArrayList<>() ;
        if(p == null)return null ;
        while (p.parent != null){
            nodes.add(p) ;
            p = p.parent ;
        }
        for (EdgeNode N:
             nodes) {
            N.parent = p ;
        }
        return p ;
    }


}


class EdgeNode{
    public EdgeNode parent ;

}